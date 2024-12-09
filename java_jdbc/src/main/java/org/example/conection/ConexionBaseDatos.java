package org.example.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
  private static   String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Montevideo";
   private static String user = "root";
   private static String pass = "sasa";
   private static Connection conn;

   public static Connection getInstance() throws SQLException {
       if (conn == null) {
           conn = DriverManager.getConnection(url, user, pass);
       }
       return conn;
   }
}
