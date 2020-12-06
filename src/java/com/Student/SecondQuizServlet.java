package com.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondQuizServlet extends HttpServlet {
    
      int noOfRecord;
      Connection con = new DbConnection().getConnection();
      Boolean recordPresent=false;
      
        String removeSpaces(String s1)
       {
              return s1.replaceAll("\\s", "");
       }
    
     void createLongQuizResponse(Connection conn) throws Exception{
                   
                               System.out.println("*********creating table***************");                  
                               Statement st =conn.createStatement();                            
                               System.out.println("..............Trying to create a new table for LongQuizResponse of Students.......... :) ");
                               String tableCreateSt = "Create table LongQuizResponse "
                                       + "( Slno NUMBER(5),"
                                       + "ID varchar(60) , "
                                       +"Subject varchar(60),"
                                       + "Lecture_No varchar(60), "
                                       + "First_Name varchar(60) ,"
                                       + "Last_Name varchar(60), "
                                       + "Marks_Obtained NUMBER(5))";
                               st.executeUpdate(tableCreateSt);	
                               System.out.println("...............Table Created for LongQuizResponse of Students ............:) ");
      }
      void insertIntoLongQuizResponse(Connection conn,String id,String subject,String subNo,String fname,String lname,int marks) throws Exception{
                             
                              System.out.println("*********Inserting data to the LongQuizResponse table***************");           
                              Statement st =conn.createStatement();                            
                               
                              String countSt = "select count(*) from LongQuizResponse";
                              ResultSet rs = st.executeQuery(countSt);
                             
                              while(rs.next()) {
                                 int noOfRecord = rs.getInt(1);
                                 System.out.println(noOfRecord);
                                 noOfRecord += 1;

                                 System.out.println("-----------Trying to insert data of ShortQuizResponse of Students to the ORACLE database...:) "); 
                                 PreparedStatement ps = conn.prepareStatement("Insert into LongQuizResponse values(?,?,?,?,?,?,?) ");
                                    ps.setInt(1, noOfRecord);
                                    ps.setString(2,id);
                                    ps.setString(3,subject);
                                    ps.setString(4,subNo);
                                    ps.setString(5,fname);
                                    ps.setString(6,lname);
                                    ps.setInt(7,marks);
                                int i=ps.executeUpdate();  
                                System.out.println(i+" records affected");   
                                 System.out.println("Inserted data of LongQuizResponse of Students to the ORACLE database...:)");
                             }    
                            System.out.println("Insert function ended....");
               }                          
      
     

     public void service(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

          System.out.println("Long quiz servlet is executing.............................");
          
       String score =request.getParameter("givenAns");  
        if(request.getParameter("givenAns").equals("") ||request.getParameter("givenAns")==null )
        {
            System.out.println("The user didn't complete the quiz yet");
        } 
        else if(request.getParameter("givenAns")!=null){
            String p[] = score.split("/");
            int noOfCorrectAnswer =Integer.parseInt(removeSpaces(p[0]));
//            Fetching all the records.....
            HttpSession session = request.getSession();
            String id = (String)session.getAttribute("ID");
            String fname = (String)session.getAttribute("FNAME");
            String lname = (String)session.getAttribute("LNAME");
            String subClicked = (String) session.getAttribute("subClicked");
       
            System.out.println("I am in the SecondQuizServlet and my id is : "+id);
            System.out.println("I am inside SecondQuizServlet i m watching lectures of :" +subClicked);
            System.out.println("No of correct answers given by the student of "+id+" is : "+noOfCorrectAnswer);
            int length = subClicked.length();
            String subject = subClicked.substring(0,length-1);
            String lecNo = subClicked.substring(length-1,length);
            
  //            Creating a table if it does not exist......
             try{          
                     createLongQuizResponse(con);                
              }catch(Exception e){                
                           e.printStackTrace();
                          System.out.println("......Short Long Response Table exists.......");
              }
             
  //           Checking if the student has appeared the test before or not
             
           try{
                      Statement st =con.createStatement();   
                      String countSt = "select * from LongQuizResponse";
                      System.out.println(countSt);
                      ResultSet rs = st.executeQuery(countSt);
                      while(rs.next()){
                          if(rs.getString(2).equalsIgnoreCase(id) && rs.getString(3).equalsIgnoreCase(subject) && rs.getString(4).equalsIgnoreCase(lecNo)){
                             recordPresent = true;
                             break;
                          }
                      }
                      if(recordPresent == false){
                           insertIntoLongQuizResponse(con,id,subject,lecNo,fname,lname,noOfCorrectAnswer);
                      }         
              }catch(Exception e){
                  e.printStackTrace();
              }         
              System.out.println(".........FirstQuizServlet Ends.........");     
           }
           System.out.println("End of long quiz servlet...............................");
            
       } //end of service method
}  //end of second Quiz Servlet
