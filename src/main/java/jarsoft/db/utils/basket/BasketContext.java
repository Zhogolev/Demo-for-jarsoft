package jarsoft.db.utils.basket;

class BasketContext {

     public static final String GET_ALL_FROM_BASKET_BY_SESSION_ID =
            "SELECT * FROM (" +
                    "SELECT " +
                    "   basket.nomenclature as nomeid, " +
                    "   basket.idSession as session, " +
                    "   nomenclature.name as nomname, " +
                    "   SUM(basket.quantity) as quantity," +
                    "   SUM(CASE WHEN basket.quantity > 0 THEN nomenclature.price ELSE -nomenclature.price END) AS price " +
                    "FROM basket  left join " +
                    "   nomenclature  on " +
                    "       basket.nomenclature = nomenclature.id  " +
                    "where basket.idSession = ? " +
                    "group by basket.nomenclature  ) as middle " +
                    "where quantity > 0";

    public static final String INSERT_INTO_BASKET = "INSERT INTO basket (idSession, nomenclature, quantity) VALUES (?,?,1)";

    public static final String DELETE_FROM_BASKET = "INSERT INTO basket (idSession, nomenclature, quantity) VALUES (?,?,-1)";

    public static final String DELETE_FROM_BASKET_BY_SESSION_ID = "DELETE FROM basket where idSession = ?";
}
