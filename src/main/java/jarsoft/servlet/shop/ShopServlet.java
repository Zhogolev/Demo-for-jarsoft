package jarsoft.servlet.shop;

import jarsoft.db.utils.basket.BasketUtil;
import jarsoft.db.utils.nomenclature.NomenclatureUtil;
import jarsoft.model.Nomenclature;
import jarsoft.utils.ApplicationUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopServlet extends HttpServlet {

    private final String ATT_SHOP = "shop";
    private final String ATT_ACTION_ADD_TO_BASKET = "add_to_basket";
    private final String ATT_ID_NOMENCLATURE = "nomenclature_id";

    private final String PARAMETR_ACTION = "action";

    private final String ADRES_REQUEST_JSP = "/WEB-INF/views/shopassyst.jsp";


    private final String EMPTY_STRING = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Nomenclature> result = new ArrayList<>();
        //System.out.println("shop get");
        try {
           result =  NomenclatureUtil.getNomenclatureList(ApplicationUtils.getConnectionFromRequestAtt(req));

        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ADRES_REQUEST_JSP);
        req.setAttribute("shop",result);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }

    @Override
    public void destroy() {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.service(req,resp);
    }
}
