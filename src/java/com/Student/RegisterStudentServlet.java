package com.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(fileSizeThreshold=1024*1024*5*5, maxFileSize=1024*1024*5*5, maxRequestSize=1024*1024*5*5)
public class RegisterStudentServlet extends HttpServlet {

                //Connection con = new DbConnection().getConnection();
    
                 int check = 0;   
                 static int index = 0; 
                 String id="0";
                 int check_1 = 0;   
                 static int index_1 = 0; 
                 String shareId;   
                 
                  String removeSpaces(String s1)
                 {   
                     return s1.replaceAll("\\s", "");
                 }
                 
                 void createTable(Connection con) throws Exception {

                                System.out.println("..............Creating a NEW table for Registered Students..... :) ");
                                Statement st =con.createStatement();             
                                String tableCreateSt ="Create table Registered_students ( Slno NUMBER(5), Student_ID varchar(60), First_Name varchar(60) , "
                                                   + "Last_Name varchar(60) ,"
                                                  + " Password  varchar(60) ,"
                                                    + "Subject_1 varchar(120), "
                                                  + "Subject_2 varchar(120), "
                                                  + "Subject_3 varchar(120), "
                                                   + "Email_ID varchar(120), "
                                                    + "Image BLOB)";
                                st.executeUpdate(tableCreateSt);	
                                System.out.println("...............Table Created for Registered Students............:) ");                 
                  }
                 
