package crud.country;

import dao.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCountry {

    public static boolean update(Connection conn, Country country){
        try (PreparedStatement prepStmt = conn.prepareStatement("UPDATE public.country SET abbrev = ?, currency = ? WHERE id = ?")) {
            prepStmt.setString(1, country.getAbbrev());
            prepStmt.setString(2, country.getCurrency());
            prepStmt.setInt(3, country.getId());
            if (prepStmt.executeUpdate() > 0) {
                System.out.println("Country updated successfully");
                return true;
            } else {
                System.out.println("Error updating country");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
