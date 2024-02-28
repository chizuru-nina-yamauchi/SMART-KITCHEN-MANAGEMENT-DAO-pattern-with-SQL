package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:postgresql://localhost:5432/smart_kitchen";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    /*
     *  Get a connection to database
     * @return Connection object
     *
     * */

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Build the connection string, and get a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException ex) {
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn; // Return the connection object

    }
    /**
     * Test the connection
     * */

    public static void main (String[]args){
        Connection connection = getConnection();


    }

}