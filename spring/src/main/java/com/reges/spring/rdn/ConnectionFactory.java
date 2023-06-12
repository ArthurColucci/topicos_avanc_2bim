package com.reges.spring.rdn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {      
    private final String URL = "jdbc:mysql://localhost:3306/db_bibliotek";    
    private final String USER = "root";    
    private final String PASSWORD = "123@per";       
    
    public Connection getConnection()
    {
        try{                              

           return DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);            
        }
        catch(SQLException ex){       
         
             throw new RuntimeException(ex);
        }
    }                               
}