
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
         <script src="js/jquery-1.9.1.min.js"></script>
         <link href="https://fonts.googleapis.com/css2?family=Kumbh+Sans&display=swap" rel="stylesheet">
           <title>Result</title>
           <script>
              $(document).ready(function(){
                     $('#anchorTag').click(function(event){
                         var toSend = 'click';
                         $.get('AnchorSlotServlet',{anchorPress:toSend},function(responseText){
                         });
                     });  
                 });
        </script>
		<style>
			body{
				padding-top: 8%;
				background-image: url("img/bg-f.png");
				background-position: fixed;
				margin: 0;
			}
			p{
				padding-top: 15%;
				font-size: 30px;
				text-align: center;
			}
			.center-div{
				margin:auto;
				max-width:500px;
				background-color: #FF8a9f; 
				color:#ffffff;
				padding:10px 0;
				text-align:center;
				min-height:300px;
				border-bottom: 5px solid #A61743;
				box-shadow: 10px 5px 5px #A61743;
			}
			.fixed-footer{
				width: 100%;
		        position: fixed;        
		        background: #FF8a9f;
		        font-size: 26px;
		        color: #fff;
		        bottom: 0;
		        line-height: 40px;
			}
			.container{
				margin: 0 auto;
				padding: 10px;
				text-align: center;
			}
			a{
				text-decoration: none;
				color: #ffffff;
			}
		</style>
	</head>
	<body>
                                 <%!
                                     String anchorPage;
                                 %>
                                  <% 
                                      String message = (String)request.getAttribute("message");
                                      String anchor = (String)request.getAttribute("anchorText");
                                      String mid = (String)request.getAttribute("mid");    
                                      String anchorID="";
                                       if(mid.equalsIgnoreCase("1")){
                                           anchorPage = "facultyLogin.html";  
                                       }else{
                                           anchorPage = "facultySlotBook.html";
                                           anchorID="anchorTag";
                                       }
                                  %>
		<div class="center-div">
			<p><%  out.println(message); %></p>
		</div>
                <div class="fixed-footer">
                    <div class="container"><a id="<%=anchorID%>" href="<%=anchorPage%>"><%  out.println(anchor); %></a></div>    
                </div>                                                   
                                
    </body>
</html>
