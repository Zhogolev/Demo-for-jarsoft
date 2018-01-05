package jarsoft.db.utils.users;

class UserContext {

    public static final String ADD_USER_QUERY = "INSERT into users (fullname, contact, stringid) values (?,?,?)";
    public static final int ADD_USER_FULLNAME_INDEX = 1;
    public static final int ADD_USER_PHONE_INDEX = 2;
    public static final int ADD_USER_STRINDID_INDEX = 3;

}
