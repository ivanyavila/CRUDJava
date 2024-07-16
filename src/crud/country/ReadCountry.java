package crud.country;

import dao.Country;

import java.sql.*;

public class ReadCountry {

    public static Country[] readAll(Connection conn){
        Country[] countries = null;
        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM public.country");
            rs.last();
            int count = rs.getRow();
            rs.beforeFirst();
            countries = new Country[count];
            int i = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String abbrev = rs.getString("abbrev");
                String currency = rs.getString("currency");
                countries[i] = new Country(id, abbrev, currency);
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }

    public static Country readByID(int countryId,Connection conn){
        try (PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM public.country WHERE id = ?")) {
            prepStmt.setInt(1, countryId);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("country");
                String currency = rs.getString("currency");
                return new Country(id, name, currency);
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
