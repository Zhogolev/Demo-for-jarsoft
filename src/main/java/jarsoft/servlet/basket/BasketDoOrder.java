package jarsoft.servlet.basket;

import jarsoft.db.utils.basket.BasketUtil;
import jarsoft.db.utils.orders.OrdersUtill;
import jarsoft.db.utils.users.UsersUtil;
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

public class BasketDoOrder extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        String action = request.getParameter("action");

        if(action == null){
                action = "default";
        }

        if(name != null && phone != null && action.equals("accept") ){


            try {//put user by session id

                String sessionID = ApplicationUtils.getIdFromRequest(request);
                System.out.println(sessionID);
                Connection connection =  ApplicationUtils.getConnectionFromRequestAtt(request);

                UsersUtil.addUser(//String id, String phone, String name, Connection connection
                        sessionID,
                        phone,
                        name,
                        connection);
                //getting user basket by session id
                //for send it in jsp file as param.
                List<Basket> basketList = BasketUtil.getFromBasket(sessionID , connection);
                //adding to orders
                for (Basket item: basketList) {
                    OrdersUtill.acceptOrder(item, sessionID, connection);

                }
                //clear basket from order
                BasketUtil.deliteFromBasketAllNodesBySessionId(sessionID, connection);
                //send user to shop
                response.sendRedirect("../shop");

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("../error");
                request.setAttribute("error","Base error");
                requestDispatcher.forward(request,response);
            }
        }else{

            response.sendRedirect("../basket");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramSubmit = request.getParameter("make_order");

        if(paramSubmit != null){

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/basket_order.jsp");
            //request.setAttribute("totalSum", 0);
            requestDispatcher.forward(request,response);
        }
    }
}
