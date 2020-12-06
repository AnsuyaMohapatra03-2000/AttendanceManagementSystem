package com.Faculty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutFaculty extends HttpServlet {

     String removeSpaces(String s1)
        {   
            return s1.replaceAll("\\s", "");
        }
  public void service(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
      
        HttpSession session = request.getSession();
        String subject = (String)session.getAttribute("Faculty_subject"); 
        subject = removeSpaces(subject.toUpperCase());
        String update="Update "+subject+"_Students SET Teacher_Active = 0";
        System.out.println(update);
        Connection conn = new DbConnection().getConnection();
        try { 
               Statement st =conn.createStatement(); 
               st.executeQuery(update);
         } catch (SQLException ex) {
          ex.printStackTrace();
        }  
        response.sendRedirect("index.html");
  }
}
