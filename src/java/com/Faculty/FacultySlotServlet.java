/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Faculty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

public class FacultySlotServlet extends HttpServlet {
    
    String facId ,facSubject;
    String failedMessage = "\n";
    int index = 0;
    ResultSet rs;
    
   String removeSpaces(String s1)
        {   
            return s1.replaceAll("\\s", "");
        }
    
    void  createTable(Connection conn) throws SQLException{
        
            Statement st = conn.createStatement();
            String querySt = "Create table Time_Table( Subject varchar(30), Monday varchar(30) , Tuesday varchar(30) ,Wednesday varchar(30) , Thursday varchar(30) , Friday varchar(30) ) ";
            st.executeQuery(querySt);
            System.out.println("Preparing Time Table....:)");
            querySt = "Insert into Time_Table values('IWT',null,null,null,null,null)";
            st.executeQuery(querySt); 
              querySt = "Insert into Time_Table values('OS',null,null,null,null,null)";
            st.executeQuery(querySt); 
              querySt = "Insert into Time_Table values('DCCN',null,null,null,null,null)";
            st.executeQuery(querySt);       
      }
      
    void addToTheTT(Connection conn, String subject,String day,String time_slot) throws SQLException{
         
        subject = removeSpaces(subject);
        day = removeSpaces(day);
        time_slot = removeSpaces(time_slot);
        System.out.println("addToTheTT function()..............:)");
        System.out.println("creating statement.....");
         Statement st = conn.createStatement();
          System.out.println("created statement.....");
          subject = subject.toUpperCase();
         String updateSt = "UPDATE Time_Table SET "+ day + "= '" +time_slot + "' WHERE Subject ='"+subject+"' ";
         System.out.println(updateSt);
         st.executeUpdate(updateSt);
         System.out.println("Added to function.....:)");
    }
    
     Boolean checkForTime(Connection conn, String facSubject,String day, String time) throws SQLException{           //returns true if that time is not given to anyone
         
                          System.out.println("Checking If the "+time+" is occupied for "+day+" for Subject : "+ facSubject);
                          Statement st = conn.createStatement();
                          facSubject = facSubject.toUpperCase();
                          String getTT = "select * from Time_Table";
                          System.out.println("Executing the statement : "+getTT);
                          rs = st.executeQuery(getTT);
                          
                          while(rs.next())
                          {
                                  if(rs.getString(day)!=null) {      //time slot is booked for any time
                                      if(rs.getString(day).equalsIgnoreCase(time)){    //if theslot booking time matches the already slot booked time
                                             return false;
                                      }
                                  }
                          }
         return true;
     }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
    Boolean mon = true;
    Boolean tues = true;
    Boolean wed = true;
    Boolean thurs = true;
    Boolean fri = true;
    Connection conn = new DbConnection().getConnection();
         HttpSession session = request.getSession();
         System.out.println();
           try{
                System.out.println("Creating a new Time_Table..........:)");
                 createTable(conn);
                 System.out.println("Success..........:)");
            }
            catch(Exception e){
                System.out.println("The Time Table exists !!!");
            }
            facId = (String)session.getAttribute("FID");                                //faculty id of the recent registered faculty
            facSubject = (String)session.getAttribute("FSub"); 
        
