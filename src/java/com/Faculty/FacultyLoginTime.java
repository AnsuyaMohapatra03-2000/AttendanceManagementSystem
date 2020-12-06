

package com.Faculty;

import static com.Faculty.RegisterFacultyServlet.index;
import java.io.IOException;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


public class FacultyLoginTime extends HttpServlet {
    
         String removeSpaces(String s1)
        {   
            return s1.replaceAll("\\s", "");
        }
    
    void updateRecord(Connection con,String table_name) throws SQLException{
        
                System.out.println("******Inside update total cases Faculty Login Time*******");
                Statement st =con.createStatement();
                String tableCreateSt=null;

                     System.out.println("Class Taken...");
                        tableCreateSt ="UPDATE "+table_name+" SET TC = TC+1 ";
                        System.out.println(tableCreateSt);
                        
                 System.out.println(tableCreateSt);
                 System.out.println(st.executeUpdate(tableCreateSt));	
                 System.out.println("............UPDATED Total classes SUCCESSFULL.............");
       }

      public void service(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        
       HttpSession session = request.getSession();
       String fid = (String)session.getAttribute("FID");
       String subject = (String)session.getAttribute("Faculty_subject");
       
       java.util.Date date = new java.util.Date();
        String loginTime = date.toString();
      
        PrintWriter out = response.getWriter();
        
       System.out.println("YOU CLICKED ON LOGOUT !!");
       System.out.println("YOUR ID is :" + fid);
       System.out.println("LOGIN TIME is : "+loginTime);
      
      GetProperTime loginData = new GetProperTime(loginTime);
         
       String TeachloginDay = loginData.getDay();
       System.out.println("FacutyLoginday :"+ TeachloginDay);
       Connection con =  new DbConnection().getConnection();
   
    try{ 
      
      Statement st = con.createStatement();
      String countSt = "select * from Time_Table";
      ResultSet rs = st.executeQuery(countSt);
      String timeslotBooked;
             
 while(rs.next()){    
     System.out.println("inside while loop");
     if((removeSpaces(TeachloginDay).equalsIgnoreCase("mon"))   && (rs.getString(2)!=null)  && (removeSpaces(rs.getString(1)).equalsIgnoreCase(removeSpaces(subject))))
          {
                    System.out.println("inside monday if...");
                     String table_name=removeSpaces(subject)+"_Students";
                     timeslotBooked = rs.getString(2);
                     System.out.println("Time Slot Booked on that day :"+timeslotBooked);
                     String partTime[] = timeslotBooked.split("-");
                     int startHour = Integer.parseInt(partTime[0]);
                     int endHour = Integer.parseInt(partTime[1]);
                     if((loginData.getHour()==startHour-1 && loginData.getMinute()>=50 ) || (loginData.getHour()==startHour && loginData.getMinute()<=10)){
                         System.out.println("You LoggedIn at perfect time!");
                          updateRecord(con,table_name);
                     }
                     else
                         System.out.println("Sorry this is not your scheduled class time !");                     
          }         
     else if((removeSpaces(TeachloginDay).equalsIgnoreCase("tue"))   && (rs.getString(3)!=null)  && (removeSpaces(rs.getString(1)).equalsIgnoreCase(removeSpaces(subject))))
          {
                    System.out.println("inside tuesday if...");
                     String table_name=removeSpaces(subject)+"_Students";
                     timeslotBooked = rs.getString(3);
                     System.out.println("Time Slot Booked on that day :"+timeslotBooked);
                     String partTime[] = timeslotBooked.split("-");
                     int startHour = Integer.parseInt(partTime[0]);
                     int endHour = Integer.parseInt(partTime[1]);
                     if((loginData.getHour()==startHour-1 && loginData.getMinute()>=50 ) || (loginData.getHour()==startHour && loginData.getMinute()<=10)){
                         System.out.println("You LoggedIn at perfect time!");
                          updateRecord(con,table_name);
                     }
                     else
                         System.out.println("Sorry this is not your scheduled class time !");                     
          }        
       else  if((removeSpaces(TeachloginDay).equalsIgnoreCase("wed"))   && (rs.getString(4)!=null)  && (removeSpaces(rs.getString(1)).equalsIgnoreCase(removeSpaces(subject))))
          {
                    System.out.println("inside monday if...");
                     String table_name=removeSpaces(subject)+"_Students";
                     timeslotBooked = rs.getString(4);
                     System.out.println("Time Slot Booked on that day :"+timeslotBooked);
                     String partTime[] = timeslotBooked.split("-");
                     int startHour = Integer.parseInt(partTime[0]);
                     int endHour = Integer.parseInt(partTime[1]);
                     if((loginData.getHour()==startHour-1 && loginData.getMinute()>=50 ) || (loginData.getHour()==startHour && loginData.getMinute()<=10)){
                         System.out.println("You LoggedIn at perfect time!");
                          updateRecord(con,table_name);
                     }
                     else
                         System.out.println("Sorry this is not your scheduled class time !");                     
          }        
       else  if((removeSpaces(TeachloginDay).equalsIgnoreCase("thu"))   && (rs.getString(5)!=null)  && (removeSpaces(rs.getString(1)).equalsIgnoreCase(removeSpaces(subject))))
          {
                    System.out.println("inside monday if...");
                     String table_name=removeSpaces(subject)+"_Students";
                     timeslotBooked = rs.getString(5);
                     System.out.println("Time Slot Booked on that day :"+timeslotBooked);
                     String partTime[] = timeslotBooked.split("-");
                     int startHour = Integer.parseInt(partTime[0]);
                     int endHour = Integer.parseInt(partTime[1]);
                     if((loginData.getHour()==startHour-1 && loginData.getMinute()>=50 ) || (loginData.getHour()==startHour && loginData.getMinute()<=10)){
                         System.out.println("You LoggedIn at perfect time!");
                          updateRecord(con,table_name);
                     }
                     else
                         System.out.println("Sorry this is not your scheduled class time !");                     
          }        
       else if((removeSpaces(TeachloginDay).equalsIgnoreCase("fri"))   && (rs.getString(6)!=null)  && (removeSpaces(rs.getString(1)).equalsIgnoreCase(removeSpaces(subject))))
          {
                    System.out.println("inside monday if...");
                     String table_name=removeSpaces(subject)+"_Students";
                     timeslotBooked = rs.getString(6);
                     System.out.println("Time Slot Booked on that day :"+timeslotBooked);
                     String partTime[] = timeslotBooked.split("-");
                     int startHour = Integer.parseInt(partTime[0]);
                     int endHour = Integer.parseInt(partTime[1]);
                     if((loginData.getHour()==startHour-1 && loginData.getMinute()>=50 ) || (loginData.getHour()==startHour && loginData.getMinute()<=10)){
                         System.out.println("You LoggedIn at perfect time!");
                          updateRecord(con,table_name);
                     }
                     else
                         System.out.println("Sorry this is not your scheduled class time !");                     
          }        
        }  //end of while loop
      }  //end of try
  catch(Exception e){
          e.printStackTrace();
      }
     request.getRequestDispatcher("FacultyProfile.jsp").forward(request, response); 
     
    } //end of service method      
 } //end of FacultyLoginTime class

