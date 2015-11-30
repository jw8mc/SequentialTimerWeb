package sequentialTimer.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Jen on 11/29/2015.
 */
public class Database {

    private static Database instance = new Database();
    private Connection connection;

    private Database() {}

    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            throw new Exception("Error: MySQL Driver not found.");
        }

        String url = "jdbc:mysql://localhost:3306/SequentialTimerApp";
        connection = DriverManager.getConnection(url, "root", "root");
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqle) {
                System.out.println("Error: Cannot close connection");
            }
        }

        connection = null;
    }
}
