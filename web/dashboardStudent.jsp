<%@page import="com.Student.DbConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>STUDENT HOME </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />

    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>

   <link href="https://fonts.googleapis.com/css2?family=Kumbh+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
  
    <link href="assets/css/faculty/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/student/dashboard.css" rel="stylesheet" />
    
<%!
        
        String countSt ;
        ResultSet rs ;
        double iwtPer=0,dccnPer=0,osPer=0;
        String day;int i;
        String dayTime[][] = new String[5][3];            
        String removeSpaces(String s1)
        {   
            return s1.replaceAll("\\s", "");
        }
%>
    
    <%     System.out.println("Dashboard student started...");
        
         for(int p = 0 ; p<5 ; p++){
            for(int k=0 ; k<3 ; k++){
                if(dayTime[p][k] == null){
                    dayTime[p][k] = " ";
                }
                           }
                }       
         session = request.getSession(); 
            String id = (String)session.getAttribute("ID");
            System.out.println("I am in the student dashboard and my id is : "+id);
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
            System.out.println(fname +" " + lname +" " + email +" "+ subject1 +" "+ subject2+" " + subject3 + " "+ loginTime);       
     %>   
</head>
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
                    <li class="nav-item active">
                        <a class="nav-link" href="dashboardStudent.jsp">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                    <li>
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

                    <a class="navbar-brand" href="#"> DASHBOARD </a>

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
    <%    
        Connection conn = new DbConnection().getConnection();
        Statement st =conn.createStatement();
        if(subject1.equalsIgnoreCase("iwt") || subject2.equalsIgnoreCase("iwt") || subject3.equalsIgnoreCase("iwt")) 
        {      
              String countSt = "select * from IWT_Students ";
              System.out.println(countSt);
              rs = st.executeQuery(countSt);
                             
               while(rs.next()) {
                     System.out.println("Inside iwt while loop...");
                        if(removeSpaces(rs.getString(2)).equalsIgnoreCase(id)){
                              System.out.println("Inside iwt if loop...");
                          double ac = rs.getInt(5);
                          double tc = rs.getInt(6);
                          if(ac==0 && tc==0){
                              iwtPer=0;
                               System.out.println(iwtPer);
                         }
                          else if(tc==0){
                                          iwtPer=0;
                                      }
                          else{
                              iwtPer= (ac/tc);
                              System.out.println(iwtPer);
                          }                    
                    }
               }  //end of while      
        }
       if(subject1.equalsIgnoreCase("dccn") || subject2.equalsIgnoreCase("dccn") || subject3.equalsIgnoreCase("dccn")) 
        {       
              String countSt = "select * from DCCN_Students";
                System.out.println(countSt);
              ResultSet rs = st.executeQuery(countSt);
                             
               while(rs.next()) {    
                        System.out.println("Inside dccn while loop...");
                        if(removeSpaces(rs.getString(2)).equalsIgnoreCase(id)){
                              System.out.println("Inside dccn if loop...");
                           double  ac = rs.getInt(5);
                           double  tc = rs.getInt(6);
                          if(ac==0 && tc==0){
                              dccnPer=0;
                               System.out.println(dccnPer);
                         }
                          else if(tc==0){
                                          dccnPer=0;
                                      }
                          else{
                              dccnPer= (ac/tc);
                                System.out.println(dccnPer);
                          }                    
                     }
               }    
      }
      if(subject1.equalsIgnoreCase("os") || subject2.equalsIgnoreCase("os") || subject3.equalsIgnoreCase("os")) 
        {       
              String countSt = "select * from OS_Students ";
                System.out.println(countSt);
              ResultSet rs = st.executeQuery(countSt);
                             
               while(rs.next()) {     
                   System.out.println("Inside os while loop...");
                       if(removeSpaces(rs.getString(2)).equalsIgnoreCase(id)){          
                            {
                                System.out.println("Inside os if loop...");
                                      double ac = rs.getInt(5);
                                      double tc = rs.getInt(6);
                                      if(ac==0 && tc==0){
                                          osPer=0;
                                            System.out.println(osPer);
                                     }
                                      else if(tc==0){
                                          osPer=0;
                                      }
                                      else{
                                          osPer= (ac/tc);
                                              System.out.println(osPer);
                                      }                    
                          }
               }  //end of while loop
       }
        }
    %>

            <!-- End Navbar -->
            <div class="content">
                <div class="container-fluid">

                    <div class="row">
                        <div class="container col-md-12">
                            <div class="card">
                                <div class="card-header ">
                                <h4 class="card-title">ATTENDANCE</h4>
                                <p class="card-category">Subject-Wise</p>
                            </div>
                            <section id="circleBar">
                        
                            <div class="row-progress">
                             <%    if(subject1.equalsIgnoreCase("iwt") || subject2.equalsIgnoreCase("iwt") || subject3.equalsIgnoreCase("iwt")) {  %>
                                <div class="col-md-3">                        
                                    <div class="round" data-value="<%=iwtPer%>" data-size="200" data-thickness="6">
                                        <strong></strong>
                                        <span> IWT</span>
                                    </div>
                                </div>
                                <%   }   %>
                                 <%    if(subject1.equalsIgnoreCase("os") || subject2.equalsIgnoreCase("os") || subject3.equalsIgnoreCase("os")) {  %>
                                <div class="col-md-3">                    
                                    <div class="round" data-value="<%=osPer%>" data-size="200" data-thickness="6">
                                    <strong></strong>
                                    <span>OS</span>
                                </div>
                                </div>
                                 <%   }   %>
                                  <%    if(subject1.equalsIgnoreCase("dccn") || subject2.equalsIgnoreCase("dccn") || subject3.equalsIgnoreCase("dccn")) {  %>
                                <div class="col-md-3">            
                                    <div class="round" data-value="<%=dccnPer%>" data-size="200" data-thickness="6">
                                        <strong></strong>
                                        <span> DCCN</span>
                                    </div>
                                </div>
                                 <%   }   %>
                            </div>
                            </section>  
                            </div>
                            
                        </div>
                    </div>
                            
                            
          <%
                    
          %>            
                        
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card strpied-tabled-with-hover">
                                <div class="card-header ">
                                    <h4 class="card-title">TIME TABLE </h4>
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
          try{              
                        countSt = "select * from Time_Table";          
                         rs = st.executeQuery(countSt);
                  
         int i = 2;
         while(rs.next()) {
                              
                        if(rs.getString(1).equalsIgnoreCase(subject1) || rs.getString(1).equalsIgnoreCase(subject2) || rs.getString(1).equalsIgnoreCase(subject3)) {
          //FOR MONDAY                 
                                 if(rs.getString(2)!=null)                      
                                 {                 
                                       if(rs.getString(2).equalsIgnoreCase("10-11")){     //monday first slot
                                           dayTime[0][0] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                       }
                                       if(rs.getString(2).equalsIgnoreCase("11-12")){    //monday second slot
                                           dayTime[0][1] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                      }
                                       if(rs.getString(2).equalsIgnoreCase("12-1")){    //monday third slot
                                           dayTime[0][2] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                      }
                                   }
                                  
               //FOR TUESDAY 
                                 if(rs.getString(3)!=null)                                          
                                 {                 
                                       if(rs.getString(3).equalsIgnoreCase("10-11")){    
                                           dayTime[1][0] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                       }
                                       if(rs.getString(3).equalsIgnoreCase("11-12")){    
                                           dayTime[1][1] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                      }
                                       if(rs.getString(3).equalsIgnoreCase("12-1")){    
                                           dayTime[1][2] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                      }
                                   }
                                  
                //FOR WEDNESDAY
                                 if(rs.getString(4)!=null)                                           
                                 {                   
                                       if(rs.getString(4).equalsIgnoreCase("10-11")){    
                                           dayTime[2][0] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                       }
                                       if(rs.getString(4).equalsIgnoreCase("11-12")){   
                                           dayTime[2][1] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                      }
                                       if(rs.getString(4).equalsIgnoreCase("12-1")){    
                                           dayTime[2][2] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                      }
                                   }
                                 
                   //FOR THURSDAY
                                 if(rs.getString(5)!=null)
                                 {                 //monday  
                                       if(rs.getString(5).equalsIgnoreCase("10-11")){     
                                           dayTime[3][0] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                       }
                                       if(rs.getString(5).equalsIgnoreCase("11-12")){    
                                           dayTime[3][1] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                      }
                                       if(rs.getString(5).equalsIgnoreCase("12-1")){   
                                           dayTime[3][2] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                      }
                                   }
                                 
                     //FOR FRIDAY
                                 if(rs.getString(6)!=null)
                                 {                 //monday  
                                       if(rs.getString(6).equalsIgnoreCase("10-11")){    
                                           dayTime[4][0] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                       }
                                       if(rs.getString(6).equalsIgnoreCase("11-12")){    
                                           dayTime[4][1] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                      }
                                       if(rs.getString(6).equalsIgnoreCase("12-1")){    
                                           dayTime[4][2] = rs.getString(1);
                                           System.out.println("value of i : "+ i + " subject :"+rs.getString(1));
                                      }
                                 }
                                   }
                            }   //end of while loop
                                              
                          for(int p = 0 ; p<5 ; p++){
                                for(int k=0 ; k<3 ; k++){
                                           if(dayTime[p][k] == null){
                                                    dayTime[p][k] = " ";
                                               }
                                }
                            }                        
                      }     
          catch(Exception e){
              
                        System.out.println("Oops the Time_Table does not exists...:)");
                        for(int p = 0 ; p<5 ; p++){
                                for(int k=0 ; k<3 ; k++){                                 
                                                    dayTime[p][k] = " ";                                            
                                }
                            }             
                    }
     %>          
                                        <tbody>
                                            <tr>
                                                <td>MONDAY</td>
                                                <td><%=dayTime[0][0]%></td>
                                                <td><%=dayTime[0][1]%></td>
                                                <td><%=dayTime[0][2]%></td>
                                            </tr>
                                            <tr>
                                                <td>TUESDAY</td>
                                                 <td><%=dayTime[1][0]%></td>
                                                <td><%=dayTime[1][1]%></td>
                                                <td><%=dayTime[1][2]%></td>
                                            </tr>
                                            <tr>
                                                <td>WEDNESDAY</td>
                                                 <td><%=dayTime[2][0]%></td>
                                                <td><%=dayTime[2][1]%></td>
                                                <td><%=dayTime[2][2]%></td>
                                            </tr>
                                            <tr>
                                                <td>THURSDAY</td>
                                                   <td><%=dayTime[3][0]%></td>
                                                <td><%=dayTime[3][1]%></td>
                                                <td><%=dayTime[3][2]%></td>
                                            </tr>
                                            <tr>
                                                <td>FRIDAY</td>
                                                   <td><%=dayTime[4][0]%></td>
                                                <td><%=dayTime[4][1]%></td>
                                                <td><%=dayTime[4][2]%></td>
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
   
</body>
<!--   Core JS Files   -->
<script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/dashboard.js" type="text/javascript"></script>

 <script src='js/jquery.min.js'></script>
<script src='js/circle-progress.min.js'></script>

<script type="text/javascript">
    function Circlle(el){
      $(el).circleProgress({fill: {color: '#800080'}})
        .on('circle-animation-progress', function(event, progress, stepValue){
                        $(this).find('strong').text((stepValue*100).toFixed(0) + "%");
                });  
    };
    Circlle('.round');
</script>

</html>
