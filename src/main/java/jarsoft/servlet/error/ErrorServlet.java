package jarsoft.servlet.error;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getAttribute("error") == null){
            request.setAttribute("error", "bad request");
        }
        System.out.println("sad");
        request.getRequestDispatcher("/WEB-INF/views/error.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request,response);
    }
}
