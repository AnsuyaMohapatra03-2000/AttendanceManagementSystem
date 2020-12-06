
//***********************************************  FOR THE LECTURE 2  ********************************************************************************************************

var countforQuiz1_2= 0;
var countforQuiz2_2 =0;
var vid_2, playbtn_2, seekslider_2, curtimetext_2, durtimetext_2, mutebtn_2, volumeslider_2;
function intializePlayer_2(){
	// Set object references
                console.log("inside initialize player");
	vid_2 = document.getElementById("my_video_2");
	playbtn_2 = document.getElementById("playpausebtn_2");
	seekslider_2 = document.getElementById("seekslider_2");
	curtimetext_2 = document.getElementById("curtimetext_2");
	durtimetext_2 = document.getElementById("durtimetext_2");
	mutebtn_2 = document.getElementById("mutebtn_2");
	volumeslider_2 = document.getElementById("volumeslider_2");
	// Add event listeners
	playbtn_2.addEventListener("click",playPause_2,false);
	seekslider_2.addEventListener("change",vidSeek_2,false);
	vid_2.addEventListener("timeupdate",seektimeupdate_2,false);
	mutebtn_2.addEventListener("click",vidmute_2,false);
	volumeslider_2.addEventListener("change",setvolume_2,false);
}
window.onload = intializePlayer_2;
function playPause_2(){
	if(vid_2.paused){
		vid_2.play();
		playbtn_2.innerHTML = "Pause";
	} else {
		vid_2.pause();
		playbtn_2.innerHTML = "Play";
	}
}
function vidSeek_2(){
                console.log(".....inside vid seek 2.....");
	var seekto_2 = vid_2.duration * (seekslider_2.value / 100);
	vid_2.currentTime = seekto_2;
}
function seektimeupdate_2(){
                console.log(".....inside seek time update....:)");
	var nt_2 = vid_2.currentTime * (100 / vid_2.duration);
	seekslider_2.value = nt_2;
	var curmins_2 = Math.floor(vid_2.currentTime / 60);
	var cursecs_2 = Math.floor(vid_2.currentTime - curmins_2 * 60);
	var durmins_2 = Math.floor(vid_2.duration / 60);
	var dursecs_2 = Math.floor(vid_2.duration - durmins_2 * 60);
	if(cursecs_2 < 10){ cursecs_2 = "0"+cursecs_2; }
	if(dursecs_2 < 10){ dursecs_2 = "0"+dursecs_2; }
	if(curmins_2 < 10){ curmins_2 = "0"+curmins_2; }
	if(durmins_2 < 10){ durmins_2 = "0"+durmins_2; }
	curtimetext_2.innerHTML = curmins_2+":"+cursecs_2;
	durtimetext_2.innerHTML = durmins_2+":"+dursecs_2;
	if(vid_2.currentTime >=242 && vid_2.currentTime<=243 && countforQuiz1_2===0){
                         console.log(".......inside if ready to redirect to the short quiz......");
                         vid_2.pause();
  	         window.open("http://localhost:8080/Attendance_Student/quizPage_1.jsp");
                         countforQuiz1_2=1;
                 }
                if(vid_2.currentTime === vid_2.duration && countforQuiz2_2===0){
                    console.log(".......inside if ready to redirect to the long quiz......");
                         vid_2.pause();
  	         window.open("http://localhost:8080/Attendance_Student/quizPage_1.jsp");
                         countforQuiz2_2=1;
                 }
}
function vidmute_2(){
	if(vid_2.muted){
		vid_2.muted = false;
		mutebtn_2.innerHTML = "Mute";
	} else {
		vid_2.muted = true;
		mutebtn_2.innerHTML = "Unmute";
	}
}
function setvolume_2(){
	vid_2.volume = volumeslider_2.value / 100;
}

