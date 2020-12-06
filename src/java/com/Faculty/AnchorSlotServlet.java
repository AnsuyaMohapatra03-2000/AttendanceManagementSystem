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

public class AnchorSlotServlet extends HttpServlet {
    
    Connection conn = new DbConnection().getConnection();  
    String removeSpaces(String s1)
    {
        char[] strArray = s1.toCharArray();  
        StringBuffer stringBuffer = new StringBuffer();  
        for (int i = 0; i < strArray.length; i++) {  
            if ((strArray[i] != ' ') && (strArray[i] != '\t')) {  
                stringBuffer.append(strArray[i]);  
            }  
        }  
        String strret = stringBuffer.toString();   
        return strret ;
    }
    
    void clearRecord(Connection conn,String subject) throws SQLException{
          subject = removeSpaces(subject);
           subject = subject.toUpperCase();
            Statement st = conn.createStatement();
             String updateSt = "UPDATE Time_Table SET Monday=NULL , Tuesday=NULL , Wednesday=NULL , Thursday=NULL , Friday=NULL WHERE Subject ='"+subject+"' ";
         System.out.println(updateSt);
         st.executeUpdate(updateSt);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         HttpSession session = request.getSession();
         System.out.println();
         
         String facSubject = (String)session.getAttribute("FSub"); 
         String anchorClick = request.getParameter("anchorPress");
         System.out.println("You clicked to clear "+facSubject+" slot : "+anchorClick);
         
         if(anchorClick != null){
          try {
                  System.out.println("Trying to clear the record........:)");
                  clearRecord(conn,facSubject);
                   System.out.println("Successfully cleared your record........:)");
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }              
    }
}
