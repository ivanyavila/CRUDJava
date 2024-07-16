package crud.customer;

import dao.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateCustomer {

    public static boolean create(Connection conn, Customer user){
        try (PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO customer (email, nickname, amount, country_id) VALUES(?,?,?,?)")) {
            prepStmt.setString(1, user.getEmail());
            prepStmt.setString(2, user.getNickname());
            prepStmt.setLong(3, user.getAmount());
            prepStmt.setInt(4, user.getCountry().getId());
            if (prepStmt.executeUpdate() > 0) {
                System.out.println("User inserted successfully");
                return true;
            } else {
                System.out.println("Error inserting user");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
