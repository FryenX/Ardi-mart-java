package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class constant {

    private static final String DB_URL = "jdbc:sqlite:ardi-mart-0.0.1.db"; // Replace with your database URL
    private static Connection conn = null;

    // Make the connection static to be accessed globally
    public static Connection connect() {
        if (conn == null) {
            try {
                Class.forName("org.sqlite.JDBC");  // Correct class name for SQLite JDBC
                conn = DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                System.err.println("Connection failed: " + e.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(constant.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

    // Optional: Add method to explicitly close the connection
    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(constant.class.getName()).log(Level.SEVERE, "Error closing connection: " + e.getMessage(), e);
        }
    }
}
