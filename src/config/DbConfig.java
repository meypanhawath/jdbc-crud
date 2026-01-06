package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    private static Connection conn;

    // Invoke Connection
    public static Connection getInstance(){
        return conn;
    }

    // Initialize singleton object (only 1 time)
    public static void init() {
        if (conn == null) {
            try{
                // Step 1 : Load Driver
                Class.forName("org.postgresql.Driver");

                // Step 2 : Establish Connection
                String url = "jdbc:postgresql://localhost:5432/postgres";
                String user = "postgres";
                String password = "raz123";
                conn = DriverManager.getConnection(url, user, password);

                System.out.println(conn.getSchema());
            }catch (ClassNotFoundException e){
                System.out.println("Class not found : " + e.getMessage());
            }catch (SQLException e){
                System.out.println("SQL error : " + e.getMessage());
            }
        } else System.out.println("Connection already Initialized");
    }
}
