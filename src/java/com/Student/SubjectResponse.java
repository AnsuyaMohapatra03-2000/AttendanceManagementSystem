package com.Student;

import java.io.*;
import java.sql.*;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

public class SubjectResponse extends HttpServlet {

      String iwt_response,dccn_response,os_response;
      Connection con = new DbConnection().getConnection(); 
      
       void createSQTable(Connection conn) throws Exception{
                   
                               System.out.println("*********creating table for Quiz***************");                  
                               Statement st =conn.createStatement();                            
                               System.out.println("..............Trying to create a new table for Quiz Data of Students.......... :) ");
                               String tableCreateSt = "Create table ShortQuiz"
                                       + "(QID varchar(30) ,"
                                       +"ShortQuestion varchar(200),"
                                       + "ShortAnswer varchar(6) )";
                               st.executeUpdate(tableCreateSt);	
                               System.out.println("...............Table Created for Conducting quiz for Students ............:) ");
      }
      
      void insertIntoSQTable(Connection conn,String QID,String SQ, String SA) throws Exception{
                             
                            System.out.println("*********creating and inserting data to the table***************");                  
                            Statement st =conn.createStatement();                            
                            System.out.println("-----------Trying to insert data of Quiz Table  to the ORACLE database...:) "); 
                            PreparedStatement ps = conn.prepareStatement("Insert into ShortQuiz values(?,?,?) ");
                            ps.setString(1,QID);
                            ps.setString(2,SQ);
                            ps.setString(3,SA);
                            int i=ps.executeUpdate();  
                            System.out.println(i+" records affected in Quiz table");   
                            System.out.println("Inserted data of Short Quiz to the ORACLE database...:)");
                            System.out.println("Insert function ended....");
      }               
      void createLQTable(Connection conn) throws Exception{
                   
                               System.out.println("*********creating table for Quiz***************");                  
                               Statement st =conn.createStatement();                            
                               System.out.println("..............Trying to create a new table for Quiz Data of Students.......... :) ");
                               String tableCreateSt = "Create table LongQuiz"
                                       + "(QID varchar(30),"
                                       + "LongQuestion varchar(200) ,"
                                       + "LongOption1 varchar(200) ,"
                                       + "LongOption2 varchar(200) ,"
                                       +"LongOption3 varchar(200) ,"
                                       +"LongOption4 varchar(200) ,"
                                       + "LongAnswer varchar(200) )";
                               st.executeUpdate(tableCreateSt);	
                               System.out.println("...............Table Created for Conducting quiz for Students ............:) ");
      }
      void insertIntoLQTable(Connection conn,String QID, String LQ,String opt1,String opt2,String opt3, String opt4,  String LA) throws Exception{
                             
                            System.out.println("*********creating and inserting data to the table***************");                  
                            Statement st =conn.createStatement();                            
                            System.out.println("-----------Trying to insert data of Quiz Table  to the ORACLE database...:) "); 
                            PreparedStatement ps = conn.prepareStatement("Insert into LongQuiz values(?,?,?,?,?,?,?) ");
                            ps.setString(1,QID);
                            ps.setString(2,LQ);
                            ps.setString(3,opt1);
                            ps.setString(4,opt2);
                            ps.setString(5,opt3);
                            ps.setString(6,opt4);
                            ps.setString(7,LA);
                            int i=ps.executeUpdate();  
                            System.out.println(i+" records affected in Quiz table");   
                            System.out.println("Inserted data of Quiz to the ORACLE database...:)");
                            System.out.println("Insert function ended....");
      }              
      
      protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
          HttpSession session = request.getSession();
     
          System.out.print(".....................* Subject Response Started *................................");
          
