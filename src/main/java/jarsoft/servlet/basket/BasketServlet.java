package jarsoft.servlet.basket;

import jarsoft.db.utils.basket.BasketUtil;
import jarsoft.model.Basket;
import jarsoft.utils.ApplicationUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request , response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Connection connection = ApplicationUtils.getConnectionFromRequestAtt(request);
            String sessionId = ApplicationUtils.getIdFromRequest(request);

            List<Basket> basketList = BasketUtil.getFromBasket(sessionId, connection);

            request.setAttribute("basket", basketList);
            request.setAttribute("isEmpty", basketList.size() > 0);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/basket.jsp");
            requestDispatcher.forward( request , response );

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}
