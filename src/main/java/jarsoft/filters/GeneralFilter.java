package jarsoft.filters;

import jarsoft.utils.ApplicationUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneralFilter implements Filter {

    private AtomicInteger cookieid ;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String tempCookieId = ApplicationUtils.getIdFromRequest((HttpServletRequest) req);

        if(tempCookieId == null){

            cookieid.addAndGet(1);
            ApplicationUtils.addCookieToResponse((HttpServletResponse) resp , cookieid.get());
           ((HttpServletResponse) resp).sendRedirect("/shop");

        }else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

        cookieid = new AtomicInteger();
        cookieid.set(0);

    }

}
