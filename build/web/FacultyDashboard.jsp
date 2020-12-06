<%@page import="com.Faculty.GetProperTime"%>
<%@page import="com.Faculty.DbConnection"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>FACULTY HOME </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />

    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>
    <link href="https://fonts.googleapis.com/css2?family=Kumbh+Sans&display=swap" rel="stylesheet">
  
    <link href="assets/css/faculty/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/faculty/dashboard.css" rel="stylesheet" type="text/css"/>
</head>
<%!
       String mon ="";
       String tues ="";
       String wed ="";
       String thurs ="";
       String fri ="";
       String timeslot1="";
       String timeslot2="";
       String timeslot3="";
       ResultSet rs ;
        
            String removeSpaces(String s1)                    
            {
                 return s1.replaceAll("\\s", "");
            }
%>
<%  int countRegister=0;
    int countPresent=0;
    Connection con = new DbConnection().getConnection();
    String subject = ((String)session.getAttribute("Faculty_subject")).toUpperCase(); 
     subject = removeSpaces(subject);
     System.out.println("I am in FACULTY DASHBOARD and my subject is : "+ subject);
     String tableName = removeSpaces(subject)+"_Students";
     System.out.println(tableName);
     try{
                 Statement st =con.createStatement();                            
                 String countSt = "select count(*) from "+tableName;
                 System.out.println(countSt);
                  rs = st.executeQuery(countSt);
                 while(rs.next()){
                     countRegister = rs.getInt(1);
                 }
     }catch(Exception e){
         System.out.println("NO STUDENTS HAVE REGISTERED FOR YOUR SUBJECT !!");
     }
    Date date = new Date();
    String todaysDate = date.toString();
    GetProperTime today = new GetProperTime(todaysDate);
    
    String month = today.getMonth();
    String todays_date = today.getDate();
    String day = today.getDay();
    try{
      Statement st =con.createStatement();                   
      String countTotal = "select count(*) from AttendanceCount where Attendance_date='"+todays_date+"' and Attendance_Subject='"+removeSpaces(subject)+"' and Attendance_Day='"+day+"'";
//     System.out.println(countTotal);
     rs = st.executeQuery(countTotal);
     while(rs.next()){
         System.out.println(rs.getInt(1));
         countPresent = rs.getInt(1);
        }
    }catch(Exception e){
        System.out.println("YOU DID NOT TAKE ANY CLASS YET!");
    }     
