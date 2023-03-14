<%-- 
    Document   : update
    Created on : Feb 26, 2023, 8:01:36 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" media="all" href="CSS/style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update FlashCard </h1>
        </br>
        <div class="row">
            <div class="col-sm-8">
                <form  method="POST" action="update">
                    <div alight="left">
                        <label class="from-label">FlashCardID</label>
                        
                        <input value="${st.flash_id}" type="text" class="form-control" placeholder="FlashCardID" name="fname" id="fname" required>
                    </div>
                    <div alight="left">
                        <label class="from-label">FlashCard Question</label>
                        <input value="${st.flash_question}" type="text" class="form-control" placeholder="FlashCard Question" name="fquest" id="fquest" required>
                    </div>
                    <div alight="left">
                        <label class="from-label">FlashCard Answer</label>
                        <input value="${st.flash_answer}" type="text" class="form-control" placeholder="FlashCard Answer" name="fansw" id="fansw" required>
                    </div>
                    <div alight="left">
                        <label class="from-label">LessonID</label>
                        <input value="${st.lesson_id}" type="text" class="form-control" placeholder="LessonID" name="lid" id="lid" required>
                    </div>
                    </br>
                    <div alight="right">
                        <input type="submit" value="submit" id="submit" name="submit" class="btn btn-info">
                        <input type="reset" value="reset" id="reset" name="reset" class="btn btn-warning">
                    </div>
                </form>
            </div>
    </body>
</html>
