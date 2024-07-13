import conn.PostgreSQLConnection;
import crud.country.ReadCountry;
import crud.user.ReadUser;
import dao.Country;
import dao.User;
import utils.Print;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = PostgreSQLConnection.getConnection();

        Country[] countries = ReadCountry.getCountries(conn);
        Print.array(countries);

        User[] users = ReadUser.getUsers(conn);
        Print.array(users);

        PostgreSQLConnection.closeConnection();
    }
}