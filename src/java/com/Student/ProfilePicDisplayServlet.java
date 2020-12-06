package com.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ProfilePicDisplayServlet extends HttpServlet {

      String selectQuery;
    byte[] img = null;
    ServletOutputStream sos = null;
    Connection con = new DbConnection().getConnection();
     
public void service(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
          System.out.println("Inside service method..................:)");
          HttpSession session = request.getSession();
          String id = (String)session.getAttribute("ID");
            System.out.println("I am in Displaying the profile picture and my id is : "+id);
   try{       
              System.out.println("inside try block");    
              selectQuery = "select Image from Registered_students where Student_ID ='"+id+"'";
              System.out.println(selectQuery);              
              PreparedStatement ps = con.prepareStatement(selectQuery);
              ResultSet rs = ps.executeQuery();
                  while(rs.next()){
                      img = rs.getBytes(1);
                      sos = response.getOutputStream();
                      sos.write(img);
                  }
        }
       catch (Exception e)
       {
             e.printStackTrace();
       }    
}       
    
} //end of servlet class