  try {
            String time_mon =  request.getParameter("monday") ;
            String time_tues = request.getParameter("tuesday");
  
//            CHECKING FOR MONDAY
            
            System.out.println("Trying to book slot for Monday at time :: "+time_mon);
            
            if(time_mon!=null){
                     if(checkForTime(conn,facSubject,"Monday",time_mon)){        //returns true if that time is not given to anyone                        
                           System.out.println("Monday slot "+time_mon+" is empty for you......:)");                   //checks if tuesday there is no class assigned for the subject
                           addToTheTT(conn,facSubject,"Monday",time_mon);                    
                     }else{
                           mon = false;
                           System.out.println("Monday slot "+time_mon+" is already booked......:)"); 
                     }  
            }
            
//            CHECKING FOR TUESDAY
                
            System.out.println("Trying to book slot for Tuesday at time :: "+time_tues);
             
            if(time_tues!=null){
                     if(checkForTime(conn,facSubject,"Tuesday",time_tues)){        //returns true if that time is not given to anyone                        
                           System.out.println("Tuesday slot "+time_tues+" is empty for you......:)");                   //checks if tuesday there is no class assigned for the subject
                           addToTheTT(conn,facSubject,"Tuesday",time_tues);                    
                     }else{
                           tues = false;
                           System.out.println("Tuesday slot "+time_tues+" is already booked......:)"); 
                     }  
            }
             
             
            String time_wed = request.getParameter("wednesday") ;
             System.out.println("Trying to book slot for Wednesday at time :: "+time_wed);
             
               if(time_wed!=null){
                     if(checkForTime(conn,facSubject,"Wednesday",time_wed)){        //returns true if that time is not given to anyone                        
                           System.out.println("Wednesday slot "+time_wed+" is empty for you......:)");                   //checks if tuesday there is no class assigned for the subject
                           addToTheTT(conn,facSubject,"Wednesday",time_wed);                    
                     }else{
                           wed = false;
                           System.out.println("Wednesday slot "+time_wed+" is already booked......:)"); 
                     }  
               }
             
            String time_thurs = request.getParameter("thursday") ;
             System.out.println("Trying to book slot for Thursday at time :: "+time_thurs);
             
               if(time_thurs!=null){
                     if(checkForTime(conn,facSubject,"Thursday",time_thurs)){        //returns true if that time is not given to anyone                        
                           System.out.println("Thursday slot "+time_thurs+" is empty for you......:)");                   //checks if tuesday there is no class assigned for the subject
                           addToTheTT(conn,facSubject,"Thursday",time_thurs);                    
                     }else{
                           thurs = false;
                           System.out.println("Thursday slot "+time_thurs+" is already booked......:)"); 
                     }  
               }
               
            String time_fri =  request.getParameter("friday") ;
            System.out.println("Trying to book slot for Friday at time :: "+time_fri);
            
            if(time_fri!=null){
                     if(checkForTime(conn,facSubject,"Friday",time_fri)){        //returns true if that time is not given to anyone                        
                           System.out.println("Friday slot "+time_fri+" is empty for you......:)");                   //checks if tuesday there is no class assigned for the subject
                           addToTheTT(conn,facSubject,"Friday",time_fri);                    
                     }else{
                           thurs = false;
                           System.out.println("Friday slot "+time_fri+" is already booked......:)"); 
                     }  
               }
          failedMessage = " Please book your slots again the following slots are already booked ::  \n";
          if(!mon){
               failedMessage +=" Monday :: "+time_mon+"\n";
          }
          if(!tues){
               failedMessage +=" Tuesday :: "+time_tues+"\n";
          }
          if(!wed){
               failedMessage +=" Wednesday :: "+time_wed+"\n";
          }
          if(!thurs){
               failedMessage +=" Thursday :: "+time_thurs+"\n";
          }
          if(!fri){
               failedMessage +=" Friday :: "+time_fri+"\n";
          }
          
          if(mon && tues && wed && fri && thurs){        
                request.setAttribute("message","You have Registered Successfully !");
                request.setAttribute("anchorText","Click here to go to the Login Page");
                request.setAttribute("mid","1");
                request.getRequestDispatcher("ResultFaculty.jsp").forward(request, response);            
          }else{
                request.setAttribute("message",failedMessage);
                request.setAttribute("anchorText","Click here to change your slot bookings");
                 request.setAttribute("mid","0");
                request.getRequestDispatcher("ResultFaculty.jsp").forward(request, response);
          }   
        } 
         catch (SQLException ex) {
            ex.printStackTrace();
        }
    }     
}
