package com.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstQuizServlet extends HttpServlet {
    
      int noOfRecord;
      Connection con = new DbConnection().getConnection();
      Boolean recordPresent=false;
    
     void createShortQuizResponse(Connection conn) throws Exception{
                   
                               System.out.println("*********creating table***************");                  
                               Statement st =conn.createStatement();                            
                               System.out.println("..............Trying to create a new table for ShortQuizResponse of Students.......... :) ");
                               String tableCreateSt = "Create table ShortQuizResponse "
                                       + "( Slno NUMBER(5),"
                                       + "ID varchar(60) , "
                                       +"Subject varchar(60),"
                                       + "Lecture_No varchar(60), "
                                       + "First_Name varchar(60) ,"
                                       + "Last_Name varchar(60), "
                                       + "Marks_Obtained NUMBER(5))";
                               st.executeUpdate(tableCreateSt);	
                               System.out.println("...............Table Created for ShortQuizResponse of Students ............:) ");
      }
      void insertIntoShortQuizResponse(Connection conn,String id,String subject,String subNo,String fname,String lname,int marks) throws Exception{
                             
                              System.out.println("*********Inserting data to the ShortQuizResponse table***************");           
                              Statement st =conn.createStatement();                            
                               
                              String countSt = "select count(*) from ShortQuizResponse";
                              ResultSet rs = st.executeQuery(countSt);
                             
                              while(rs.next()) {
                                 int noOfRecord = rs.getInt(1);
                                 System.out.println(noOfRecord);
                                 noOfRecord += 1;

                                 System.out.println("-----------Trying to insert data of ShortQuizResponse of Students to the ORACLE database...:) "); 
                                 PreparedStatement ps = conn.prepareStatement("Insert into ShortQuizResponse values(?,?,?,?,?,?,?) ");
                                    ps.setInt(1,noOfRecord);
                                    ps.setString(2,id);
                                    ps.setString(3,subject);
                                    ps.setString(4,subNo);
                                    ps.setString(5,fname);
                                    ps.setString(6,lname);
                                    ps.setInt(7,marks);
                                int i=ps.executeUpdate();  
                                System.out.println(i+" records affected");   
                                 System.out.println("Inserted data of ShortQuizResponse of Students to the ORACLE database...:)");
                             }    
                            System.out.println("Insert function ended....");
               }    
      
            
       public void service(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{

          try {
              System.out.println(".........FirstQuizServlet Starts.........");
              HttpSession session = request.getSession();
              
              String opt = request.getParameter("givenAns");
              String id = (String)session.getAttribute("ID");
              System.out.println("I am in the FirstQuizServlet and my id is : "+id);
              String fname = (String)session.getAttribute("FNAME");
              String lname = (String)session.getAttribute("LNAME");
              System.out.println("Answer given by the student of "+id+" is : "+opt);
              String subClicked = (String) session.getAttribute("subClicked");
              System.out.println("I am inside short quiz page i m watching lectures of :" +subClicked);   //has lecture subject and no
              int length = subClicked.length();
              String subject = subClicked.substring(0,length-1);
              String lecNo = subClicked.substring(length-1,length);
              int marks = 0;
              if(opt.equalsIgnoreCase("correct")){
                  marks = 1;
              }

             try{          
                      createShortQuizResponse(con);                
              }catch(Exception e){                
                           e.printStackTrace();
                          System.out.println("......Short Quiz Response Table exists.......");
              }
              
              Statement st =con.createStatement();      
              try{
                      String countSt = "select * from ShortQuizResponse";
                      System.out.println(countSt);
                      ResultSet rs = st.executeQuery(countSt);
                      while(rs.next()){
                          if(rs.getString(2).equalsIgnoreCase(id) && rs.getString(3).equalsIgnoreCase(subject) && rs.getString(4).equalsIgnoreCase(lecNo)){
                             recordPresent = true;
                             break;
                          }
                      }
                      if(recordPresent == false){
                           insertIntoShortQuizResponse(con,id,subject,lecNo,fname,lname,marks);
                      }         
              }catch(Exception e){
                  e.printStackTrace();
              }
              
              System.out.println(".........FirstQuizServlet Ends.........");
          } //end of service method
          catch (Exception ex) {
              ex.printStackTrace();
          }       
       }
}  //end of the firstQuizServlet
