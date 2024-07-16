package crud.customer;

import dao.Customer;

import java.sql.*;

public class ReadCustomer {
    private final static String SELECT_STATEMENT = "SELECT * FROM customer";

    public static Customer[] readAll(Connection conn){
        Customer[] users = null;
        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery(SELECT_STATEMENT);
            rs.last();
            int count = rs.getRow();
            rs.beforeFirst();
            users = new Customer[count];
            int i = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");;
                String nickname = rs.getString("nickname");
                long amount = rs.getLong("amount");
                int country_id = rs.getInt("country_id");
                users[i] = new Customer(id, email, nickname, amount, country_id, conn);
                i++;
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static Customer readByID(int userId, Connection conn){
        try (PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM customer WHERE id = ?")) {
            prepStmt.setInt(1, userId);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()){
                int id = rs.getInt("id");
                String email = rs.getString("email");;
                String nickname = rs.getString("nickname");
                long amount = rs.getLong("amount");
                int country_id = rs.getInt("country_id");
                return new Customer(id, email, nickname, amount, country_id, conn);
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
