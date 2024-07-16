package crud.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCustomer {

    public static boolean deleteById(Connection conn, int userId) {
        try (PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM customer WHERE id = ?")) {
            prepStmt.setInt(1, userId);
            if (prepStmt.executeUpdate() > 0) {
                System.out.println("User removed successfully");
                return true;
            } else {
                System.out.println("User not found");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
