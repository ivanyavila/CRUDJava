package crud.country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCountry {

    public static boolean deleteById(Connection conn, int countryId) {
        try (PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM public.country WHERE id = ?")) {
            prepStmt.setInt(1, countryId);
            if (prepStmt.executeUpdate() > 0) {
                System.out.println("Country removed successfully");
                return true;
            } else {
                System.out.println("Country not found");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
