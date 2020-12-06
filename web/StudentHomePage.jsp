<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <title>STUDENT HOME</title>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Kumbh+Sans&display=swap" rel="stylesheet">
    <% System.out.println("*****Starting of Student Profile Page/Home Page*****");
        session = request.getSession(); 
        String id = (String)session.getAttribute("ID");%>
        
    <!-- CSS Files -->
    <link href="assets/css/faculty/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/student/dashboard.css" rel="stylesheet" />

<%
      
       String fname = (String)session.getAttribute("FNAME");
       String lname = (String)session.getAttribute("LNAME");
       String email = (String)session.getAttribute("EMAIL");
       String subject1 = (String)session.getAttribute("SUBJECT_1");
       String subject2 = (String)session.getAttribute("SUBJECT_2");
       String subject3 = (String)session.getAttribute("SUBJECT_3");
       String loginTime = (String)session.getAttribute("LOGIN_TIME");  
       
       String selectQuery;
       byte[] img = null;
       ServletOutputStream sos = null;
       
       if(subject1 == null){
           subject1 = "   ";
       }
       if(subject2 == null){
           subject2 = "  ";
       }
       if(subject3 == null){
           subject3 = "   ";
       }    
     %>
<body>
    <div class="wrapper">
        <div class="sidebar">
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="#" class="simple-text">
                        STUDENT
                    </a>
                </div>
                <ul class="nav">
                    <li class="nav-link">
                        <div class="profile_info">
                            <img class="profile_image" src="ProfilePicDisplayServlet">
                            <h5 class="title"><%=(fname +" "+ lname)%></h5>
                        </div>
                    </li>
                    <li>
                        <a id="dashboardAnchor" class="nav-link" href="dashboardStudent.jsp">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="StudentHomePage.jsp">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Profile</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="lectureCards.jsp">
                            <i class="nc-icon nc-notes"></i>
                            <p>Lectures</p>
                        </a>
                    </li>   
                </ul>
            </div>
        </div>

        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#"> PROFILE </a>

                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="LogoutInfo">
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
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">PROFILE</h4>
                                </div>
                                <div class="card-body">
                                    <form>
                                        <div class="row">
                                            <div class="col-md-6 pr-1">
                                                <div class="form-group">
                                                    <label>COLLEGE</label>
                                                    <input type="text" class="form-control" disabled=""value="IIIT Bh">
                                                </div>
                                            </div>
                                            <div class="col-md-6 pl-1">
                                                <div class="form-group">
                                                    <label>ID</label>
                                                    <input type="text" id="studID"class="form-control" disabled="" value=<%=id%>>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 pr-1">
                                                <div class="form-group">
                                                    <label>FIRST NAME</label>
                                                    <input type="text" class="form-control" disabled="" value=<%=fname%>>
                                                </div>
                                            </div>
                                            <div class="col-md-6 pl-1">
                                                <div class="form-group">
                                                    <label>LAST NAME</label>
                                                    <input type="text" class="form-control" disabled="" value=<%=lname%>>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">EMAIL</label>
                                                    <input type="email" class="form-control" disabled="" value=<%=email%>>
                                                </div>
                                            </div>
                                        </div>
                                                
                                        <div class="row">
                                            <div class="col-md-4 pr-1">
                                                <div class="form-group">
                                                    <label>SUBJECT 1</label>
                                                    <input type="text" class="form-control" disabled="" value=<%=subject1%>>
                                                </div>
                                            </div>
                                            <div class="col-md-4 px-1">
                                                <div class="form-group">
                                                    <label>SUBJECT 2</label>
                                                    <input type="text" class="form-control" disabled="" value=<%=subject2%>>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>SUBJECT 3</label>
                                                    <input type="text" class="form-control" disabled="" value=<%=subject3%>>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>                           
                    </div>   
                </div>
            </div>        
        </div>
    </div>
</body>

<!--  JS Files   -->
<script src="assets/js/jquery-1.9.1.min.js"></script>
<script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/dashboard.js" type="text/javascript"></script>
<% System.out.println("*****Ending of Student Profile Page/Home Page*****");%>
</html>
