

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="login.css">
        <script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js" type="text/javascript"></script>
        <link href="https://unpkg.com/gijgo@1.9.14/css/gijgo.min.css" rel="stylesheet" type="text/css" />
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
                                        <form action="Signup" method="post">
                                            <div class="form-outline mb-4">
                                                <input name="fullname" type="text" id="form2Example11" class="form-control"/>
                                                <label class="form-label" for="form2Example11">Name</label>
                                                <p class="text-danger">${messname}</p>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <input name="user" type="email" id="form2Example11" class="form-control"/>
                                                <label class="form-label" for="form2Example11">Email</label>
                                            </div>
                                            <p class="text-danger">${messemail}</p>
                                            <p class="text-danger">${mess1}</p>
                                            <div  class="form-outline mb-4">
                                                <input name="pass" type="password" id="form2Example22" class="form-control" />
                                                <label class="form-label" for="form2Example22">Password</label>
                                            </div>
                                            <p class="text-danger">${messpass}</p>
                                            <div  class="form-outline mb-4">
                                                <input name="repass" type="password" id="form2Example22" class="form-control" />
                                                <label class="form-label" for="form2Example22">Re-enter Password</label>
                                            </div>
                                            <p class="text-danger">${mess2}</p>                       
                                            <div  class="form-outline mb-4">
                                                <label class="form-label" for="form2Example11">Gender</label>
                                                <select name="gender">
                                                    <option value="Male">Male</option>
                                                    <option value="Female">Female</option>
                                                </select><br>
                                            </div>
                                            <div  class="form-outline mb-4">
                                                <input name="dob" type="date" id="form2Example11" class="form-control" required/>
                                                <label class="form-label" for="form2Example11">Date of birth</label>
                                            </div>
                                            <p class="text-danger">${messdob}</p>
                                            <div  class="form-outline mb-4">
                                                <input name="phone" type="text" id="form2Example11" class="form-control" pattern="(\+84|0)\d{9}" title="Ví dụ: 0987654321" />
                                                <label class="form-label" for="form2Example11">Phone Number</label>
                                            </div>
                                            <p class="text-danger">${messphone}</p>
                                            <div class="text-center pt-1 mb-5 pb-1">
                                                <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="button"><a href="Login.jsp" style="text-decoration: none;color: white">Back</a></button>
                                                <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="submit">Register</button>
                                            </div>                                           

                                        </form>

                                    </div>
                                </div>
                                <div class="col-lg-6" style="text-align: center;margin-top: 5%">
                                    <img style="height: 45%;text-align: center" src="https://observatory.tec.mx/wp-content/uploads/2019/03/bigstock-Vector-Creative-Illustration-256954996.jpg">
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



