package jarsoft.db.utils.nomenclature;

import jarsoft.model.Nomenclature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NomenclatureUtil {

    private static final String COLUMN_NAME_ID = "id";
    private static final String COLUMN_NAME_NAME = "name";
    private static final String COLUMN_NAME_PRICE = "price";

    private static final int FIRST_ATT = 1;

    public static  List<Nomenclature> getNomenclatureList(Connection connection){

        List<Nomenclature> listNomenclature = new ArrayList<>();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(NomenclatureContext.GET_NOMENCLATURE_LIST_QUERY);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()){

                listNomenclature.add(new Nomenclature(
                       res.getInt(COLUMN_NAME_ID),
                       res.getString(COLUMN_NAME_NAME),
                       res.getFloat(COLUMN_NAME_PRICE)));
            }
            return listNomenclature;

        } catch (SQLException e) {
            e.printStackTrace();
            return listNomenclature;
        }

    }
    public static Nomenclature getNomenclatyreById(String id,Connection connection){

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(NomenclatureContext.GET_NOMENCLATURE_BY_ID_QUERY);
            preparedStatement.setInt(FIRST_ATT,Integer.parseInt(id));
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()){

                return new Nomenclature(
                        res.getInt(COLUMN_NAME_ID),
                        res.getString(COLUMN_NAME_NAME),
                        res.getFloat(COLUMN_NAME_PRICE));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}
