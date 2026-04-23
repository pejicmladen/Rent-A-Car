package rentacar.repository.connection;

/**
 *
 * @author mlade
 */
import java.sql.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseAccess {

    private static Connection connection;

//    public void connectDatabase() throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/rent_a_car";
//        String user = "root";
//        String password = "root";
//
//        try {
//            connection = DriverManager.getConnection(url, user, password);
//            System.out.println("Database successfully connected!");
//        } catch (SQLException ex) {
//            System.out.println("Error: The connection with database has not been establish!");
//            ex.printStackTrace();
//            throw ex;
//        }
//    }
//
//    public void disconnectDatabase() throws SQLException {
//        try {
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//                System.out.println("Successfully disconnected database!");
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error: connection with database was not disconnected!");
//            ex.printStackTrace();
//            throw ex;
//        }
//    }

    static {
        String url = "jdbc:mysql://localhost:3306/rent_a_car";
        String user = "root";
        String password = "root";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database successfully connected!");
        } catch (SQLException ex) {
            System.out.println("Error: The connection with database has not been establish!");
            ex.printStackTrace();
            try {
                throw ex;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Connection getConnection(){
        return connection;
    }




}
