<%@page import="java.util.ArrayList"%>
<%@page import="com.Student.DbConnection"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Quiz App</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css2?family=Kumbh+Sans&display=swap" rel="stylesheet">          
        <link href="assets/css/longquiz/style.css" rel="stylesheet" type="text/css"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> 
        <script>
                 $(document).ready(function(){
                     $('#nextBtn').click(function(event){
                       var ca = $('#total-correct').text();
                       if(ca!=null){
                         var toSend = ca;
                         console.log(ca);
                         $.get('SecondQuizServlet',{givenAns:toSend},function(responseText){
                         });
                       }
                   });
                 });               
</script>
</head>
 <%! 
       ArrayList<String> list1 = new ArrayList<String>();
       ArrayList<String> list2 = new ArrayList<String>();
       ArrayList<String> list3 = new ArrayList<String>();   
       int correctAns;
 %>
  <%
               list1.clear();
               list2.clear();
               list3.clear();
               System.out.println("");
               System.out.println("Before the operation the size is :");
               System.out.println("Size of 1st list : "+list1.size());
               System.out.println("Size of 2nd list : "+list2.size());
               System.out.println("Size of 3rd list : "+list3.size());
               System.out.println("");
               String subClicked = (String) session.getAttribute("subClicked");
               System.out.println("I am inside Long quiz page i m watching lectures of :" +subClicked);
               Connection con = new DbConnection().getConnection();
               Statement st;
               
               st = con.createStatement();
               System.out.println("-----------Writing the query for fetching data for the quiz-------------------");
               String selectQ = "select * from LongQuiz" ;
               
               ResultSet rs = st.executeQuery(selectQ);
               if(rs == null){
                   System.out.println("The resultSet of Long Quiz is null!!!");
               }  
               int c = 0;
               while(rs.next()){
                   String qid = rs.getString(1);
                   if(qid.substring(0,3).equalsIgnoreCase("IWT")){
                                   String subLec = qid.substring(0,3) + qid.substring(7,8);     
                                   if(subLec.equalsIgnoreCase(subClicked)){    
                                     System.out.println("It is IWT Lecture : "+rs.getString(2)+ rs.getString(3)+ rs.getString(4)+ rs.getString(5) + rs.getString(6));
                                      list1.add(rs.getString(2));
                                      list1.add(rs.getString(3));
                                      list1.add(rs.getString(4));
                                      list1.add(rs.getString(5));
                                      list1.add(rs.getString(6));
                                      if(rs.getString(7).equalsIgnoreCase("a"))
                                             list1.add("0");
                                      else if(rs.getString(7).equalsIgnoreCase("b"))
                                             list1.add("1");
                                      else if(rs.getString(7).equalsIgnoreCase("c"))
                                             list1.add("2");
                                       else if(rs.getString(7).equalsIgnoreCase("d"))
                                             list1.add("3");
                                   }      
                   } else if(qid.substring(0,4).equalsIgnoreCase("DCCN")){
                                  String sub = qid.substring(0,4);
                                   String lecNo = qid.substring(8,9);
                                   String subLec = sub+lecNo;
                                    System.out.println("It is DCCN Lecture : "+subLec);
                                   System.out.println("Subject Clicked :"+subClicked);
                                   if(subLec.equalsIgnoreCase(subClicked)){    
                                      list2.add(rs.getString(2));
                                      list2.add(rs.getString(3));
                                      list2.add(rs.getString(4));
                                      list2.add(rs.getString(5));
                                      list2.add(rs.getString(6));
                                      if(rs.getString(7).equalsIgnoreCase("a"))
                                             list2.add("0");
                                      else if(rs.getString(7).equalsIgnoreCase("b"))
                                             list2.add("1");
                                      else if(rs.getString(7).equalsIgnoreCase("c"))
                                             list2.add("2");
                                       else if(rs.getString(7).equalsIgnoreCase("d"))
                                             list2.add("3");
                                   }
                   }
                   else if(qid.substring(0,2).equalsIgnoreCase("OS")){
//                                  subject = "OS";
                                  String sub = qid.substring(0,2);
                                   String lecNo = qid.substring(6,7);
                                   String subLec = sub+lecNo;
                                  System.out.println("It is IWT Lecture : "+subLec);
                                   System.out.println("Subject Clicked :"+subClicked);
                                   if(subLec.equalsIgnoreCase(subClicked)){    
                                      list3.add(rs.getString(2));
                                      list3.add(rs.getString(3));
                                      list3.add(rs.getString(4));
                                      list3.add(rs.getString(5));
                                      list3.add(rs.getString(6));
                                      if(rs.getString(7).equalsIgnoreCase("a"))
                                             list3.add("0");
                                      else if(rs.getString(7).equalsIgnoreCase("b"))
                                             list3.add("1");
                                      else if(rs.getString(7).equalsIgnoreCase("c"))
                                             list3.add("2");
                                       else if(rs.getString(7).equalsIgnoreCase("d"))
                                             list3.add("3");
                                   }
                   }
               }   //end of while loop
                   
  %>
