package jarsoft.db.utils.orders;

import jarsoft.model.Basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdersUtill {

    public static void acceptOrder(Basket item, String sessionID, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(OrdersContext.INSERT_INTO_ORDERS);

        preparedStatement.setString(OrdersContext.INDEX_STRING_USER, sessionID);
        preparedStatement.setInt(OrdersContext.INDEX_INT_NOMENCLATURE, item.getNomenclatureId());
        preparedStatement.setInt(OrdersContext.INDEX_INT_QUANTITY, item.getQuantity());
        preparedStatement.setFloat(OrdersContext.INDEX_FLOAT_SUM, item.getPrice());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

}
