<%@page import="com.Student.*"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>Short Quiz</title>
    <link href="assets/css/home/style_short_quiz.css" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css2?family=Kumbh+Sans&display=swap" rel="stylesheet">
         <script src="js/jquery-1.9.1.min.js"></script>       
          <%! String SQ,SA; %>
          <%
//               session = request.getSession();
               String subClicked = (String) session.getAttribute("subClicked");
               System.out.println("I am inside short quiz page i m watching lectures of :" +subClicked);
               String videoNo = (String) session.getAttribute("videoNo");
                         
               Connection con = new DbConnection().getConnection();
               Statement st;
               
               st = con.createStatement();
               System.out.println("-----------Writing the query for fetching data for the quiz-------------------");
               String selectQ = "select * from ShortQuiz" ;
               
               ResultSet rs = st.executeQuery(selectQ);
               if(rs == null){
                   System.out.println("The resultSet is null!!!");
               }          
               while(rs.next()){
                   String qid = rs.getString(1);
                   if(qid.substring(0,3).equalsIgnoreCase("IWT")){
                                   String sub = qid.substring(0,3);
                                   String lecNo = qid.substring(7,8);
                                   String subLec = sub+lecNo;
                                   System.out.println(subLec);
                                   if(subLec.equalsIgnoreCase(subClicked)){    
                                       SQ = rs.getString(2);
                                       SA = rs.getString(3);
                                   }
                   }else if(qid.substring(0,4).equalsIgnoreCase("DCCN")){
                                  String sub = qid.substring(0,4);
                                   String lecNo = qid.substring(8,9);
                                   String subLec = sub+lecNo;
                                   System.out.println(subLec);
                                   if(subLec.equalsIgnoreCase(subClicked)){    
                                       SQ = rs.getString(2);
                                       SA = rs.getString(3);
                                   }
                   }
                   else if(qid.substring(0,2).equalsIgnoreCase("OS")){
                                  String sub = qid.substring(0,2);
                                   String lecNo = qid.substring(6,7);
                                   String subLec = sub+lecNo;
                                   System.out.println(subLec);
                                   if(subLec.equalsIgnoreCase(subClicked)){    
                                       SQ = rs.getString(2);
                                       SA = rs.getString(3);
                                   }
                   }
               }
               
               if(SA.equalsIgnoreCase("T"))
                    SA = "A";
               else
                   SA = "B";
    %>
    <script>
                 $(document).ready(function(){
                     $('#A').click(function(event){
                         var toSend = "A";
                         if(toSend === "<%=SA%>")
                             toSend = "correct";
                         else
                             toSend = "wrong";
                         $.get('FirstQuizServlet',{givenAns:toSend},function(responseText){
                         });
                     });       
                      $('#B').click(function(event){
                         var toSend = "B";
                          if(toSend === "<%=SA%>")
                             toSend = "correct";
                         else
                             toSend = "wrong";
                         $.get('FirstQuizServlet',{givenAns:toSend},function(responseText){
                         });
                     });         
                 });
</script>
</head>
<body>
   
    <div class="container">
        <div id="start">Start!!</div>
        <div id="quiz" style="display: none">
            <div id="question"></div>
            <div id="choices">
                <div class="choice" id="A" onclick="checkAnswer('A')"></div>
                <div class="choice" id="B" onclick="checkAnswer('B')"></div>
            </div>
            <div id="timer">
                <div id="counter"></div>
                <div id="btimeGauge"></div>
                <div id="timeGauge"></div>
            </div>
            <div id="progress"></div>
        </div>
        <div id="scoreContainer" style="display: none"></div>
    </div>
    <script>
			const start = document.getElementById("start");
			const quiz = document.getElementById("quiz");
			const question = document.getElementById("question");
			const choiceA = document.getElementById("A");
			const choiceB = document.getElementById("B");
			const counter = document.getElementById("counter");
			const timeGauge = document.getElementById("timeGauge");
			const progress = document.getElementById("progress");
			const scoreDiv = document.getElementById("scoreContainer");

			let questions = [
			    {
			        question : "<%=SQ%>",
			        choiceA : "True",
			        choiceB : "False",
			        correct : "<%=SA%>"
			    }
			];

			const lastQuestion = questions.length - 1;
			let runningQuestion = 0;
			let count = 0;
			const questionTime = 5; // 5s
			const gaugeWidth = 150; // 150px
			const gaugeUnit = gaugeWidth / questionTime;
			let TIMER;
			let score = 0;

			function renderQuestion(){
			    let q = questions[runningQuestion];
			    
			    question.innerHTML = "<p>"+ q.question +"</p>";
			    choiceA.innerHTML = q.choiceA;
			    choiceB.innerHTML = q.choiceB;
			}

			start.addEventListener("click",startQuiz);

			function startQuiz(){
			    start.style.display = "none";
			    renderQuestion();
			    quiz.style.display = "block";
			    renderProgress();
			    renderCounter();
			    TIMER = setInterval(renderCounter,1000);
			}

			function renderProgress(){
			    progress.innerHTML += "<div class='prog' id="+ 0 +"></div>";
			}

			function renderCounter(){
			    if(count <= questionTime){
			        counter.innerHTML = count;
			        timeGauge.style.width = count * gaugeUnit + "px";
			        count++
			    }else{
			        count = 0;
			        clearInterval(TIMER);
			        scoreRender();
			    }
			}

			function checkAnswer(answer){
			    if( answer == questions[0].correct){
			        score++;
			    }
			    clearInterval(TIMER);
			    scoreRender();
			}

			function scoreRender(){
			    scoreDiv.style.display = "block";
			    const scorePerCent = (100 * score);

			    scoreDiv.innerHTML += "<p>"+ scorePerCent +"%</p>";
			}
    </script>
    </body>
</html>
