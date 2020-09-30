package controler;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionManager {
    Connection connection;

    public ConnectionManager() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankdb?serverTimezone=UTC",
                    "root",
                    "rootroot");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //            statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT * FROM user;");

}
