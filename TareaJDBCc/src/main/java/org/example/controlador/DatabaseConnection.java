package org.example.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

   private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
   private static String user = "USUARIOTAREA";
   private static String pass = "USUARIOTAREA";

   private static Connection conn;

    public static Connection getInstace() throws SQLException {
        if(conn==null){
            conn = DriverManager.getConnection(url,user,pass);
        }
        return conn;
    }
}
