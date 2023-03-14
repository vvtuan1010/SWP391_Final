

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="login.css">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body style="background-color: #eee;align-items: center">

        <section class="h-100 gradient-form">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-xl-10">
                        <div class="card rounded-3 text-black">
                            <div class="row g-0">
                                <div class="col-lg-6">
                                    <div class="card-body p-md-5 mx-md-4">
                                        <form action="CheckActivate" method="post">
                                            <p class="text-success">We send activation code to your email, please check it.</p>
                                            <div class="form-outline mb-4">
                                                <input name="codeInput" type="text" id="form2Example11" class="form-control"/>
                                                <label class="form-label" for="form2Example11">Enter your activation code</label>
                                             
                                            </div>
                                            <p class="text-danger">${mess}</p>
                                            <p class="text-danger">${mess1}</p>
                                            <div class="text-center pt-1 mb-5 pb-1">
                                                <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="button"><a href="Login.jsp" style="text-decoration: none;color: white">Login</a></button>
                                                <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="submit">Activate</button>
                                            </div>                                           

                                        </form>

                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <img src="https://observatory.tec.mx/wp-content/uploads/2019/03/bigstock-Vector-Creative-Illustration-256954996.jpg">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>







        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

    </body>
</html>



