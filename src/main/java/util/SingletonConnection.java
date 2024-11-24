package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;
    
    static {
        try {
         
            Class.forName("com.mysql.cj.jdbc.Driver");
            
         
        	String url = "jdbc:mysql://localhost:3306/jee_tp";

            String user = "root";
            String password = "";
            
         
            connection = DriverManager.getConnection(url, user, password);
            
            if (connection != null) {
                System.out.println("Con succès!");
            } else {
                System.out.println("mochkil f bd!");
            }
            
        } catch (ClassNotFoundException e) {
           
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur  : " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
             	String url = "jdbc:mysql://localhost:3306/jee_tp";
                String user = "root";
                String password = "";
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}