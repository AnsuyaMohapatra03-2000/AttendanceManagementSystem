<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>STUDENT HOME</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Kumbh+Sans&display=swap" rel="stylesheet">
    <script src="js/jquery-1.9.1.min.js"></script>

    <link href="assets/css/faculty/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/student/dashboard.css" rel="stylesheet" />

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <link rel="stylesheet" type="text/css" href="assets/css/home/style_sublist.css">
    <% System.out.println("************ Starting of Lecture Cards ******************"); %>
    <script>
                 $(document).ready(function(){
                     $('#iwt1').click(function(event){
                         var toSend = 'iwt1';
                         $.get('SubjectResponse',{opt1:toSend},function(responseText){
                             
                         });
                     });       
                       $('#iwt2').click(function(event){
                         var toSend = 'iwt2';
                         $.get('SubjectResponse',{opt1:toSend},function(responseText){
                             
                         });
                     });  
                     $('#iwt3').click(function(event){
                         var toSend = 'iwt3';
                         $.get('SubjectResponse',{opt1:toSend},function(responseText){
                             
                         });
                     });   
                  $('#dccn1').click(function(event){
                         var toSend = 'dccn1';
                         $.get('SubjectResponse',{opt2:toSend},function(responseText){
                             
                         });
                     }); 
                   $('#dccn2').click(function(event){
                         var toSend = 'dccn2';
                         $.get('SubjectResponse',{opt2:toSend},function(responseText){
                             
                         });
                     }); 
                     $('#dccn3').click(function(event){
                         var toSend = 'dccn3';
                         $.get('SubjectResponse',{opt2:toSend},function(responseText){
                             
                         });
                     }); 
                      $('#os1').click(function(event){
                         var toSend = 'os1';
                         $.get('SubjectResponse',{opt3:toSend},function(responseText){
                             
                         });
                     });
                     $('#os2').click(function(event){
                         var toSend = 'os2';
                         $.get('SubjectResponse',{opt3:toSend},function(responseText){
                             
                         });
                     });
                     $('#os3').click(function(event){
                         var toSend = 'os3';
                         $.get('SubjectResponse',{opt3:toSend},function(responseText){                     
                         });
                     });
    });
  </script>
</head>

<body>
     <%   session = request.getSession(); 
            String id = (String)session.getAttribute("ID");
            System.out.println("I am in the student lectureCards and my id is : "+id);
            String fname = (String)session.getAttribute("FNAME");
            String lname = (String)session.getAttribute("LNAME");
            String email = (String)session.getAttribute("EMAIL");
            String subject1 = (String)session.getAttribute("SUBJECT_1");
            String subject2 = (String)session.getAttribute("SUBJECT_2");
            String subject3 = (String)session.getAttribute("SUBJECT_3");  
            String loginTime = (String)session.getAttribute("LOGIN_TIME");  
            if(subject1 == null){
                subject1 = "NA";
            }
            if(subject2 == null){
                subject2 = "NA";
            }
            if(subject3 == null){
                subject3 = "NA";
            }
%>         
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
                        <a class="nav-link" href="dashboardStudent.jsp">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>DASHBOARD</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="StudentHomePage.jsp">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>PROFILE</p>
                        </a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">
                            <i class="nc-icon nc-notes"></i>
                            <p>LECTURES</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#"> LECTURES </a>
                    
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <ul class="nav navbar-nav mr-auto">
                            <li class="nav-item">
                                <a href="#" class="nav-link" data-toggle="dropdown">
                                    <span class="d-lg-none">DASHBOARD</span>
                                </a>
                            </li>
                        </ul>
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
                            <section class="sub-list">
                              <div class="container-fluid">
                                <div class="container">    
                                  <div class="row">
                                  <%    if(subject1.equalsIgnoreCase("iwt") || subject2.equalsIgnoreCase("iwt") || subject3.equalsIgnoreCase("iwt")) {  %>    
                                    <div class="col-sm-4">
                                      <div class="card-subject text-center">
                                        <div class="title-sub">
                                          <i class="fa fa-internet-explorer"></i>
                                          <h2>Internet and Web Technologies</h2>
                                        </div>
                                          <a id="iwt1" href="Videos_Page_1.jsp">Lecture 01</a>
                                            <a id="iwt2" href="Videos_Page_2.jsp">Lecture 02</a>
                                            <a id="iwt3" href="Videos_Page_3.jsp">Lecture 03</a>
                                      </div>
                                    </div>
                                   <% } %>
                                    <!-- END Col one -->
                                    <%    if(subject1.equalsIgnoreCase("os") || subject2.equalsIgnoreCase("os") || subject3.equalsIgnoreCase("os")) {  %>
                                    <div class="col-sm-4">
                                      <div class="card-subject text-center">
                                        <div class="title-sub">
                                          <i class="fa fa-windows" ></i>
                                          <h2>Operating <br> System</h2>
                                        </div>
                                        <a id="os1" href="Videos_Page_1.jsp">Lecture 01</a>
                                        <a id="os2" href="Videos_Page_2.jsp">Lecture 02</a>
                                        <a id="os3" href="Videos_Page_3.jsp">Lecture 03</a>
                                      </div>
                                    </div>
                                     <% } %>
                                   <%    if(subject1.equalsIgnoreCase("dccn") || subject2.equalsIgnoreCase("dccn") || subject3.equalsIgnoreCase("dccn")) {  %>
                                    <!-- END Col two -->
                                    <div class="col-sm-4">
                                      <div class="card-subject text-center">
                                        <div class="title-sub">
                                          <i class="fa fa-wifi"></i>
                                          <h2>Data Communication and Computer Networks</h2>
                                        </div>
                                        <a id="dccn1" href="Videos_Page_1.jsp">Lecture 01</a>
                                        <a id="dccn2" href="Videos_Page_2.jsp">Lecture 02</a>
                                        <a id="dccn3" href="Videos_Page_3.jsp">Lecture 03</a>
                                      </div>
                                    </div>
                                  <% } %>
                                    <!-- END Col three -->
                                  </div>
                                </div>
                              </div>
                            </section>
                        </div>
                    
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    
</body>
<!--   Core JS Files   -->
<script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/dashboard.js" type="text/javascript"></script>

 <% System.out.println("************ Ending of Lecture Cards ******************"); %>
</html>

