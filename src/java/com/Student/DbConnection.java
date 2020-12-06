package com.Student;
import java.sql.Connection;
import java.sql.DriverManager;

 
public class DbConnection {
    
    public Connection getConnection(){
        
        Connection conn = null;
        try{
                            System.out.println("..............Trying to connect to ORACLE database..... :) ");
                            Class.forName ("oracle.jdbc.driver.OracleDriver");
                             conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ansuya"); 
                            if(conn != null)
                                    System.out.println("..............Connected with ORACLE  ..:) ");                                    
        }catch(Exception e){
                              System.out.println("..............Could not connect with ORACLE  ...........................:) ");
        }
        return conn;
    }
}
