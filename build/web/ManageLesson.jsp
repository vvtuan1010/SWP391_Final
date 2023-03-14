
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <h1 style="text-align: center; color: red">Manage Lesson</h1>
            <a style=" margin-left: 150px"   href="CreateLesson.jsp">Create lesson</a>               
              <a style="margin-left: 1000px;margin-bottom: 50px" href="Home.jsp"> Home</a>             
            <table style="width:80%;height:80px;margin-left:150px; margin-top: 50px" border="1px solid black">
                <tr>
                    <th>LessonID</th>
                    <th>LessonName</th>
                    <th>LessonDescription</th>
                    <th>CourseID</th>
                </tr>
            <c:forEach items="${listL}" var="l">
                <tr>
                    <td>${l.lessonID}</td>
                    <td>${l.lessonName}</td>
                    <td>${l.lessonDescription}</td>
                    <td>${l.courseID}</td>
                    <td>
                        <button type="button" href="#" onclick="updateConfirm(${l.lessonID})">Update</button>
                        <button type="button" href="#" onclick="showMess(${l.lessonID})">Delete </button>
<!--                        <a href="updatelesson?sid=${l.lessonID}">Update</a>
                        <a href="#" onclick="showMess(${l.lessonID})">delete </a>-->
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
    <script>
        function showMess(lessonID){
            var option = confirm('Are you sure to delete lessonID '+ lessonID);
            if(option === true ){
                window.location.href = 'deletelesson?sid='+lessonID;
            }
        }
        
        function updateConfirm(lessonID){
            var option = confirm ('Are you sure to update lessonID ' + lessonID);
            if(option === true ){
                window.location.href = 'updatelesson?sid='+lessonID;
            }
        }
    </script>

        
</html>
