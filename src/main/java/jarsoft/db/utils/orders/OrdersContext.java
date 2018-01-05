package jarsoft.db.utils.orders;

class OrdersContext {

    public static final String INSERT_INTO_ORDERS = "INSERT INTO orders (nomenclature, quantity, sum, user) VALUES (?,?,?,?)";
    public static final int INDEX_INT_NOMENCLATURE = 1;
    public static final int INDEX_INT_QUANTITY = 2;
    public static final int INDEX_FLOAT_SUM = 3;
    public static final int INDEX_STRING_USER = 4;

}
