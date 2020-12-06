//***********************************************FOR THE LECTURE 3********************************************************************************************************

var countforQuiz1_3= 0;
var countforQuiz2_3 =0;
var vid_3, playbtn_3, seekslider_3, curtimetext_3, durtimetext_3, mutebtn_3, volumeslider_3;
function intializePlayer_3(){
	// Set object references
                console.log("inside initialize player");
	vid_3 = document.getElementById("my_video_3");
	playbtn_3 = document.getElementById("playpausebtn_3");
	seekslider_3 = document.getElementById("seekslider_3");
	curtimetext_3 = document.getElementById("curtimetext_3");
	durtimetext_3 = document.getElementById("durtimetext_3");
	mutebtn_3 = document.getElementById("mutebtn_3");
	volumeslider_3 = document.getElementById("volumeslider_3");
	// Add event listeners
	playbtn_3.addEventListener("click",playPause_3,false);
	seekslider_3.addEventListener("change",vidSeek_3,false);
	vid_3.addEventListener("timeupdate",seektimeupdate_3,false);
	mutebtn_3.addEventListener("click",vidmute_3,false);
	volumeslider_3.addEventListener("change",setvolume_3,false);
}
window.onload = intializePlayer_3;
function playPause_3(){
	if(vid_3.paused){
		vid_3.play();
		playbtn_3.innerHTML = "Pause";
	} else {
		vid_3.pause();
		playbtn_3.innerHTML = "Play";
	}
}
function vidSeek_3(){
                console.log(".....inside vid seek 1.....");
	var seekto_3 = vid_3.duration * (seekslider_3.value / 100);
	vid_3.currentTime = seekto_3;
}
function seektimeupdate_3(){
                console.log(".....inside seek time update....:)");
	var nt_3 = vid_3.currentTime * (100 / vid_3.duration);
	seekslider_3.value = nt_3;
	var curmins_3 = Math.floor(vid_3.currentTime / 60);
	var cursecs_3 = Math.floor(vid_3.currentTime - curmins_3 * 60);
	var durmins_3 = Math.floor(vid_3.duration / 60);
	var dursecs_3 = Math.floor(vid_3.duration - durmins_3 * 60);
	if(cursecs_3 < 10){ cursecs_3 = "0"+cursecs_3; }
	if(dursecs_3 < 10){ dursecs_3 = "0"+dursecs_3; }
	if(curmins_3 < 10){ curmins_3 = "0"+curmins_3; }
	if(durmins_3 < 10){ durmins_3 = "0"+durmins_3; }
	curtimetext_3.innerHTML = curmins_3+":"+cursecs_3;
	durtimetext_3.innerHTML = durmins_3+":"+dursecs_3;
	if(vid_3.currentTime >=242 && vid_3.currentTime<=243 && countforQuiz1_3===0){
                    console.log(".......inside if ready to redirect to the short quiz......");
                         vid_3.pause();
  	         window.open("quizPage_1.jsp");
                         countforQuiz1_3=1;
                 }
                if(vid_3.currentTime === vid_3.duration && countforQuiz2_3===0){
                    console.log(".......inside if ready to redirect to the long quiz......");
                         vid_3.pause();
  	         window.open("quizPage_2.jsp");
                         countforQuiz2_3=1;
                 }
}
function vidmute_3(){
	if(vid_3.muted){
		vid_3.muted = false;
		mutebtn_3.innerHTML = "Mute";
	} else {
		vid_3.muted = true;
		mutebtn_3.innerHTML = "Unmute";
	}
}
function setvolume_3(){
	vid_3.volume = volumeslider_3.value / 100;
}