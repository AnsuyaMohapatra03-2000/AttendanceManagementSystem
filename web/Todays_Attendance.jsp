<%@page import="com.Faculty.DbConnection"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.Faculty.GetProperTime"%>
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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Kumbh+Sans&display=swap" rel="stylesheet">
    
    <link href="assets/css/faculty/dashboard.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/faculty/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    
</head>
<%!
       
        ResultSet rs;
            String removeSpaces(String s1)
            {
               return s1.replaceAll("\\s", "");
            }
%>
<%
     Connection con = new DbConnection().getConnection();
       Statement st =con.createStatement();   
       String subject = ((String)session.getAttribute("Faculty_subject")).toUpperCase(); 
       subject = removeSpaces(subject);
       System.out.println("I am in FACULTY QUIZDATA and my subject is : "+ subject);

     Date date = new Date();
     String todaysDate = date.toString();
     GetProperTime today = new GetProperTime(todaysDate);
    
     String month = today.getMonth();
     String todays_date = today.getDate();
     String day = today.getDay();
%>
<body>
    <div class="wrapper">
        <div class="sidebar">
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="FacultyDashboard.jsp" class="simple-text">
                        BACK
                    </a>
                </div>
                <ul class="nav">
                   
                </ul>
            </div>
        </div>

        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
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
                        <div class="col-md-12">
                            <div class="card strpied-tabled-with-hover">
                                <div class="card-header ">
                                    <h4 class="card-title">TODAY'S ATTENDANCE</h4>
                                </div>
                                <div class="card-body table-full-width table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <th>ID</th>
                                            <th>FIRST NAME</th>
                                            <th>LAST NAME</th>
                                        </thead>
                                       <% try{                                                        
                                             String countTotal = "select * from AttendanceCount where Attendance_date='"+todays_date+"' and Attendance_Subject='"+removeSpaces(subject)+"' and Attendance_Day='"+day+"'";
                                              rs = st.executeQuery(countTotal);
                                               while(rs.next()){
                                          %>
                                        <tbody>
                                            <tr>
                                                <td><%=rs.getString(5)%></td>
                                                <td><%=rs.getString(6)%></td>
                                                <td><%=rs.getString(7)%></td>
                                            </tr>
                                        </tbody>
                                        <%
                                              }
                                       }catch(Exception e){
                                       %>
                                          <tbody>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                        <%}%>                                
                                    </table>
                                </div>
                            </div>
                        </div>               
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
