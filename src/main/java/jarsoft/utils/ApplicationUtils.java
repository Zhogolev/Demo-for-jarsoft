package jarsoft.utils;

import jarsoft.db.connection.ConnectionUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationUtils{

    private static final String ATT_NAME_CONNECTION = "ATT_NAME_FOR_CONNECTION";
    private static final String ATT_NAME_ID_CONNECTION_IN_COOKIE = "ATT_NAME_ID_CONNECTION";

    public static void addConnectionToAttRequest(Connection connection, ServletRequest req){
        Connection lconnection = (Connection) req.getAttribute(ATT_NAME_CONNECTION);
        if(lconnection == null){
            //System.out.println(lconnection);
            req.setAttribute(ATT_NAME_CONNECTION,connection);
        }
    }

    public static Connection getConnectionFromRequestAtt(ServletRequest req) throws SQLException, ClassNotFoundException {
        Connection connection = (Connection) req.getAttribute(ATT_NAME_CONNECTION);
        return connection;
    }

    public static void addCookieToResponse(HttpServletResponse resp, int userID){
        Cookie cookie = new Cookie(ATT_NAME_ID_CONNECTION_IN_COOKIE, "" + userID);
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    public static String getIdFromRequest(HttpServletRequest req){

        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie:
                 cookies) {
                 if(cookie.getName().equals(ATT_NAME_ID_CONNECTION_IN_COOKIE)){
                     return cookie.getValue();
                 }
            }
        }
    return  null;
    }

}