%>
<body>
    <div class="wrapper">
        <div class="sidebar">
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="#" class="simple-text">
                        FACULTY
                    </a>
                </div>
                <ul class="nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="FacultyDashboard.jsp">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>DASHBOARD</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="FacultyProfile.jsp">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>PROFILE</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="FacultyQuizData.jsp">
                            <i class="nc-icon nc-notes"></i>
                            <p>STUDENTS</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>


        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class="container-fluid">

                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <ul class="nav navbar-nav mr-auto">
                            <li class="nav-item">
                                <a class="navbar-brand" href="#">DASHBOARD </a>
                            </li>
                        </ul>
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="LogoutFaculty">
                                    <span class="no-icon">LOG OUT</span>
                                </a>
                            </li>
                        </ul>
                    </div>

                </div>
            </nav>


            <!-- End Navbar -->
            <div class="content">
                <div class="container-fluid">

                    <div class="row">
                        <div class="col-lg-3 col-md-6 col-sm-6">
                          <div class="card card-stats">
                            <div class="card-header card-header-warning card-header-icon">
                              <div class="card-icon">
                                <i class="material-icons">TOTAL REGISTERED</i>
                              </div>
                                <h1 class="card-title"><%=countRegister%></h1>
                            </div>
                            <div class="card-footer">
                              <div class="stats">
                                <a href="Registered_Student_List.jsp">Details</a>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6">
                          <div class="card card-stats">
                            <div class="card-header card-header-success card-header-icon">
                              <div class="card-icon">
                                <i class="material-icons">TOTAL PRESENT</i>
                              </div>
                              <h1 class="card-title"><%=countPresent%></h1>
                            </div>
                            <div class="card-footer">
                              <div class="stats">
                                <a href="Todays_Attendance.jsp">Details</a>
                              </div>
                            </div>
                          </div>
                        </div>
                    </div>
         <%       
                System.out.println("......Starting the code for TimeTable........................");
                String forTT = "select * from Time_Table";
                System.out.println(forTT);
                Statement state =con.createStatement();   
                rs = state.executeQuery(forTT);
                if(rs==null){
                      System.out.println("Here TT Result set is null.....................");
                }
                while(rs.next()){
                     System.out.println("inside while loop");
                     System.out.println(rs.getString(1));
                    if(rs.getString(1).equalsIgnoreCase(subject)){              
                        if(rs.getString(2)!=null)                              //Monday
                            mon = rs.getString(2);
                        
                       if(rs.getString(3)!=null)                                //Tuesday
                          tues = rs.getString(3);
                        
                       if(rs.getString(4)!=null)                               //Wednesday
                           wed = rs.getString(4);
                       
                       if(rs.getString(5)!=null)                                //Thursday
                           thurs = rs.getString(5);
                        
                       if(rs.getString(6)!=null)                              //Friday
                             fri = rs.getString(6); 
                       System.out.println(rs.getString(2) + " " + rs.getString(3) + "   " + rs.getString(4) + "  "+rs.getString(5)+ "  "+rs.getString(6));
                    }
                   System.out.println("executed while loop");
                }
         %>      
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card strpied-tabled-with-hover">
                                <div class="card-header ">
                                    <h4 class="card-title">TIME TABLE</h4>
                                </div>
                                <div class="card-body table-full-width table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <th>Day</th>
                                            <th>10:00-11:00</th>
                                            <th>11:00-12:00</th>
                                            <th>12:00-1:00</th>
                                        </thead>
                                        <%
                                                timeslot1=" ";
                                                timeslot2=" ";
                                                timeslot3=" ";
                                               if(mon!=null || mon!=""){
                                                   if(removeSpaces(mon).equalsIgnoreCase("10-11")){
                                                       timeslot1="CLASS";
                                                   }
                                                   else if(removeSpaces(mon).equalsIgnoreCase("11-12")){
                                                       timeslot2="CLASS";
                                                   }
                                                   else if(removeSpaces(mon).equalsIgnoreCase("12-1")){
                                                       timeslot3="CLASS";
                                                   }
                                               }
                                        %>
                                        <tbody>
                                            <tr>
                                                <td>MONDAY</td>
                                                <td><%=timeslot1%></td>
                                                <td><%=timeslot2%></td>
                                                <td><%=timeslot3%></td>
                                            </tr>
                                            <%
                                                timeslot1=" ";
                                                timeslot2=" ";
                                                timeslot3=" ";
                                               if(tues!=null || tues!=""){
                                                   if(removeSpaces(tues).equalsIgnoreCase("10-11")){
                                                       timeslot1="CLASS";
                                                   }
                                                   else if(removeSpaces(tues).equalsIgnoreCase("11-12")){
                                                       timeslot2="CLASS";
                                                   }
                                                   else if(removeSpaces(tues).equalsIgnoreCase("12-1")){
                                                       timeslot3="CLASS";
                                                   }
                                               }
                                        %>
                                            <tr>
                                                <td>TUESDAY</td>
                                                  <td><%=timeslot1%></td>
                                                <td><%=timeslot2%></td>
                                                <td><%=timeslot3%></td>
                                            </tr>
                                       <%
                                                timeslot1=" ";
                                                timeslot2=" ";
                                                timeslot3=" ";
                                               if(wed!=null || wed!=""){
                                                   if(removeSpaces(wed).equalsIgnoreCase("10-11")){
                                                       timeslot1="CLASS";
                                                   }
                                                   else if(removeSpaces(wed).equalsIgnoreCase("11-12")){
                                                       timeslot2="CLASS";
                                                   }
                                                   else if(removeSpaces(wed).equalsIgnoreCase("12-1")){
                                                       timeslot3="CLASS";
                                                   }
                                               }
                                       %>
                                            <tr>
                                                <td>WEDNESDAY</td>
                                                 <td><%=timeslot1%></td>
                                                <td><%=timeslot2%></td>
                                                <td><%=timeslot3%></td>
                                            </tr>
                                            <tr>
                                            <%
                                                timeslot1=" ";
                                                timeslot2=" ";
                                                timeslot3=" ";
                                               if(thurs!=null || thurs!=""){
                                                   if(removeSpaces(thurs).equalsIgnoreCase("10-11")){
                                                       timeslot1="CLASS";
                                                   }
                                                   else if(removeSpaces(thurs).equalsIgnoreCase("11-12")){
                                                       timeslot2="CLASS";
                                                   }
                                                   else if(removeSpaces(thurs).equalsIgnoreCase("12-1")){
                                                       timeslot3="CLASS";
                                                   }
                                               }
                                        %>
                                                <td>THURSDAY</td>
                                                  <td><%=timeslot1%></td>
                                                <td><%=timeslot2%></td>
                                                <td><%=timeslot3%></td>
                                            </tr>
                                            <%
                                                timeslot1=" ";
                                                timeslot2=" ";
                                                timeslot3=" ";
                                               if(fri!=null || fri!=""){
                                                   if(removeSpaces(fri).equalsIgnoreCase("10-11")){
                                                       timeslot1="CLASS";
                                                   }
                                                   else if(removeSpaces(fri).equalsIgnoreCase("11-12")){
                                                       timeslot2="CLASS";
                                                   }
                                                   else if(removeSpaces(fri).equalsIgnoreCase("12-1")){
                                                       timeslot3="CLASS";
                                                   }
                                               }
                                        %>
                                            <tr>
                                                <td>FRIDAY</td>
                                                  <td><%=timeslot1%></td>
                                                <td><%=timeslot2%></td>
                                                <td><%=timeslot3%></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    
                    </div>
                </div>
            </div>
        </div>
    </div>
         <% System.out.println("......Ending the code for TimeTable........................"); %>                                   
</body>
<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="../assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="../assets/js/dashboard.js" type="text/javascript"></script>

</html>
