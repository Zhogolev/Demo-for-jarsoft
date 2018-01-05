package jarsoft.servlet.basket;

import jarsoft.db.utils.basket.BasketUtil;
import jarsoft.utils.ApplicationUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class BasketDeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost( request , response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String session = request.getParameter("sessionid");
        String idNomenclature = request.getParameter("id");

        if(session != null && idNomenclature != null){
            try {
                BasketUtil.deleteItemFromBasket(
                        idNomenclature ,
                        session ,
                        ApplicationUtils.getConnectionFromRequestAtt(request));

            } catch (SQLException | ClassNotFoundException e) {  e.printStackTrace(); }
        }
        response.sendRedirect("/basket");
        }

}

