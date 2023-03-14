
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="updatelesson" method="post">
            <table>
                <tr>
                    <td>LessonID</td>
                    <td>
                        <input value="${ul.lessonID}" type="text" name="lessonID" readonly>
                    </td>
                </tr>
                 <tr>
                    <td>Name</td>
                    <td>
                        <input value="${ul.lessonName}"type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>
                        <input value="${ul.lessonDescription}"type="text" name="description">
                    </td>
                </tr>
                <tr>
                    <td>courseID</td>
                    <td><input value="${ul.courseID}" type="text" name="courseID"</td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Update Lesson</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
