package jarsoft.filters;

import jarsoft.db.connection.ConnectionUtils;
import jarsoft.db.utils.GeneralUtils;
import jarsoft.utils.ApplicationUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class ConnectionFilter implements Filter {

    private String dbName;
    private String port;
    private String hostName;
    private String user;
    private String password;
    private String url;
    private boolean createSampleData;

    @Override
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        if (this.needJDBC(req)) {
            Connection connection = null;
            try {
                connection = ConnectionUtils.getConnection(url, hostName, port, dbName, user, password);
                connection.setAutoCommit(false);

                ApplicationUtils.addConnectionToAttRequest(connection, req);
                chain.doFilter(req, resp);
                connection.commit();

            } catch (SQLException | ClassNotFoundException e) {

                throw new ServletException("JDBC driver was not found in Connection filter");

            } finally {

                ConnectionUtils.closeConnection(connection);

            }
        } else {

            chain.doFilter(req, resp);

        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

        System.out.println("start init con filter");

        this.dbName = config.getInitParameter("DB_NAME");
        this.hostName = config.getInitParameter("HOST_NAME");
        this.port = config.getInitParameter("PORT");
        this.user = config.getInitParameter("USER_NAME");
        this.password = config.getInitParameter("USER_PASSWORD");
        this.url = config.getInitParameter("URL_CONNECTION");

        String valueStringCreateSampleData = config.getInitParameter("CREATE_SAMPLE_DATA");

        if (valueStringCreateSampleData != null) {
            this.createSampleData = valueStringCreateSampleData.toUpperCase().equals("Y");
        }

        try {

            GeneralUtils.createBases(url, hostName, dbName, port, user, password);

            if (createSampleData) {
                Connection connection = ConnectionUtils.getConnection(url, hostName, port, dbName, user, password);
                GeneralUtils.addSampleShopData(connection);
                connection.close();
            }

            System.out.println("customers_db has successfully been created");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Can not crate db");
            e.printStackTrace();
        }

        //after init need to create base ofc, if not exist


    }

    private boolean needJDBC(ServletRequest req) {

        HttpServletRequest request = (HttpServletRequest) req;


        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String urlPattern = servletPath;

        if (pathInfo != null) {
            urlPattern = servletPath + "/*";
        }

        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
                .getServletRegistrations();

        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }


}
