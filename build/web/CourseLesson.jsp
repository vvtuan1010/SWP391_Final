<%-- 
    Document   : CourseLesson
    Created on : Mar 8, 2023, 9:03:48 AM
    Author     : ACER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="lesson.css">
        <title>JSP Page</title>
    </head>
     
    <body>
        <div class="leesontile"
        <h1>${c.getCourse_name()} Lesson</h1>
        </div>
            <table style="width:50%;height:80px" class="lessontable" border="1px solid black">
                <tr>
                    <th>LessonName</th>
                    <th>LessonDescription</th>
                    <th></th>
                </tr>
            <c:forEach items="${listL}" var="l">
                <c:if test="${l.getCourseID()==c.getCourse_id()}">
                <tr>
                    <td>${l.lessonName}</td>
                    <td>${l.lessonDescription}</td>            
                    <td>                     
                        <button type="button" href="#" onclick="learnConfirm(${l.lessonName})">Learn</button>
                    </td>
                </tr>
                </c:if>
            </c:forEach>
        </table>
    </body>
        <script>        
        function learnConfirm(lessonName){
            var option = confirm ('Are you sure to learn lesson  ' + lessonName);
            if(option === true ){
                window.location.href = 'updatelesson?sid='+lessonName;
            }
        }
    </script>

</html>
