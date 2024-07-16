package crud.customer;

import dao.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCustomer {

    public static boolean update(Connection conn, Customer user){
        try (PreparedStatement prepStmt = conn.prepareStatement("UPDATE customer SET email = ?, nickname = ?, amount =  ?, country_id = ? WHERE id = ?")) {
            prepStmt.setString(1, user.getEmail());
            prepStmt.setString(2, user.getNickname());
            prepStmt.setLong(3, user.getAmount());
            prepStmt.setInt(4, user.getCountry().getId());
            prepStmt.setInt(5, user.getId());
            if (prepStmt.executeUpdate() > 0) {
                System.out.println("User updated successfully");
                return true;
            } else {
                System.out.println("Error updating User");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
