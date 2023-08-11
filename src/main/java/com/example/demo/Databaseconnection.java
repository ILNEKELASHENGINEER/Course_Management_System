package com.example.demo;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.lang.*;

public class Databaseconnection {
    public Connection databaselink;
    public Connection getConnection(){
        String databaseName="course";
        String databaseUser="root";
        String databasePassword="root";
        String url = "jdbc:mysql://localhost:3306/"+databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }
        catch(Exception e)
        {
        //e.printStackTrace();
            System.out.println("Error occured in databaseconnection");
        }
        return databaselink;
    }
}
