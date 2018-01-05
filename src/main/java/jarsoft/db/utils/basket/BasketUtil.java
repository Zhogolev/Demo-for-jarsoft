package jarsoft.db.utils.basket;


import jarsoft.model.Basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jarsoft.db.utils.basket.BasketContext.DELETE_FROM_BASKET;
import static jarsoft.db.utils.basket.BasketContext.GET_ALL_FROM_BASKET_BY_SESSION_ID;
import static jarsoft.db.utils.basket.BasketContext.INSERT_INTO_BASKET;

public class BasketUtil {

    private static String COLUMN_NAME_SESSION = "session";
    private static String COLUMN_NAME_NOMENCLATURE = "nomname";
    private static String COLUMN_NAME_QUANTITY = "quantity";
    private static String COLUMN_NAME_NOMENCLATURE_ID = "nomeid";
    private static String COLUMN_NAME_PRICE = "price";

    private static int FIRST_ATT = 1;
    private static int SECOND_ATT = 2;

    public static void addToBasket(String id,String sessionId, Connection connection){
        executeQueryAddDelete( id, sessionId,  connection, INSERT_INTO_BASKET);
    }

    public  static void deleteItemFromBasket(String id,String sessionId, Connection connection){
        executeQueryAddDelete(id, sessionId, connection, DELETE_FROM_BASKET);
    }

    private static void executeQueryAddDelete(String id, String sessionId, Connection connection, String queryString) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(SECOND_ATT , Integer.parseInt(id));
            preparedStatement.setInt(FIRST_ATT , Integer.parseInt(sessionId));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  static List<Basket> getFromBasket(String sessionId ,Connection connection){

        List<Basket> result = new ArrayList<>();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement( GET_ALL_FROM_BASKET_BY_SESSION_ID );
            preparedStatement.setString( FIRST_ATT , sessionId );

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                result.add(new Basket(
                        resultSet.getFloat( COLUMN_NAME_PRICE ),
                        resultSet.getString( COLUMN_NAME_NOMENCLATURE ),
                        resultSet.getInt( COLUMN_NAME_QUANTITY ),
                        resultSet.getInt( COLUMN_NAME_NOMENCLATURE_ID ),
                        resultSet.getString( COLUMN_NAME_SESSION )));
            }
            preparedStatement.close();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void deliteFromBasketAllNodesBySessionId(String sessionId , Connection connection){

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(BasketContext.DELETE_FROM_BASKET_BY_SESSION_ID);
            preparedStatement.setString(FIRST_ATT, sessionId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}