<body>
     <div class= "home-box custom-box">
     <h3>INSTRUCTIONS</h3>
     <p>Total Number Of Questions: <span class="total-question"></span></p>
    <button type="button" class="btn" onclick="startQuiz()">Start Quiz</button>
    </div>

   <div class="quiz-box custom-box hide">
		<div class="question-number">
			
		</div>
		<div class="question-text">
			
		</div>
		<div class="option-container">
			
		</div>
		<div class="next-question-btn">
			<button type="button" id="nextBtn" class="btn" onclick="next()">Next</button>
		</div>
		<div class="answers-indicator">
			
		</div>
	</div>
	<div class="result-box custom-box hide">
		<h1>Quiz Result</h1>
		<table>
			<tr>
				<td>Total Questions</td>
				<td><span name="total-question" class="total-question"></span></td>
			</tr>
			<tr>
				<td>Attempt</td>
				<td><span name="total-attempt" class="total-attempt"></span></td>
			</tr>
			<tr>
				<td>Correct</td>
				<td><span class="total-correct"></span></td>
<!--                                                 <input id="correct-answer" type="text">-->
			</tr>
			<tr>
				<td>Wrong</td>
				<td><span name="total-wrong" class="total-wrong"></span></td>
			</tr>
			<tr>
				<td>Percentage</td>
				<td><span name="percentage" class="percentage"></span></td>
			</tr>
			<tr>
				<td>Total Score</td>
				<td><span id="total-correct" name="total-score" class="total-score"></span></td>
			</tr>
		</table>
	</div>
   <%
          System.out.println("After the operation the sizes of the list ::: ");
          System.out.println("Size of 1st list : "+list1.size());
          System.out.println("Size of 2nd list : "+list2.size());
          System.out.println("Size of 3rd list : "+list3.size());
         if(list1.size()!=0){      
   %>
    <script>
    const quiz = [
      {
	q:'<%=list1.get(0)%>',
	options:['<%=list1.get(1)%>', '<%=list1.get(2)%>', '<%=list1.get(3)%>', '<%=list1.get(4)%>'],
	answer: <%=Integer.parseInt(list1.get(5))%>
      },
     {
	q:'<%=list1.get(6)%>',
	options:['<%=list1.get(7)%>', '<%=list1.get(8)%>', '<%=list1.get(9)%>', '<%=list1.get(10)%>'],
	answer: <%=Integer.parseInt(list1.get(11))%>
      },
     {
	q:'<%=list1.get(12)%>',
	options:['<%=list1.get(13)%>', '<%=list1.get(14)%>', '<%=list1.get(15)%>', '<%=list1.get(16)%>'],
	answer: <%=Integer.parseInt(list1.get(17))%>
      }
    ]
    </script>
<% } else if(list2.size()!=0){       %>
    <script>
    const quiz = [
      {
	q:'<%=list2.get(0)%>',
	options:['<%=list2.get(1)%>', '<%=list2.get(2)%>', '<%=list2.get(3)%>', '<%=list2.get(4)%>'],
	answer: <%=Integer.parseInt(list2.get(5))%>
      },
     {
	q:'<%=list2.get(6)%>',
	options:['<%=list2.get(7)%>', '<%=list2.get(8)%>', '<%=list2.get(9)%>', '<%=list2.get(10)%>'],
	answer: <%=Integer.parseInt(list2.get(11))%>
      },
     {
	q:'<%=list2.get(12)%>',
	options:['<%=list2.get(13)%>', '<%=list2.get(14)%>', '<%=list2.get(15)%>', '<%=list2.get(16)%>'],
	answer: <%=Integer.parseInt(list2.get(17))%>
      }
    ]
    </script>
 <% } 
      else  if(list3.size()!=0){      
  %>
    <script>
    const quiz = [
      {
	q:'<%=list3.get(0)%>',
	options:['<%=list3.get(1)%>', '<%=list3.get(2)%>', '<%=list3.get(3)%>', '<%=list3.get(4)%>'],
	answer: <%=Integer.parseInt(list3.get(5))%>
      },
     {
	q:'<%=list3.get(6)%>',
	options:['<%=list3.get(7)%>', '<%=list3.get(8)%>', '<%=list3.get(9)%>', '<%=list3.get(10)%>'],
	answer: <%=Integer.parseInt(list3.get(11))%>
      },
     {
	q:'<%=list3.get(12)%>',
	options:['<%=list3.get(13)%>', '<%=list3.get(14)%>', '<%=list3.get(15)%>', '<%=list3.get(16)%>'],
	answer: <%=Integer.parseInt(list3.get(17))%>
      }
    ]
    </script>
    <% } %>
    
