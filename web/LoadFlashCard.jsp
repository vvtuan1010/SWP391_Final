<%-- 
    Document   : LoadFlashCard
    Created on : Mar 14, 2023, 6:35:09 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Flashcard</title>
	<style>
		.card {
			background-color: white;
			border: 1px solid black;
			padding: 10px;
			margin-bottom: 10px;
		}

		.question {
			font-weight: bold;
			margin-bottom: 5px;
		}

		.answer {
			display: none;
			margin-top: 5px;
		}

		.card.show-answer .answer {
			display: block;
		}
	</style>
</head>
<body>
	<h1>Flashcard</h1>
	
	
		
		
        <c:forEach  items="${listP}" var="x">
			<div class="card">
				<div class="question">${x.flash_question}</div>
				<div class="answer">${x.flash_answer}</div>
				<button onclick="toggleAnswer(this)">Show Answer</button>
			</div>
	
		</c:forEach>


	<script>
		function toggleAnswer(button) {
			button.parentNode.classList.toggle('show-answer');
			if (button.innerText === 'Show Answer') {
				button.innerText = 'Hide Answer';
			} else {
				button.innerText = 'Show Answer';
			}
		}
	</script>
</body>
</html>





