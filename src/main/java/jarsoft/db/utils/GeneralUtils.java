package jarsoft.db.utils;

import jarsoft.db.connection.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneralUtils {

    private static void executePS(Connection connection, String sqlCreateQuery) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlCreateQuery);
        statement.close();
    }

    public static void createBases(String url, String hostName, String dbName, String port, String user, String password) throws SQLException, ClassNotFoundException {

        String sqlCreateQuery = "CREATE DATABASE IF NOT EXISTS `" + dbName + "`;";
        System.out.println(sqlCreateQuery);
        Connection connection = ConnectionUtils.getConnection(url, hostName, port, user, password);
        System.out.println(connection);

        executePS(connection, sqlCreateQuery);
        connection.close();

        connection = ConnectionUtils.getConnection(url, hostName, port, dbName, user, password);

        createNomenclatureTable(connection);

        createBasketTable(connection);

        createOrdersTable(connection);

        createUsersTable(connection);

        connection.close();
    }

    private static void createBasketTable(Connection connection) throws SQLException {

        String sqlCreateQuery = "CREATE TABLE if not exists basket ( id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                "idSession VARCHAR(2000) NOT NULL, nomenclature INT(11) NOT NULL, " +
                "quantity INT(11) DEFAULT '1' NOT NULL);";

        executePS(connection, sqlCreateQuery);
    }

    private static void createOrdersTable(Connection connection) throws SQLException {

        String sqlCreateQuery = "CREATE TABLE if not exists orders(" +
                " id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                " nomenclature INT(11) NOT NULL, " +
                " quantity INT(11)," +
                " sum FLOAT, " +
                " user VARCHAR(200) NOT NULL); ";

        executePS(connection, sqlCreateQuery);
    }

    private static void createNomenclatureTable(Connection connection) throws SQLException {

        String sqlCreateQuery = "CREATE TABLE if not exists nomenclature(" +
                "id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                "name VARCHAR(200) NOT NULL," +
                "price FLOAT(15,2) NOT NULL);";

        executePS(connection, sqlCreateQuery);

    }

    private static void createUsersTable(Connection connection) throws SQLException {

        String sqlCreateQuery = "CREATE TABLE if not exists users( " +
                "id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                "fullname VARCHAR(2000) NOT NULL," +
                "contact VARCHAR(200) NOT NULL, " +
                "stringid VARCHAR(200) NOT NULL);";

        executePS(connection, sqlCreateQuery);


    }

    public static void addSampleShopData(Connection connection) throws SQLException {


        String sqlInsertNomenclatureQuery = "INSERT INTO nomenclature (name, price) VALUES(?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertNomenclatureQuery);

        try {

            preparedStatement.setString(1, "Samsong GLAXY 3");
            preparedStatement.setFloat(2, (float) 1000.00);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Samsong GLAXY 4");
            preparedStatement.setFloat(2, (float) 13000.40);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Samsong GLAXY 5");
            preparedStatement.setFloat(2, (float) 17000.30);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Samsong GLAXY 6");
            preparedStatement.setFloat(2, (float) 22000.77);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Samsong GLAXY 8");
            preparedStatement.setFloat(2, (float) 80000.00);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "myPhone 4");
            preparedStatement.setFloat(2, (float) 8000.20);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "myPhone SEL");
            preparedStatement.setFloat(2, (float) 19000.51);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "myPhone 12");
            preparedStatement.setFloat(2, (float) 129000.99);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            /*this exception meen that sample data already exists */
        }finally {
            preparedStatement.close();
        }

    }
}
