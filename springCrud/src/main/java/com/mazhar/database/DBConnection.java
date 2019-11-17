package com.mazhar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBConnection {
     private Connection connection = null;
     private static DBConnection connectorManager = null;
     
     public void createConnection() throws SQLException {
    	 connection =  DriverManager.
               getConnection("jdbc:mysql://localhost/facebookbot?userUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
     }
     
     
     public static DBConnection getConnectorManager(){
       if(connectorManager==null){
           connectorManager= new DBConnection();
       }
       return connectorManager;
   }
     public Connection getDBConnecton() throws SQLException {
       if (connection == null) {
           createConnection();
       }

       return connection;
   }
     
     public static Connection getInitialize(){
         try {
             return DBConnection.getConnectorManager().getDBConnecton();
         } catch (SQLException ex) {
             return null;
         }
     }
}
