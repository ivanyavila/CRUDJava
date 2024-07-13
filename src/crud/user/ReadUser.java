package crud.user;

import dao.Country;
import dao.User;

import java.sql.*;

public class ReadUser {
    private final static String SELECT_STATEMENT = "SELECT * FROM user";

    public static User [] getUsers(Connection conn){
        User[] users = null;
        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery(SELECT_STATEMENT);
            rs.last();
            int count = rs.getRow();
            rs.beforeFirst();
            users = new User[count];
            int i = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");;
                String user = rs.getString("user");
                long amount = rs.getLong("amount");
                int country_id = rs.getInt("country_id");
                users[i] = new User(id, email, user,amount,country_id, conn);
                i++;
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
