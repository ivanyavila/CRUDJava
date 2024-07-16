package crud.country;

import dao.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateCountry {

    public static boolean create(Connection conn, Country country){
        try (PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO country (abbrev, currency) VALUES(?,?)")) {
            prepStmt.setString(1, country.getAbbrev());
            prepStmt.setString(2, country.getCurrency());
            if (prepStmt.executeUpdate() > 0) {
                System.out.println("Country inserted successfully");
                return true;
            } else {
                System.out.println("Error inserting country");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
