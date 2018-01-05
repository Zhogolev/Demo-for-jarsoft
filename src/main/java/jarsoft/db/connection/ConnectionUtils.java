package jarsoft.db.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final String URL_CONNECTION = "jdbc:mysql://";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "root";
    private static final String PORT = "3306";
    private static final String DATABASE_NAME = "db.jarsoft";
    private static final String HOST_NAME = "localhost";

    private static final String JDBC_CLASS_NAME = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return getConnection(
                URL_CONNECTION ,
                HOST_NAME,
                PORT,
                DATABASE_NAME,
                USER_NAME,
                USER_PASSWORD);
    }

    public static Connection getConnection(
            String url,
            String hostName,
            String port,
            String dbName,
            String userName,
            String userPassword) throws SQLException, ClassNotFoundException {

        String connectionURl = url + hostName + ":" + port + "/" +dbName + "?useSSL=true";
        Class.forName(JDBC_CLASS_NAME);
        Connection connection = DriverManager.getConnection(connectionURl, userName, userPassword);

        return connection;
    }

    public static Connection getConnection(
            String url,
            String hostName,
            String port,
            String userName,
            String userPassword) throws SQLException, ClassNotFoundException {

        String connectionURl = url + hostName + ":" + port;
        Class.forName(JDBC_CLASS_NAME);
        Connection connection = DriverManager.getConnection(connectionURl, userName, userPassword);

        return connection;
    }

    public static void closeConnection(Connection connection)  {
        if(connection != null){
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



