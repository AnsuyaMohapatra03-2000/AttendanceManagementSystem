//***********************************************FOR THE LECTURE 1********************************************************************************************************

var countforQuiz1_1= 0;
var countforQuiz2_1 =0;
var vid_1, playbtn_1, seekslider_1, curtimetext_1, durtimetext_1, mutebtn_1, volumeslider_1;
function intializePlayer_1(){
	// Set object references
                console.log("inside initialize player");
	vid_1 = document.getElementById("my_video_1");
	playbtn_1 = document.getElementById("playpausebtn_1");
	seekslider_1 = document.getElementById("seekslider_1");
	curtimetext_1 = document.getElementById("curtimetext_1");
	durtimetext_1 = document.getElementById("durtimetext_1");
	mutebtn_1 = document.getElementById("mutebtn_1");
	volumeslider_1 = document.getElementById("volumeslider_1");
	// Add event listeners
	playbtn_1.addEventListener("click",playPause_1,false);
	seekslider_1.addEventListener("change",vidSeek_1,false);
	vid_1.addEventListener("timeupdate",seektimeupdate_1,false);
	mutebtn_1.addEventListener("click",vidmute_1,false);
	volumeslider_1.addEventListener("change",setvolume_1,false);
}
window.onload = intializePlayer_1;
function playPause_1(){
	if(vid_1.paused){
		vid_1.play();
		playbtn_1.innerHTML = "Pause";
	} else {
		vid_1.pause();
		playbtn_1.innerHTML = "Play";
	}
}
function vidSeek_1(){
	var seekto_1 = vid_1.duration * (seekslider_1.value / 100);
	vid_1.currentTime = seekto_1;
}
function seektimeupdate_1(){
	var nt_1 = vid_1.currentTime * (100 / vid_1.duration);
	seekslider_1.value = nt_1;
	var curmins_1 = Math.floor(vid_1.currentTime / 60);
	var cursecs_1 = Math.floor(vid_1.currentTime - curmins_1 * 60);
	var durmins_1 = Math.floor(vid_1.duration / 60);
	var dursecs_1 = Math.floor(vid_1.duration - durmins_1 * 60);
	if(cursecs_1 < 10){ cursecs_1 = "0"+cursecs_1; }
	if(dursecs_1 < 10){ dursecs_1 = "0"+dursecs_1; }
	if(curmins_1 < 10){ curmins_1 = "0"+curmins_1; }
	if(durmins_1 < 10){ durmins_1 = "0"+durmins_1; }
	curtimetext_1.innerHTML = curmins_1+":"+cursecs_1;
	durtimetext_1.innerHTML = durmins_1+":"+dursecs_1;
	if(vid_1.currentTime >=242 && vid_1.currentTime<=243 && countforQuiz1_1===0){
                         redirect("quizPage_1.jsp",1);
                 }
                if(vid_1.currentTime === vid_1.duration && countforQuiz2_1===0){
                         redirect("quizPage_2.jsp", 2);
                 }
}
function vidmute_1(){
	if(vid_1.muted){
		vid_1.muted = false;
		mutebtn_1.innerHTML = "Mute";
	} else {
		vid_1.muted = true;
		mutebtn_1.innerHTML = "Unmute";
	}
}
function setvolume_1(){
	vid_1.volume = volumeslider_1.value / 100;
}
function redirect(pageName , pageNo){   
                    vid_1.pause();
  	    window.open(pageName);
                   if(pageNo === 1){
                         countforQuiz1_1=1;
                     }
                     else{
                          countforQuiz2_1=1;
                     }   
}