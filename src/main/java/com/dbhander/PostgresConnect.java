package com.dbhander;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class PostgresConnect {
    private final String HOST = "localhost";
    private final String PORT = "5432";
    private final String DB = "proyecto1";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";

    public Connection getConnection (){
        Connection connection=null;
        try{
            Class.forName("org.postgresql.Driver");
            String url= "jdbc:postgresql://"+ HOST+":"+PORT+"/"+DB;
            connection= DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Oh, yeah!!!!!!!!!!");
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
