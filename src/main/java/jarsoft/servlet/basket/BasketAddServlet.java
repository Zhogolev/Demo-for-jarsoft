package jarsoft.servlet.basket;

import jarsoft.db.utils.basket.BasketUtil;
import jarsoft.utils.ApplicationUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class BasketAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String session = ApplicationUtils.getIdFromRequest( request );

        String idNomenclature = request.getParameter("id");
        String backpage = request.getParameter("from");

        if(session != null && idNomenclature != null){
            try {
                BasketUtil.addToBasket(
                        idNomenclature ,
                        session ,
                        ApplicationUtils.getConnectionFromRequestAtt(request));

            } catch (SQLException | ClassNotFoundException e) {  e.printStackTrace(); }
        }
        response.sendRedirect(backpage == null? "/basket" : "/" + backpage);
    }
}
