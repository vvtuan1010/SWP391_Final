<%-- 
    Document   : index
    Created on : Feb 25, 2023, 10:30:38 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" media="all" href="CSS/style.css"/>
    </head>
    <body>
        <h1 style="color: red; text-align: center">FlashCard Manage</h1>
        </br>
        <div class="row">
            <div class="col-sm-4">
                <form  method="POST" action="add">
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase" class="from-label">FlashCardID</label>
                        
                        <input type="text" class="form-control" placeholder="FlashCardID" name="fname" id="fname" required>
                    </div>
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase " class="from-label">FlashCard Question</label>
                        <input type="text" class="form-control" placeholder="FlashCard Question" name="fquest" id="fquest" required>
                    </div>
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase" class="from-label">FlashCard Answer</label>
                        <input type="text" class="form-control" placeholder="FlashCard Answer" name="fansw" id="fansw" required>
                    </div>
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase" class="from-label">LessonID</label>
                        <input type="text" class="form-control" placeholder="LessonID" name="lid" id="lid" required>
                    </div>
                    
                    </br>
                    <div alight="right">
                        <input type="submit" value="submit" id="submit" name="submit" class="btn btn-info">
                        <input type="reset" value="reset" id="reset" name="reset" class="btn btn-warning">
                    </div>
                </form>
            </div>
            <div class="col-sm-8">
                <div class="panel-body">
                    <table id="tbl-flash" class="table table-responsive table-bordered" cellpadding="0" width="100%">
                        <thead>
                            <tr>
                                <th>FlashCardID</th>
                                <th>FlashCard Question</th>
                                <th>FlashCard Answer</th>
                                <th>LessonID</th>
                                <th><a>Edit</a></th>
                                <th><a>Delete</a></th>
                            </tr>
                             <c:forEach items="${listP}" var="x">
                            <tr>
                        <td>${x.flash_id}</td>
                        <td>${x.flash_question}</td>
                        <td>${x.flash_answer}</td>
                        <td>${x.lesson_id}</td>
                        <td>
                            <a href="update?sid=${x.flash_id}" class="btn btn-primary" >Update</a>
                        </td>
                        <td>
                            <a style="color: white"href="delete?fid=${x.flash_id}" class="btn btn-danger" >Delete</a>
                        </td>
                            </tr>
                             </c:forEach> 
                        </thead>
                           
                        
                    </table>
                    
                </div>
            </div>
        </div>
    </body>
</html>
