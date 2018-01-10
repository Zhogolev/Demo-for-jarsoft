package jarsoft.db.utils.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//need to add user
public class UsersUtil {

    public static void addUser(String id, String phone, String name, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(UserContext.ADD_USER_QUERY);
        preparedStatement.setString(UserContext.ADD_USER_FULLNAME_INDEX, name);
        preparedStatement.setString(UserContext.ADD_USER_PHONE_INDEX, phone);
        preparedStatement.setString(UserContext.ADD_USER_STRINDID_INDEX, id);
        preparedStatement.executeUpdate();

    }
}
