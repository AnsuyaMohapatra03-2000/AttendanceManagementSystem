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

    <link href="assets/css/faculty/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/faculty/dashboard.css" rel="stylesheet" type="text/css"/>
</head>
<%
       String fid = (String)session.getAttribute("FID");
       String fname = (String)session.getAttribute("Faculty_fname");
       String lname = (String)session.getAttribute("Faculty_lname");
       String email = (String)session.getAttribute("Faculty_email");
       String subject = (String)session.getAttribute("Faculty_subject"); 
       subject = subject.toUpperCase();
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
                    <li>
                        <a class="nav-link" href="FacultyDashboard.jsp">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>DASHBOARD</p>
                        </a>
                    </li>
                    <li class="nav-item active">
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
                                <a class="navbar-brand" href="FacultyProfile.jsp">PROFILE </a>
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
                                                    <input type="text" class="form-control" disabled="" value="<%=fid%>">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 pr-1">
                                                <div class="form-group">
                                                    <label>FIRST NAME</label>
                                                    <input type="text" class="form-control" disabled value="<%=fname%>">
                                                </div>
                                            </div>
                                            <div class="col-md-6 pl-1">
                                                <div class="form-group">
                                                    <label>LAST NAME</label>
                                                    <input type="text" class="form-control" disabled value="<%=lname%>">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">Email Address</label>
                                                    <input type="email" class="form-control" disabled value="<%=email%>">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>SUBJECT </label>
                                                    <input type="text" class="form-control" disabled value="<%=subject%>">
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
<script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/dashboard.js" type="text/javascript"></script>


</html>
