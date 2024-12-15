
package com.liverpool.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static DataBaseConnection instance;
    private Connection connection = null;
     
    private DataBaseConnection(){
    }
    
    public static DataBaseConnection getInstance(){
        if(instance == null){
            instance = new DataBaseConnection();
        }
        return instance;
    }
    
    public void connectToDataBase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/workforces?zeroDateTimeBehavior=CONVERT_TO_NULL", "root","");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            System.out.println("Here is the main error");
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    
    
}
