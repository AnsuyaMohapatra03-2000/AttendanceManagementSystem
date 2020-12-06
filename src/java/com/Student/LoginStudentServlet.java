package com.Student;

import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginStudentServlet extends HttpServlet {

    int  match = 0;    
    String id , name;
    String ID,FNAME,LNAME,EMAIL,SUBJECT_1,SUBJECT_2,SUBJECT_3,LOGIN_TIME;
    int serialNo;
    Connection con = new DbConnection().getConnection();
        
        
     String removeSpaces(String s1)
    {
         return s1.replaceAll("\\s", "");
    }
     
     void createStudentTable(Connection conn ) throws Exception{
                   
                               System.out.println("*********creating table***************");                  
                               Statement st =conn.createStatement();                            
                               System.out.println("..............Trying to create a new table for Login Data of Students.......... :) ");
                               String tableCreateSt = "Create table Logedin_Students "
                                       + "( Slno NUMBER(5),"
                                       + "Login_Time varchar(60) , "
                                       +"Logout_Time varchar(60),"
                                       + "ID varchar(60), "
                                       + "First_Name varchar(60) ,"
                                       + "Last_Name varchar(60) ,"
                                       + "Email_Id varchar(120))";
                               st.executeUpdate(tableCreateSt);	
                               System.out.println("...............Table Created for Login Data of Students ............:) ");
      }
     void insertIntoStudentTable(Connection conn,String id,String fname,String lname, String email ) throws Exception{
                             
                               System.out.println("*********creating and inserting data to the table***************");
                   
                               Statement st =conn.createStatement();                            
                               
                               Date date = new Date();
                               String str_timenDate = date.toString();
                               LOGIN_TIME = str_timenDate;
                             String countSt = "select count(*) from Logedin_Students";
                              ResultSet rs = st.executeQuery(countSt);
                             
                            while(rs.next()) {
                                 int slno = rs.getInt(1);
                                 System.out.println(slno);
                                 slno = slno +1;
                                 serialNo = slno;
                                 System.out.println("-----------Trying to insert data of Logedin Students  to the ORACLE database...:) "); 
                                 PreparedStatement ps = conn.prepareStatement("Insert into Logedin_Students values(?,?,?,?,?,?,?) ");
                                    ps.setInt(1, slno);
                                    ps.setString(2,str_timenDate);
                                    ps.setString(3,null);
                                    ps.setString(4, id);
                                    ps.setString(5, fname);
                                    ps.setString(6, lname);
                                    ps.setString(7, email);
                                int i=ps.executeUpdate();  
                                System.out.println(i+" records affected");   
                                 System.out.println("Inserted data of Logedin Students to the ORACLE database...:)");
                             }    
                            System.out.println("Insert function ended....");
               }                          
     public void service(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
    
       System.out.println("*****Inside StudentLoginCheck*******");
      
       String student_id = request.getParameter("studentId");
       String student_password = request.getParameter("studentPassword");
       
     try{            
                     
                     Statement st;  
          
                     st = con.createStatement();
                     System.out.println("-----------Writing the query-------------------");
                     String selectQ = "select  *  from Registered_students" ;
                     
                     try{
                     ResultSet rs = st.executeQuery(selectQ); 
                     }catch(Exception e){
                           response.sendRedirect("failedLogin.jsp");
                     }
                     int equal = 0;
                     
                     try{
                             createStudentTable(con);    
                         }catch(Exception e){
                                      System.out.println("LogedIn Students Table Exists!!");
                                      e.printStackTrace();
                       }
                   ResultSet rs = st.executeQuery(selectQ);   
                     while(rs.next()){    
                         String sid = removeSpaces(rs.getString(2));
                         String sp =  removeSpaces(rs.getString(5));
                         System.out.println("Login id :  "+student_id);
                         System.out.println("Compared with :  "+ sid);
                        
                      if( sid.equalsIgnoreCase(student_id) &&  sp.equalsIgnoreCase(student_password)  ){
                              ID = student_id;
                              FNAME = rs.getString(3);
                              LNAME = rs.getString(4);
                              EMAIL = rs.getString(9);
                              SUBJECT_1 = rs.getString(6);
                              SUBJECT_2 = rs.getString(7);
                              SUBJECT_3 = rs.getString(8);         
                              equal=1;                    
                             System.out.println("..............Hey student you have registered..............................................");
                              insertIntoStudentTable(con,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(9));                           
                         }
                     }
                     if(equal == 0){
                                      response.sendRedirect("failedLogin.jsp");
                               return;
                      } 
                     else if(equal == 1){
                               HttpSession session = request.getSession();
                              session.setAttribute("ID",ID); 
                              session.setAttribute("FNAME",FNAME); 
                              session.setAttribute("LNAME",LNAME);
                              session.setAttribute("EMAIL",EMAIL);
                              session.setAttribute("SUBJECT_1",SUBJECT_1);
                              session.setAttribute("SUBJECT_2",SUBJECT_2);
                              session.setAttribute("SUBJECT_3",SUBJECT_3);
                              session.setAttribute("LOGIN_TIME",LOGIN_TIME);  
                              session.setAttribute("LOGIN_SLNO",serialNo);                                
                              request.getRequestDispatcher("StudentHomePage.jsp").forward(request, response);
                     }
           }
         catch(Exception ex){
           ex.printStackTrace();
       }
     } 
}
