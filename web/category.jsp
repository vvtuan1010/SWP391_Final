<%-- 
    Document   : category
    Created on : Mar 5, 2023, 11:30:47 PM
    Author     : duke
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <link href="scss/bootstrap/scss/bootstrap.scss" rel="stylesheet">

        <title>JSP Page</title>
    </head>
    <%@include file="bar/top_and_navbar.jsp" %>
    <body>
        <div class="justify-content-center" >
            <c:forEach items="${requestScope.courses}" var="course">

                <a href='course-detail?courseId=${course.course_id}&user_gmail=${sessionScope.acc.usergmail}' style="width: 100%;" ><div class="card mb-3" style="max-width: 540px; margin-left: 500px;"> 
                    <div class="row no-gutters">

                        <div class="col-md-4">
                            <img src="${course.course_image}" class="card-img img-fluid" alt="...">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5  class="card-title">${course.course_name}</h5> 
                                <p class="card-text">${course.course_description}</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                        </div>
                </a>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
