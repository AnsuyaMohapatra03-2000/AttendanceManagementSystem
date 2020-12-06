package com.Faculty;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RegisterFacultyServlet extends HttpServlet {

                 int check = 0;   
                 static int index = 0; 
                 String id="0";
                  String shareId_final,sharePassword,shareEmail;
                  String Fname,Lname,subject,pass,email;
                  ResultSet rs;
        
                 
                   String removeSpaces(String s1)
                   {   
                       return s1.replaceAll("\\s", "");
                   }

              Boolean presentSubject(Connection conn,String subject){
                  
                   System.out.println("Present Subject started....");
                     try{
                     Statement st =conn.createStatement();
                     String countSt = "select * from Registered_faculty";
                     ResultSet rs = st.executeQuery(countSt);
                        while(rs.next()){
                             if(removeSpaces(rs.getString(6)).equalsIgnoreCase(removeSpaces(subject))){                      
                                  System.out.println("Present Subject ended...some faculty exist for this subject.....:)");
                                  return true;
                             }
                        }
                     }
                     catch(Exception e){
                       System.out.println("NO FACULTY HAS REGISTERED YET");
                       e.printStackTrace();
                     }
                      System.out.println("Present Subject ended.....No faculty available for that subject..........:)");
                     return false;
                 }  
                 void createTable(Connection conn) throws Exception {

                        System.out.println("..............Creating a NEW table for Registered Faculty..... :) ");
                        Statement st =conn.createStatement();             
                        String tableCreateSt = 
                                "Create table Registered_faculty ( Slno NUMBER(5), "
                                + "Faculty_ID varchar(60),"
                                + " First_Name varchar(60) , "
                                + "Last_Name varchar(60) ,"
                                + " Password  varchar(60) ,"
                                + "Subject varchar(120), "
                                + "Email_ID varchar(120) )";
                        st.executeUpdate(tableCreateSt);	
                        System.out.println("...............Table Created for Registered Faculty............:) ");                 
                   }
                 
void  insertRecord(Connection conn,String fname,String lname,String pass,String subject,String email,HttpSession session) throws Exception{
       
            System.out.println(fname+" "+lname+" "+pass+" "+subject+" "+email);
             Statement st =conn.createStatement();
             try{
                     String countSt = "select count(*) from Registered_faculty";
                      rs = st.executeQuery(countSt);
             }catch(Exception e){
                   System.out.println("NO FACULTY HAVE REGISTERED YET....");
                   index = 0;
             }
             while(rs.next()) {
                  index = rs.getInt(1);
             }
            System.out.println(index);
            index = index +1;
            String id = "F180"+index;
            System.out.println(id);
            session.setAttribute("FID",id);
            session.setAttribute("FSub",subject);
                                    
            System.out.println("Trying to insert data of Registered Faculty to the ORACLE database...:) ");                                    
            String insertSt = " Insert  into Registered_faculty values (  " +index + " , ' " + id +" ' , ' " + fname  + " ', ' " + lname +" ',' " +  pass +" ' ,' " + subject+" ' ,' " + email+ " ' ) ";                                  
             st.executeUpdate(insertSt);
            System.out.println("Inserted data of Registered Faculty to the ORACLE database...:)");                                            
}
      
    String assignIDandSendMail(Connection conn,String to,String userPass) throws SQLException{

                SendEmail sm = new SendEmail();
                Statement st =conn.createStatement();
                String countSt = "select count(*) from Registered_faculty";                                           //for letting the user know his/her id
               ResultSet rs = st.executeQuery(countSt);
               String shareId;    
               while(rs.next()) {
                        shareId =  "F180"+ rs.getString(1);
                        System.out.println(""+shareId);  
                        String Email = removeSpaces(to);
                       sm.mail(Email, shareId, userPass);
                       return shareId;
                }     
               return null;
    }

     public void service(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
         
       Connection conn = new DbConnection().getConnection();
   try{
       
       System.out.println("****************************Inside RegisterFacultyInfo Servlet*****************************************");
       Fname = request.getParameter("fname");
       Lname = request.getParameter("lname");
       subject =  request.getParameter("subject-list");
       System.out.println(subject);
       pass =  request.getParameter("password");
       email = request.getParameter("email");
       HttpSession session = request.getSession();
       
       try{
           try{
               if(!presentSubject(conn, subject)) {
                   createTable(conn);        //code for creating a new table
                   insertRecord(conn , Fname , Lname , pass,subject,email,session);
                   String sid = assignIDandSendMail(conn,email,pass);
                   conn.close();
                   response.sendRedirect("facultySlotBook.html");
               }else{
                   session.setAttribute("failedSUB",subject);
                   request.getRequestDispatcher("FailedRegistration.jsp").forward(request, response);
               }
           }
           catch(SQLException e){
               System.out.println("................Table already exists!!!!!!!!......................");
               
               if(!presentSubject(conn, subject))
               {
                   System.out.println("No faculty was present for that subject.............:)");
                   insertRecord(conn , Fname , Lname , pass,subject,email,session);
                   String sid = assignIDandSendMail(conn,email,pass);
                   response.sendRedirect("facultySlotBook.html");
               }
               else
               {
                   session.setAttribute("failedSUB",subject);
                   request.getRequestDispatcher("FailedRegistration.jsp").forward(request, response);
               }
               
           }
       }
       catch(Exception ex){
           ex.printStackTrace();
       }
       conn.close();
   }
      catch(SQLException ex){
                        ex.printStackTrace();
      }
     }
}