          if(request.getParameter("opt1") != null){
           iwt_response = request.getParameter("opt1");
           System.out.println("I am inside subject response : "+iwt_response);
           session.setAttribute("subClicked", iwt_response); 
          }
          else  if(request.getParameter("opt2") != null){
           dccn_response = request.getParameter("opt2");
           System.out.println("I am inside subject response : "+dccn_response);
            session.setAttribute("subClicked", dccn_response);
          }
          else  if(request.getParameter("opt3") != null){
           os_response = request.getParameter("opt3");
           System.out.println("I am inside subject response : "+os_response);
           session.setAttribute("subClicked", os_response);
          }
          
          
  try{
        System.out.println("Creating table for short quiz.....");
        createSQTable(con);
         System.out.println("Creating table for long quiz.....");
        createLQTable(con); 
        
        //FOR IWT LECTURES 
        
        insertIntoSQTable(con,"IWTLEC01SQ01","Every Web page opens with HTML","T");
        insertIntoLQTable(con,"IWTLEC01LQ01","HTML is what type of language ?","Scripting Language","Markup Language","Programming Language","Network Protocol","b");       
        insertIntoLQTable(con,"IWTLEC01LQ02","The correct sequence of HTML tags for starting a webpage is","Head, Title, HTML, body","HTML, Body, Title, Head","HTML, Head, Title, Body","HTML, Head, Title, Body","d");       
        insertIntoLQTable(con,"IWTLEC01LQ03","What is the full form of HTML ?","HyperText Markup Language","Hyper Teach Markup Language","Hyper Tech Markup Language","None of these", "a");       
           
         insertIntoSQTable(con,"IWTLEC02SQ01","CSS can add background images to documents","T");
         insertIntoLQTable(con,"IWTLEC02LQ01","What does CSS stand for ?","Creative Style Sheets","Colorful Style Sheets","Cascading Style Sheets","Computer Style Sheets","c");       
         insertIntoLQTable(con,"IWTLEC02LQ02","Which is the correct CSS syntax?","body {color: black}",". {body;color:black}","{body:color=black(body}","body:color=black","a");       
         insertIntoLQTable(con,"IWTLEC02LQ03","Which property is used to change the background color?","bgcolor","background-color","color","Background", "b");       

         insertIntoSQTable(con,"IWTLEC03SQ01","The modulus operator (%) in Java can be used only with variables of integer type","F");
         insertIntoLQTable(con,"IWTLEC03LQ01","What is the range of byte data type in Java?","-128 to 127","-32768 to 32767","-2147483648 to 2147483647","None of the mentioned","a");       
         insertIntoLQTable(con,"IWTLEC03LQ02","Literal can be of which of these data types?","integer","float","boolean","all of the mentioned","d");       
         insertIntoLQTable(con,"IWTLEC03LQ03","Java Source Code is compiled into ______________.","Obj","Source Code","Bytecode","Exe", "c");       

        //FOR DCCN LECTURES 
         
         insertIntoSQTable(con,"DCCNLEC01SQ01","Wireless networking is insecure.","T");
         insertIntoLQTable(con,"DCCNLEC01LQ01","Which of the following networks extends a private network across public networks?","local area network","virtual private network","enterprise private network","storage area network","b");       
         insertIntoLQTable(con,"DCCNLEC01LQ02","A ____ is a device that forwards packets between networks by processing the routing information included in the packet.","bridge","firewall","router","hub","c");       
         insertIntoLQTable(con,"DCCNLEC01LQ03","Bluetooth is an example of ____","personal area network","local area network","virtual private network","wide area network", "a");       
           
         insertIntoSQTable(con,"DCCNLEC02SQ01","Network services do not include messaging ","F");
         insertIntoLQTable(con,"DCCNLEC02LQ01","How many layers are present in the Internet protocol stack (TCP/IP model)?","5","7","6","10","a");       
         insertIntoLQTable(con,"DCCNLEC02LQ02","The number of layers in ISO OSI reference model is ________","5","7","6","10","b");       
         insertIntoLQTable(con,"DCCNLEC02LQ03","Which of the following layers is an addition to OSI model when compared with TCP IP model?","Application layer","Presentation layer","Session layer","Session and Presentation layer", "d");       

          insertIntoSQTable(con,"DCCNLEC03SQ01","LANs provide global connections for thousands of computers","F");
          insertIntoLQTable(con,"DCCNLEC03LQ01","What are the Three common types of computer Networks?","ROM, MAN,LAN","RAM,WAN,LAN","MAN,LAN,WAN","NONE OF THE ABOVE","c");       
          insertIntoLQTable(con,"DCCNLEC03LQ02","What is the acronym for LAN?","Local Area Network","Line And Networking","Line-less Networking","Line And Networking","a");       
          insertIntoLQTable(con,"DCCNLEC03LQ03","What is the acronym MAN stand for?","Magnetic Access Network","Metropolitan Area Network","Multi- Area Network","Multi-Access net", "b");       

         //FOR OS LECTURES 
          
         insertIntoSQTable(con,"OSLEC01SQ01","Operating system is a program which provides a means of communication between the computer and the person working on it. ","T");
         insertIntoLQTable(con,"OSLEC01LQ01","Which of the following is not an operating system","Linux","Oracle","DOS","Windows","b");       
         insertIntoLQTable(con,"OSLEC01LQ02","What else is a command interpreter called?","prompt","kernel","shell","command","c");       
         insertIntoLQTable(con,"OSLEC01LQ03","What is the mean of the Booting in the operating system?","Restarting computer","Install the program","To scan","To turn off", "a");       

         insertIntoSQTable(con,"OSLEC02SQ01","When process is scheduled to run after some execution, it is called ready state of the  process","T");
         insertIntoLQTable(con,"OSLEC02LQ01","The systems which allow only one process execution at a time, are called __________","uniprogramming systems","uniprocessing systems","unitasking systems","none of the mentioned","b");       
         insertIntoLQTable(con,"OSLEC02LQ02","In Unix, Which system call creates the new process?","fork","create","new","none of the mentioned","a");       
         insertIntoLQTable(con,"OSLEC02LQ03","A process stack does not contain __________","Function parameters","Local variables","Return addresses","PID of child process", "d");       

         insertIntoSQTable(con,"OSLEC03SQ01","In the Many to Many models when a thread performs a blocking system call other threads are strictly prohibited from running ","F");
         insertIntoLQTable(con,"OSLEC03LQ01","The model in which one kernel thread is mapped to many user-level threads is called ___________","Many to One model","One to Many model","Many to Many model","One to One model","a");       
         insertIntoLQTable(con,"OSLEC03LQ02","The feature of hyperthreading is","simultaneous multithreading","switching is not required","effective use of processor resources","all of the mentioned","d");       
         insertIntoLQTable(con,"OSLEC03LQ03","Which one of the following is not shared by threads?","program counter","stack","both program counter and stack","none of the mentioned", "c");       

          }catch(Exception e){
              System.out.println("****Quiz table exists no need to create table*****");
          }
           
         System.out.print(".....................* Subject Response Ended *................................");
      }
}
