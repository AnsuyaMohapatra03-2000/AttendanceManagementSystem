package com.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutInfo extends HttpServlet {
    
      void createAttendanceCountTable(Connection conn) throws Exception{
                   
                               System.out.println("*********creating table***************");                  
                               Statement st =conn.createStatement();                            
                               System.out.println("..............Trying to create a new table for Attendance count of Students.......... :) ");
                               String tableCreateSt = "Create table AttendanceCount "
                                       + "( Attendance_Day varchar(60) , "
                                       +"Attendance_Month varchar(60),"
                                       + "Attendance_Date varchar(60), "
                                       + "Attendance_Subject varchar(60), "
                                       + "Student_ID varchar(60) ,"
                                       + "First_Name varchar(60) ,"
                                       + "Last_Name varchar(60))";
                               System.out.println(tableCreateSt);
                               PreparedStatement ps = conn.prepareStatement(tableCreateSt);
                               int i=ps.executeUpdate();  
                              System.out.println(i+" records affected");   
                               System.out.println("...............Table Created for Attendance count of Students ............:) ");
      }
      
         void insertIntoAttendanceCountTable(Connection conn,String sub,String sid,String fname,String lname) throws Exception{
                   
                               System.out.println("********* inserting data to the AttendanceCount table***************");
                   
                               Statement st =conn.createStatement();                                                    
                               Date present_date = new Date();
                               String str_timenDate = present_date.toString();
                               GetProperTime loginData = new GetProperTime(str_timenDate);
                               String day = loginData.getDay();
                               String date = loginData.getDate();
                               String month = loginData.getMonth();
                               
                               System.out.println("-----------Trying to insert data of AttendanceCount table to the ORACLE database...:) "); 
                               PreparedStatement ps = conn.prepareStatement("Insert into AttendanceCount values(?,?,?,?,?,?,?) ");
                               ps.setString(1,day);
                               ps.setString(2,month);
                               ps.setString(3,date);
                               ps.setString(4,sub);
                               ps.setString(5,sid);
                               ps.setString(6,fname);
                               ps.setString(7,lname);
                                int i=ps.executeUpdate();  
                              System.out.println(i+" records affected");   
                              System.out.println("Inserted data of AttendanceCount table to the ORACLE database...:)");
                              System.out.println("Insert function ended....");
      }
         
       void updateAttendanceCount(Connection conn,String sub,String sid,String fname,String lname) throws Exception{
                  try{
                      createAttendanceCountTable(conn);
                      insertIntoAttendanceCountTable(conn,sub,sid,fname,lname);                     
                  }catch(Exception e){
                      e.printStackTrace();
                      System.out.println("Attendance count table exists");
                     insertIntoAttendanceCountTable(conn,sub,sid,fname,lname); 
                  }
       }
    
    String removeSpaces(String s1)
                    {
                         return s1.replaceAll("\\s", "");
                  }
    
    Connection con = new DbConnection().getConnection();
    
    void update(String table_name,String sid,int classAttended) throws SQLException{
        
        System.out.println("Inside update");
        Statement st =con.createStatement();
        String tableCreateSt=null;
        
         if(classAttended==1){
             System.out.println("Class Attended...");
                tableCreateSt ="UPDATE "+table_name+" SET AC = AC+1 "+" WHERE Student_ID = ' "+sid+" ' ";
                System.out.println(tableCreateSt);
         }
         System.out.println(tableCreateSt);
         System.out.println(st.executeUpdate(tableCreateSt));	
         System.out.println("............UPDATE SUCCESSFULL.............");
    }
    
    void updateLogoutTime(int slno,String time){
        try{
         Statement st =con.createStatement();
         String updateSt="UPDATE Logedin_Students SET Logout_Time ='"+time+"' WHERE Slno ="+slno;       
            System.out.println(updateSt);
         st.executeUpdate(updateSt);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    boolean checkTeacherStatus(String tableName) throws SQLException{
          Statement st =con.createStatement();                   
          String table = "select * from "+tableName;
         System.out.println("Query to check if teacher is online is :"+table);
         ResultSet rs = st.executeQuery(table);
         while(rs.next()){
            if(rs.getInt("Teacher_Active")==1)
                  return true;
        }  
          return false;
    }
    
    public void service(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        Date date = new Date();
        String logoutTime = date.toString();
      
        PrintWriter out = response.getWriter();
        
       HttpSession session = request.getSession(); 
       String id = (String)session.getAttribute("ID");
       String fname = (String)session.getAttribute("FNAME");
       String lname = (String)session.getAttribute("LNAME");
       System.out.println("YOU CLICKED ON LOGOUT !!");
       System.out.println("YOUR ID is :" + id);
       int loginSlno = (int)session.getAttribute("LOGIN_SLNO"); 
       System.out.println("LOGIN SERIAL NO is : "+loginSlno);    
         updateLogoutTime(loginSlno,logoutTime);   
       String loginTime = (String)session.getAttribute("LOGIN_TIME");  
       System.out.println("LOGIN TIME is : "+loginTime);
       String subject1 = (String)session.getAttribute("SUBJECT_1");
       String subject2 = (String)session.getAttribute("SUBJECT_2");
       String subject3 = (String)session.getAttribute("SUBJECT_3");
       
       if(subject1 == null){
           subject1 = "   ";
       }
       if(subject2 == null){
           subject2 = "  ";
       }
       if(subject3 == null){
           subject3 = "   ";
       }  
       
       GetProperTime loginData = new GetProperTime(loginTime);
       GetProperTime logoutData = new GetProperTime(logoutTime);
                
       String UserloginDay = loginData.getDay();
       System.out.println("UserLoginday :"+ UserloginDay);
       DbConnection db = new DbConnection();
       Connection con = db.getConnection();
  try{ 
      
      Statement st = con.createStatement();
      String countSt = "select * from Time_Table";
      ResultSet rs = st.executeQuery(countSt);
      String timeslotBooked;
             
 while(rs.next()){    
     System.out.println("inside while loop");
     if((UserloginDay.equalsIgnoreCase("mon"))   && (rs.getString(2)!=null)  &&
           ( rs.getString(1).equalsIgnoreCase(subject1) ||  rs.getString(1).equalsIgnoreCase(subject2) || rs.getString(1).equalsIgnoreCase(subject3) ))
          {
                     String table_name=rs.getString(1)+"_Students";
                     timeslotBooked = rs.getString(2);
                     System.out.println("UserloginDay :"+timeslotBooked);
                     String partTime[] = timeslotBooked.split("-");
                     int startHour = Integer.parseInt(partTime[0]);
                     int endHour = Integer.parseInt(partTime[1]);
                     if((loginData.getHour()==startHour && loginData.getMinute()<=10) && (logoutData.getHour()>=endHour)&& checkTeacherStatus(table_name)){
                         System.out.println("You Logged in and logged out at perfect time!");
                          update(table_name,id,1); 
                          updateAttendanceCount(con,rs.getString(1),id,fname,lname);
                     }
                     else  if((loginData.getHour()==startHour && loginData.getMinute()>10) && (logoutData.getHour()>endHour)){
                         System.out.println("You are late for your scheduled class!!");
                          update(table_name,id,0); 
                     }
                      else  if((loginData.getHour()==startHour && loginData.getMinute()>10) && (logoutData.getHour()<endHour)){
                         System.out.println("You are late for your scheduled class!!");
                          update(table_name,id,0); 
                     }
                     else{
                         System.out.println("Sorry this is not your class time !");
                     }
          }         
     else if((UserloginDay.equalsIgnoreCase("tue"))   && (rs.getString(3)!=null)  &&
           ( rs.getString(1).equalsIgnoreCase(subject1) ||  rs.getString(1).equalsIgnoreCase(subject2) || rs.getString(1).equalsIgnoreCase(subject3) ))
          {
                     String table_name=rs.getString(1)+"_Students";
                     timeslotBooked = rs.getString(3);
                     System.out.println("UserloginDay :"+timeslotBooked);
                     String partTime[] = timeslotBooked.split("-");
                     int startHour = Integer.parseInt(partTime[0]);
                     int endHour = Integer.parseInt(partTime[1]);
                     if((loginData.getHour()==startHour && loginData.getMinute()<=10) && (logoutData.getHour()>=endHour) && checkTeacherStatus(table_name)){
                         System.out.println("You Logged in and logged out at perfect time!");
                          update(table_name,id,1); 
                          updateAttendanceCount(con,rs.getString(1),id,fname,lname);
                     }
                     else  if((loginData.getHour()==startHour && loginData.getMinute()>10) && (logoutData.getHour()>endHour)){
                         System.out.println("You are late for your scheduled class!!");
                          update(table_name,id,0); 
                     }
                      else  if((loginData.getHour()==startHour && loginData.getMinute()>10) && (logoutData.getHour()<endHour)){
                         System.out.println("You are late for your scheduled class!!");
                          update(table_name,id,0); 
                     }
                     else{
                         System.out.println("Sorry this is not your class time !");
                     }
          }
       else if((UserloginDay.equalsIgnoreCase("wed"))   && (rs.getString(4)!=null)  &&
           ( rs.getString(1).equalsIgnoreCase(subject1) ||  rs.getString(1).equalsIgnoreCase(subject2) || rs.getString(1).equalsIgnoreCase(subject3) ))
          {
                     String table_name=rs.getString(1)+"_Students";
                     timeslotBooked = rs.getString(4);
                     System.out.println("UserloginDay :"+timeslotBooked);
                     String partTime[] = timeslotBooked.split("-");
                     int startHour = Integer.parseInt(partTime[0]);
                     int endHour = Integer.parseInt(partTime[1]);
                     if((loginData.getHour()==startHour && loginData.getMinute()<=10) && (logoutData.getHour()>=endHour) && checkTeacherStatus(table_name)){
                         System.out.println("You Logged in and logged out at perfect time!");
                          update(table_name,id,1); 
                          updateAttendanceCount(con,rs.getString(1),id,fname,lname);
                     }
                     else  if((loginData.getHour()==startHour && loginData.getMinute()>10) && (logoutData.getHour()>endHour)){
                         System.out.println("You are late for your scheduled class!!");
                          update(table_name,id,0); 
                     }
                      else  if((loginData.getHour()==startHour && loginData.getMinute()>10) && (logoutData.getHour()<endHour)){
                         System.out.println("You are late for your scheduled class!!");
                          update(table_name,id,0); 
                     }
                     else{
                          System.out.println("Sorry this is not your class time !");
                     }
          }
       else if((UserloginDay.equalsIgnoreCase("thu"))   && (rs.getString(5)!=null)  &&
           ( rs.getString(1).equalsIgnoreCase(subject1) ||  rs.getString(1).equalsIgnoreCase(subject2) || rs.getString(1).equalsIgnoreCase(subject3) ))
          {
                     String table_name=rs.getString(1)+"_Students";
                     timeslotBooked = rs.getString(5);
                     System.out.println("UserloginDay :"+timeslotBooked);
                     String partTime[] = timeslotBooked.split("-");
                     int startHour = Integer.parseInt(partTime[0]);
                     int endHour = Integer.parseInt(partTime[1]);
                     if((loginData.getHour()==startHour && loginData.getMinute()<=10) && (logoutData.getHour()>=endHour) && checkTeacherStatus(table_name)){
                         System.out.println("You Logged in and logged out at perfect time!");
                          update(table_name,id,1); 
                          updateAttendanceCount(con,rs.getString(1),id,fname,lname);
                     }
                     else  if((loginData.getHour()==startHour && loginData.getMinute()>10) && (logoutData.getHour()>endHour)){
                         System.out.println("You are late for your scheduled class!!");
                          update(table_name,id,0); 
                     }
                      else  if((loginData.getHour()==startHour && loginData.getMinute()>10) && (logoutData.getHour()<endHour)){
                         System.out.println("You are late for your scheduled class!!");
                          update(table_name,id,0); 
                     }
                     else{
                         System.out.println("Sorry this is not your class time !");
                     }
          }
       else if((UserloginDay.equalsIgnoreCase("fri"))   && (rs.getString(6)!=null)  &&
           ( rs.getString(1).equalsIgnoreCase(subject1) ||  rs.getString(1).equalsIgnoreCase(subject2) || rs.getString(1).equalsIgnoreCase(subject3) ))
          {
                     String table_name=rs.getString(1)+"_Students";
                     timeslotBooked = rs.getString(6);
                     System.out.println("UserloginDay :"+timeslotBooked);
                     String partTime[] = timeslotBooked.split("-");
                     int startHour = Integer.parseInt(partTime[0]);
                     int endHour = Integer.parseInt(partTime[1]);
                     if((loginData.getHour()==startHour && loginData.getMinute()<=10) && (logoutData.getHour()>=endHour) && checkTeacherStatus(table_name)){
                         System.out.println("You Logged in and logged out at perfect time!");
                          update(table_name,id,1); 
                          updateAttendanceCount(con,rs.getString(1),id,fname,lname);
                     }
                     else  if((loginData.getHour()==startHour && loginData.getMinute()>10) && (logoutData.getHour()>endHour)){
                         System.out.println("You are late for your scheduled class!!");
                          update(table_name,id,0);                            
                     }
                     else  if((loginData.getHour()==startHour && loginData.getMinute()>10) && (logoutData.getHour()<endHour)){
                         System.out.println("You are late for your scheduled class!!");
                          update(table_name,id,0);                          
                     }
                     else{
                         System.out.println("Sorry this is not your class time !"); 
                     }
          }      
        }
      }
  catch(Exception e){
          e.printStackTrace();
      }
      response.sendRedirect("index.html");    
    }
}
