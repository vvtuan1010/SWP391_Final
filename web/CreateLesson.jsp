

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="createlesson" method="post">
            <table>
                <tr>
                    <td>LessonID</td>
                    <td>
                        <input type="text" name="lessonID">
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>
                        <input type="text" name="description">
                    </td>
                </tr>
                <tr>
                    <td>courseID</td>
                    <td><input type="text" name="courseID"</td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Add Lesson</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
