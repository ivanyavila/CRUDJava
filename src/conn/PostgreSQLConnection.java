package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {
    // PostgreSQL connection details
    static String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres";
    static String user = "postgres.qekyrenqcoehdzlozrsd";
    static String password = "wSzl6yPfmgX4WUUk";

    static Connection conn;
    public static Connection getConnection() {
        try {
            // Register the PostgreSQL driver
            Class.forName("org.postgresql.Driver");
            // Get the connection
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database server successfully.");
                return conn;
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection() {
        if (conn == null) {
            System.out.println("Connection null.");
            return;
        }
        try {
            conn.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}