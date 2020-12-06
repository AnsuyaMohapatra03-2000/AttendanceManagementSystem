<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>STUDENT HOME </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />

    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="https://fonts.googleapis.com/css2?family=Kumbh+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
  
    <link href="assets/css/faculty/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/student/dashboard.css" rel="stylesheet" />
<style>
     div#video_player_box{ width:550px; background:#000; margin:0px auto; }
        div#video_controls_bar{ background: #333; padding:10px; color:#CCC; display: flex;}
        input#seekslider{ width:480px; display: flex;}
        input#volumeslider{ width: 50px; display: flex;}
        .btn-v{
            cursor: pointer;
            margin: 0 3px;
            background: transparent;
        }
</style>
<%  System.out.println("************ Starting of Video Page 2 ******************"); %>
<%! String src; int halfTime; String topic; %>
<%
    String subClicked = (String) session.getAttribute("subClicked");
    session.setAttribute("videoNo","2");
    System.out.println("I am inside video page of 1 st lecture n i m watching lectures of :" +subClicked);
     
    if(subClicked.equalsIgnoreCase("iwt2")){
        src = "videos/IWT_2.mp4";
        halfTime = 195;
        topic = "CSS Tutorial for Beginners - 01 - Introduction to CSS";
        System.out.println("video 2 :" + src);
    }
    else if(subClicked.equalsIgnoreCase("dccn2")){
        src = "videos/DCCN_2.mp4";
        halfTime = 266;
        topic = "Computer Networks - Basic Characteristics";
        System.out.println("video 2 :" + src);
    }
    else if(subClicked.equalsIgnoreCase("os2")){
        src = "videos/OS_2.mp4";
        halfTime = 224;
         topic = "Process management";
        System.out.println("video 2 :" + src);
    }
%>
<script>
var vid, playbtn, seekslider, curtimetext, durtimetext, mutebtn, volumeslider;
var countforQuiz1= 0;  var countforQuiz2 =0;

function intializePlayer(){
	// Set object references
	vid = document.getElementById("my_video");
	playbtn = document.getElementById("playpausebtn");
	seekslider = document.getElementById("seekslider");
	curtimetext = document.getElementById("curtimetext");
	durtimetext = document.getElementById("durtimetext");
	mutebtn = document.getElementById("mutebtn");
	volumeslider = document.getElementById("volumeslider");
	// Add event listeners
	playbtn.addEventListener("click",playPause,false);
	seekslider.addEventListener("change",vidSeek,false);
	vid.addEventListener("timeupdate",seektimeupdate,false);
	mutebtn.addEventListener("click",vidmute,false);
	volumeslider.addEventListener("change",setvolume,false);
}
window.onload = intializePlayer;
function playPause(){
	if(vid.paused){
		vid.play();
		playbtn.innerHTML = "Pause";
	} else {
		vid.pause();
		playbtn.innerHTML = "Play";
	}
}
function vidSeek(){
	var seekto = vid.duration * (seekslider.value / 100);
	vid.currentTime = seekto;
}
function seektimeupdate(){
	var nt = vid.currentTime * (100 / vid.duration);
	seekslider.value = nt;
	var curmins = Math.floor(vid.currentTime / 60);
	var cursecs = Math.floor(vid.currentTime - curmins * 60);
	var durmins = Math.floor(vid.duration / 60);
	var dursecs = Math.floor(vid.duration - durmins * 60);
	if(cursecs < 10){ cursecs = "0"+cursecs; }
	if(dursecs < 10){ dursecs = "0"+dursecs; }
	if(curmins < 10){ curmins = "0"+curmins; }
	if(durmins < 10){ durmins = "0"+durmins; }
	curtimetext.innerHTML = curmins+":"+cursecs;
	durtimetext.innerHTML = durmins+":"+dursecs;
	if(vid.currentTime >=<%=halfTime%> && vid.currentTime<=<%=halfTime+1%> && countforQuiz1===0){
                               vid.pause();
  	         window.open("quizPage_1.jsp");
                              countforQuiz1=1;
                       }
                       if(vid.currentTime === vid.duration && countforQuiz2===0){
                               vid.pause();
  	         window.open("quizPage_2.jsp");
                              countforQuiz2=1;
                       }
}
function vidmute(){
	if(vid.muted){
		vid.muted = false;
		mutebtn.innerHTML = "Mute";
	} else {
		vid.muted = true;
		mutebtn.innerHTML = "Unmute";
	}
}
function setvolume(){
	vid.volume = volumeslider.value / 100;
}
  
</script>
</head>


<body>
    <div class="wrapper">
        <div class="sidebar">
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="lectureCards.jsp" class="simple-text">
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
                                <div class="card-header ">
                                    <h4 class="card-title"> LECTURE - 02 </h4>
                                </div>
                                <div class="card-body">
                                    <h3><center><%=topic%></center></h3><br>
                                    <div id="video_player_box">
                                      <video id="my_video" width="550" height="310" autoplay>
                                        <source src="<%=src%>">
                                      </video>
                                      <div id="video_controls_bar">
                                        <button class="btn-v" id="playpausebtn"><i class="fa fa-pause"></i></button>
                                        <input id="seekslider" type="range" min="0" max="100" value="0" step="1">
                                        <span id="curtimetext">00:00</span> / <span id="durtimetext">00:00 </span>
                                        <button class="btn-v" id="mutebtn"><i class="fa fa-volume-up"></i></button>
                                        <input id="volumeslider" type="range" min="0" max="100" value="100" step="1">
                                      </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</body>



<!--body>
<div id="video_player_box">
  <video id="my_video" width="550" height="310" autoplay>
    <source src="<%=src%>">
  </video>
  <div id="video_controls_bar">
    <button id="playpausebtn">Pause</button>
    <input id="seekslider" type="range" min="0" max="100" value="0" step="1">
    <span id="curtimetext">00:00</span> / <span id="durtimetext">00:00</span>
    <button id="mutebtn">Mute</button>
    <input id="volumeslider" type="range" min="0" max="100" value="100" step="1">
  </div>
</div>
<%  System.out.println("************ Ending of Video Page 2 ******************"); %>
</body-->
</html>