    void  insertRecord(Connection con,String fname,String lname,String pass,String subject1,String subject2,String subject3,String email,InputStream inputStream,long length) throws Exception{
       
           System.out.println("Inside Insert Record !!");
           System.out.println(fname+" "+lname+" "+pass+" "+subject1+" "+subject2+" "+" "+subject3+" "+email);
           Statement st =con.createStatement();
           String countSt = "select count(*) from Registered_students";
                   
           ResultSet rs = st.executeQuery(countSt);
            while(rs.next()) {
                           index = rs.getInt(1);
            }
           System.out.println(index);
           index = index +1;
           id = "B5180"+index;
           System.out.println(id); 

           System.out.println("Trying to insert data of Registered Students to the ORACLE database...:) ");  
           String insertSt = "Insert into Registered_students values(?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement ps=con.prepareStatement(insertSt);
           ps.setInt(1, index);
           ps.setString(2, id);
           ps.setString(3, fname);
           ps.setString(4, lname);
           ps.setString(5, pass);
           ps.setString(6, subject1);
           ps.setString(7, subject2);
           ps.setString(8, subject3);
           ps.setString(9, email);
           ps.setBinaryStream(10,inputStream,(int)length);  

           int i=ps.executeUpdate();  
           System.out.println(i+" records affected");  
           SendEmail sm = new SendEmail(); 
           sm.mail(email,id,pass);
           tableforSubs(con,id,subject1,subject2,subject3,fname,lname);           
     }
    void insertForSubjects(Connection con, String table_name, String sid,String fname,String lname) throws Exception{
               
                System.out.println("***Inserting for subject : "+table_name+"  ");
                Statement st =con.createStatement();
                System.out.println(table_name+"   "+sid+"    "+fname+"    "+lname+"    ");
             
               String countSt = "select count(*) from "+ table_name ;
               ResultSet rs = st.executeQuery(countSt);
             
               while(rs.next()) {
                    index_1 = rs.getInt(1);
               }
              System.out.println(index_1);
              index_1 = index_1 +1;
              System.out.println(sid); 
                                    
             System.out.println("Trying to insert data of "+table_name+" to the ORACLE database...:) ");                                    
             String insertSt = " Insert  into "+table_name+"  values (  " +index_1 + " , ' " + sid +" ' , ' " + fname  + " ', ' "  + lname+" ', 0,0,0) ";                                  
             st.executeUpdate(insertSt);
             System.out.println("Inserted data of "+table_name+" to the ORACLE database...:)"); 
     }
    void tablesForSubjects(Connection con, String table_name) throws Exception{              
                 System.out.println("..............Creating a NEW table for "+table_name+"..... :) ");
                 Statement st =con.createStatement();             
                String tableCreateSt = 
                 "Create table "
                 + table_name
                 + "( Slno NUMBER(5), "
                 + "Student_ID varchar(60), "
                 + "First_Name varchar(60) , "
                 + "Last_Name varchar(60) ,"
                 + " AC NUMBER(5) , "
                 + " TC NUMBER(5),"
                 + "Teacher_Active NUMBER(5) )";
                st.executeUpdate(tableCreateSt);	
                System.out.println("...............Table Created for "+table_name+"............:) ");                 
     }
    
    
    public void tableforSubs(Connection con,String sid,String sub1,String sub2 ,String sub3,String fname,String lname) {
        
           sub1 = removeSpaces(sub1);
           sub2 = removeSpaces(sub2);
           sub3 = removeSpaces(sub3);
           if(sub1.equalsIgnoreCase("iwt") ||sub2.equalsIgnoreCase("iwt") ||sub3.equalsIgnoreCase("iwt")  ){
               try{
                      tablesForSubjects(con,"IWT_Students");
                      insertForSubjects(con,"IWT_Students",sid,fname,lname);
               }catch(Exception e){
                   try {
                       e.printStackTrace();
                       System.out.println("IWT Table exists !!");
                       insertForSubjects(con,"IWT_Students",sid,fname,lname);
                   } catch (Exception ex) {
                       ex.printStackTrace();
                   }
               }       
           }
            if(sub1.equalsIgnoreCase("dccn") ||sub2.equalsIgnoreCase("dccn") ||sub3.equalsIgnoreCase("dccn")  ){
               try{
                      tablesForSubjects(con,"DCCN_Students");
                      insertForSubjects(con,"DCCN_Students",sid,fname,lname);
               }catch(Exception e){
                  try {
                       e.printStackTrace();
                       System.out.println("DCCN Table exists !!");
                       insertForSubjects(con,"DCCN_Students",sid,fname,lname);
                   } catch (Exception ex) {
                       ex.printStackTrace();
                   }
               }       
           }
          if(sub1.equalsIgnoreCase("os") ||sub2.equalsIgnoreCase("os") ||sub3.equalsIgnoreCase("os")  ){
               try{
                      tablesForSubjects(con,"OS_Students");
                      insertForSubjects(con,"OS_Students",sid,fname,lname);
                }catch(Exception e){
                   try {
                       e.printStackTrace();
                       System.out.println("OS Table exists !!");
                       insertForSubjects(con,"OS_Students",sid,fname,lname);
                   } catch (Exception ex) {
                       ex.printStackTrace();
                   }
               }       
          }
    }
         
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Connection con = new DbConnection().getConnection();
        
       try{
           
           String Fname = request.getParameter("fname");
           String Lname = request.getParameter("lname");
           String sub1 =  request.getParameter("subject-1");
           System.out.println(sub1);
           String sub2 =  request.getParameter("subject-2");
           System.out.println(sub2);
           String sub3 =  request.getParameter("subject-3");
           System.out.println(sub3);
           String pass =  request.getParameter("password");
           String email = request.getParameter("email");
           
           InputStream inputStream = null; // input stream of the upload file
           long length;
           // obtains the upload file part in this multipart request
           Part filePart = request.getPart("inpFile");
           length = filePart.getSize();
           if (filePart != null) {
               // prints out some information for debugging
               System.out.println(filePart.getName());
               System.out.println(filePart.getSize());
               System.out.println(filePart.getContentType());
               // obtains input stream of the upload file
               inputStream = filePart.getInputStream();
           }
           
           try{
               System.out.println("Trying to create a new Table !!");//code if table does not exist
               createTable(con);
           }catch(Exception e){
               e.printStackTrace();
               System.out.println("Table exists!!");
           }
           
           try{
               insertRecord(con,Fname,Lname,pass,sub1,sub2,sub3,email,inputStream,length);
               response.sendRedirect("ResultStudent.jsp");
               //con.close();
           }
           catch (Exception e)
           {
               e.printStackTrace();
           }
           try {
               con.close();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }  
     
}