<script>
const questionNumber = document.querySelector(".question-number");
const questionText = document.querySelector(".question-text");
const optionContainer = document.querySelector(".option-container");
const answersIndicatorContainer = document.querySelector(".answers-indicator");
const homeBox = document.querySelector(".home-box");
const quizBox = document.querySelector(".quiz-box");
const resultBox = document.querySelector(".result-box");

let questionCounter = 0;
let currentQuestion;
let availableQuestions = [];
let availableOptions = [];
let correctAnswers = 0;
let attempt = 0;

function setAvailableQuestions(){
	const totalQuestion = quiz.length;
	for (let i = 0; i < totalQuestion; i++) {
		availableQuestions.push(quiz[i])
	}
}

function getNewQuestion(){
	questionNumber.innerHTML = "Question " + (questionCounter + 1) + " of " + quiz.length;

	const questionIndex = availableQuestions[Math.floor(Math.random() * availableQuestions.length)];
	currentQuestion = questionIndex;
	questionText.innerHTML = currentQuestion.q;

	const index1 = availableQuestions.indexOf(questionIndex);
	availableQuestions.splice(index1, 1);

	const optionLen = currentQuestion.options.length;

	optionContainer.innerHTML = '';
	let animationDelay = 0.2;

	for(let i=0; i<optionLen; i++){
		availableOptions.push(i)
	}

	for(let i=0; i<optionLen; i++){
		const optonIndex =  availableOptions[Math.floor(Math.random() * availableOptions.length)];

		const index2 = availableOptions.indexOf(optonIndex);
		availableOptions.splice(index2, 1);

		const option = document.createElement("div");
		option.innerHTML = currentQuestion.options[optonIndex];
		option.id = optonIndex;
		option.style.animationDelay = animationDelay + 's';
		animationDelay = animationDelay + 0.2;
		option.className = "option";
		optionContainer.appendChild(option);
		option.setAttribute("onclick", "getResult(this)");
	}

	questionCounter++
}

function getResult(element){
	const id = parseInt(element.id);
	if(id === currentQuestion.answer){
		element.classList.add("correct");
		updateAnswerIndicator("correct");

		correctAnswers++;
	}
	else{
		element.classList.add("wrong");
		updateAnswerIndicator("wrong");

		const optionLen = optionContainer.children.length;
		for(let i=0; i<optionLen; i++){
			if(parseInt(optionContainer.children[i].id) === currentQuestion.answer){
				optionContainer.children[i].classList.add("correct");
			}
		}
	}
	attempt++
	unclickableOptions();
}

function unclickableOptions(){
	const optionLen = optionContainer.children.length;
	for(let i=0; i<optionContainer; i++){
		optionContainer.children[i].classList.add("already-answered");
	}
}

function answersIndicator(){
	answersIndicatorContainer.innerHTML = '';
	const totalQuestion = quiz.length;
	for(let i=0; i<totalQuestion; i++){
		const indicator = document.createElement("div");
		answersIndicatorContainer.appendChild(indicator);
	}
}

function updateAnswerIndicator(markType){
	answersIndicatorContainer.children[questionCounter-1].classList.add(markType)
  }

function next(){
	if(questionCounter === quiz.length){
		quizOver();
	}
	else{
		getNewQuestion();
	}
}

function quizOver(){
	quizBox.classList.add("hide");
	resultBox.classList.remove("hide");
	quizResult();
}

function quizResult(){
	resultBox.querySelector(".total-question").innerHTML = quiz.length;
	resultBox.querySelector(".total-attempt").innerHTML = attempt;
	resultBox.querySelector(".total-correct").innerHTML = correctAnswers;
                resultBox.querySelector(".total-wrong").innerHTML = attempt - correctAnswers;
	const percentage = (correctAnswers/quiz.length)*100;
	resultBox.querySelector(".percentage").innerHTML = percentage.toFixed(2) + "%";
	resultBox.querySelector(".total-score").innerHTML = correctAnswers + " / " + quiz.length;
}

function startQuiz(){

	homeBox.classList.add("hide");
	quizBox.classList.remove("hide");

	setAvailableQuestions();
	getNewQuestion();
	answersIndicator();
}

window.onload = function(){
	homeBox.querySelector(".total-question").innerHTML = quiz.length;
}
</script>

</body>
</html>