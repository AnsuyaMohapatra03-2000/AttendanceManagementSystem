package com.Faculty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFacultyServlet extends HttpServlet {

     int  match = 0;    
      String id , name;
        
     String removeSpaces(String s1)
    {
         return s1.replaceAll("\\s", "");
    }
    void updateStatus(String subject) throws SQLException{
        try{
                 subject = removeSpaces(subject.toUpperCase());
                String update="Update "+subject+"_Students SET Teacher_Active = 1";
                System.out.println(update);
                Connection conn = new DbConnection().getConnection();
                Statement st =conn.createStatement();  
                st.executeQuery(update); 
        }catch(Exception e){
                System.out.println("There are no Registered Students........!!");
        }
    }
    
    public void service(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        
       String faculty_id = removeSpaces(request.getParameter("facultyId"));
       System.out.println(faculty_id);
       String faculty_subject = removeSpaces(request.getParameter("facultySubject"));
       System.out.println(faculty_subject);
       String facultyPassword = removeSpaces(request.getParameter("facultyPassword"));
       System.out.println(facultyPassword);
       
        try{                 
            try{
                    int eq = 0; 
                     Connection conn = new DbConnection().getConnection();
                     Statement st =conn.createStatement();  

                     System.out.println("-----------Writing the query-------------------");
                     String selectQ = "select  *  from Registered_faculty" ;
                     
                     ResultSet rs = st.executeQuery(selectQ);
                     HttpSession session = request.getSession();
             
                     while(rs.next()){        
                         String fid = removeSpaces(rs.getString(2));
                         String fp =  removeSpaces(rs.getString(5));       
                         String sub =removeSpaces(rs.getString(6)); 
                          System.out.println("Faculty ID given by the user : " + faculty_id);
                          System.out.println("Faculty ID given in the database : " + fid);
                          System.out.println("Faculty Password given by the user : " + facultyPassword);
                          System.out.println("Faculty Password given in the database : " + fp);
                          System.out.println("Faculty Subject given by the user : " + faculty_subject);
                          System.out.println("Faculty Subject given in the database : " + rs.getString(6));
                         if( fid.equalsIgnoreCase(faculty_id) &&  fp.equalsIgnoreCase(facultyPassword) && faculty_subject.equalsIgnoreCase(sub)){
                              eq = 1;
                              session.setAttribute("FID",fid); 
                              session.setAttribute("Faculty_fname",rs.getString(3));
                              session.setAttribute("Faculty_lname",rs.getString(4));
                              session.setAttribute("Faculty_subject",rs.getString(6));
                              updateStatus(rs.getString(6));
                              session.setAttribute("Faculty_email",rs.getString(7)); 
                              request.getRequestDispatcher("FacultyLoginTime").forward(request, response);
                               return;
                         }                       
                     }
                     if(eq==0){
                          String msg = "Please enter valid Faculty ID and Password!!!";
                               request.setAttribute("message",msg);
                               request.getRequestDispatcher("facultyFailedLogin.jsp").forward(request, response);
                               return;
                     }
                     conn.close();                             
                  }
        catch(SQLException e){            
                     e.printStackTrace();                    
            }                                
        }     
catch(Exception ex){
    
    ex.printStackTrace();
        
    }
    } 
}
