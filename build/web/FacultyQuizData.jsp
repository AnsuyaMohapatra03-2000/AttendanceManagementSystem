<%@page import="java.lang.String"%>
<%@page import="com.Faculty.DbConnection"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>FACULTY HOME</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <link href="https://fonts.googleapis.com/css2?family=Kumbh+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <link href="assets/css/faculty/dashboard.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/faculty/bootstrap.min.css" rel="stylesheet" type="text/css"/>

</head>
<%!
       
            String removeSpaces(String s1)
            {
                 return s1.replaceAll("\\s", "");
            }
%>
<%
       String subject = ((String)session.getAttribute("Faculty_subject")).toUpperCase(); 
       subject = removeSpaces(subject);
       System.out.println("I am in FACULTY QUIZDATA and my subject is : "+ subject);
%>
<body>
    <div class="wrapper">
        <div class="sidebar">
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a class="simple-text">
                        FACULTY
                    </a>
                </div>
                <ul class="nav">
                    <li>
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
                    <li class="nav-item active">
                        <a class="nav-link" href="#">
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
                                <a class="navbar-brand" href="#">STUDENTS </a>
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
                        <div class="col-md-12">
                           <div class="card strpied-tabled-with-hover">
                                <div class="card-header ">
                                    <h4 class="card-title">QUIZ RESPONSE</h4>
                                </div>
                                <div class="card-body table-full-width table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <th>ID</th>
                                            <th>NAME</th>
                                            <th>LECTURE</th>
                                            <th>SHORT QUIZ</th>
                                            <th>FINAL QUIZ</th>
                                        </thead>
                                        
                 <%
        Connection con = new DbConnection().getConnection();
            try{
                String query = "select s.ID,s.Subject,l.Subject,s.Lecture_No,s.FIRST_NAME,s.LAST_NAME,s.marks_obtained,l.marks_obtained "
                                     + "from ShortQuizResponse s,LongQuizResponse l"
                                     +" where s.ID = l.ID and s.Subject = l.subject and s.Lecture_no = l.Lecture_no";
                Statement st =con.createStatement();                               
                System.out.println(query);
                ResultSet rs = st.executeQuery(query);
                 while(rs.next()){
                      if(removeSpaces(rs.getString(2)).equalsIgnoreCase(subject)){
              %>
                                        <tbody>
                                            <tr>
                                                <td><%=rs.getString(1)%></td>
                                                <td><%=(rs.getString(5)+" "+rs.getString(6))%></td>
                                                <td><%=rs.getString(4)%></td>
                                                <td><%=rs.getInt(7)%></td>
                                                <td><%=rs.getInt(8)%></td>
                                            </tr>
                                            </tbody>
         <%            
                     }
                 }     
          }
         catch(Exception e ){
             System.out.println("No one has appeared the quiz! ");
         %> <tbody>
              <tr>
                    <td></td>
                    <td></td>
                     <td></td>
                    <td></td>
                    <td></td>
              </tr>
          <%}%>
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

</body>
<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="../assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="../assets/js/dashboard.js" type="text/javascript"></script>


</html>

