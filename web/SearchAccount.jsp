<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Edukate - Online Education Website Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

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
        <link href="css/style.manageTitle.css" rel="stylesheet">
    </head>

    <body>
        <!-- Topbar Start -->
        <div class="container-fluid bg-dark">
            <div class="row py-2 px-lg-5">
                <div class="col-lg-6 text-center text-lg-left mb-2 mb-lg-0">
                    <div class="d-inline-flex align-items-center text-white">
                        <small><i class="fa fa-phone-alt mr-2"></i>+84 869937283</small>
                        <small class="px-3">|</small>
                        <small><i class="fa fa-envelope mr-2"></i>tuanvvhe160982@fpt.edu.vn</small>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right">
                    <div class="d-inline-flex align-items-center">
                        <a class="text-white px-2" href="">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a class="text-white px-2" href="">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a class="text-white px-2" href="">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                        <a class="text-white px-2" href="">
                            <i class="fab fa-instagram"></i>
                        </a>
                        <a class="text-white pl-2" href="">
                            <i class="fab fa-youtube"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <!-- Navbar Start -->
        <div class="container-fluid p-0">
            <nav class="navbar navbar-expand-lg bg-white navbar-light py-3 py-lg-0 px-lg-5">
                <a href="index.html" class="navbar-brand ml-lg-3">
                    <h1 class="m-0 text-uppercase text-primary"><i class="fa fa-book-reader mr-3"></i>Online learning</h1>
                </a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between px-lg-3" id="navbarCollapse">
                    <div class="navbar-nav mx-auto py-0">
                        <a href="index.html" class="nav-item nav-link active">Home</a>

                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Category</a>
                            <div class="dropdown-menu m-0">
                                <a href="detail.html" class="dropdown-item">Foreign Language</a>
                                <a href="feature.html" class="dropdown-item">Mathematic</a>
                                <a href="team.html" class="dropdown-item">Engineering</a>
                                <a href="testimonial.html" class="dropdown-item">Business</a>
                                <a href="testimonial.html" class="dropdown-item">Others</a>
                            </div>
                        </div>
                        <c:if test="${sessionScope.acc.role == 2}">
                            <a href="about.html" class="nav-item nav-link">My courses</a>
                        </c:if>

                        <a href="course.html" class="nav-item nav-link">Blogs</a>


                    </div>
                    <c:if test="${sessionScope.acc != null}">                   
                        <div class="nav-item dropdown"">
                            <a href="#" style="color: black" class="nav-link dropdown-toggle" data-toggle="dropdown"><img src="https://img.icons8.com/material-sharp/1x/person-male.png" alt="alt"/>${nameOfUser}</a>
                            <div class="dropdown-menu m-0">
                                <a href="LoadProfile" class="dropdown-item">My Profile</a>

                                <c:if test="${sessionScope.acc.role == 1}">
                                    <a href="ManageAccount" class="dropdown-item">Manage Accounts</a>
                                </c:if>
                                <c:if test="${sessionScope.acc.role == 3}">
                                    <a href="LoadProfile" class="dropdown-item">Manage Courses</a>
                                </c:if>
                                <c:if test="${sessionScope.acc.role == 4}">
                                    <a href="LoadProfile" class="dropdown-item">Manage Blogs</a>
                                </c:if>
                                <a href="LogOut" class="dropdown-item">Log Out</a>
                            </div>
                        </div>
                    </c:if>           
                    <c:if test="${sessionScope.acc == null}">
                        <a href="Login.jsp" class="btn btn-primary py-2 px-4 d-none d-lg-block">Log In</a>
                    </c:if>


                </div>
            </nav>
        </div>
        <!-- Navbar End -->
        <p style="">Number of users in the system: </p>
        <div  style="text-align: center" >
            <a class='ManageTitle' href="LoadUserAccount">User Account</a>
            <a   class='ManageTitle' href="LoadExpertAccount">Expert Account</a>
            <a  class='ManageTitle'  href="LoadSellerAccount">Seller Account</a>
        </div>
        <div class="input-group justify-content-end">
            <form method="post" action="SearchAccount" class="d-flex">
                <input name="search" type="email" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                <button type="submit" class="btn btn-outline-primary">search</button>
            </form>

        </div>
        <c:if test="${check == true}">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">User Email</th>
                        <th scope="col">Role</th>
                        <th scope="col">#</th>
                        <th scope="col">#</th>
                    </tr>
                </thead>
                <tbody> 

                    <tr>
                        <th scope="row">${accsearch.usergmail}</th>
                            <c:if test="${accsearch.role == 1}">
                            <td>Admin</td>
                        </c:if>
                        <c:if test="${accsearch.role == 2}">
                            <td>User</td>
                        </c:if>
                        <c:if test="${accsearch.role == 3}">
                            <td>Expert</td>
                        </c:if> 
                        <c:if test="${accsearch.role == 4}">
                            <td>Seller</td>
                        </c:if>     
                        <td><a href="LoadProfileToChangeRole?UserGmail=${o.usergmail}">Change Role</a></td>
                        <td>
                            <form method="post" action="DeleteAccount">
                                <input type="hidden" name="usergmail" value="${o.usergmail}">
                                <input type="hidden" name="id" value="1">
                                <button class="btn btn-danger" type="button" onclick="showConfirmDialog('${o.usergmail}')">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:if>  


            <div style="text-align: center">
                <p style="font-size: xx-large;font-weight: bold" class="text-danger">${mess}</p>
            </div>

        </tbody>
    </table>



    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>
            <c:forEach begin="1" end="${numberPage}" var="i">
                <li class="page-item"><a class="page-link" href="PagingUserAccount?index=${i}">${i}</a></li>
                </c:forEach>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>
    </nav>

    <!-- Footer Start -->
    <div class="container-fluid position-relative overlay-top bg-dark text-white-50 py-5" style="margin-top: 90px;">
        <div class="container mt-5 pt-5">
            <div class="row">
                <div class="col-md-6 mb-5">
                    <a href="index.html" class="navbar-brand">
                        <h1 class="mt-n2 text-uppercase text-white"><i class="fa fa-book-reader mr-3"></i>Edukate</h1>
                    </a>
                    <p class="m-0">Accusam nonumy clita sed rebum kasd eirmod elitr. Ipsum ea lorem at et diam est, tempor rebum ipsum sit ea tempor stet et consetetur dolores. Justo stet diam ipsum lorem vero clita diam</p>
                </div>
                <div class="col-md-6 mb-5">
                    <h3 class="text-white mb-4">Newsletter</h3>
                    <div class="w-100">
                        <div class="input-group">
                            <input type="text" class="form-control border-light" style="padding: 30px;" placeholder="Your Email Address">
                            <div class="input-group-append">
                                <button class="btn btn-primary px-4">Sign Up</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 mb-5">
                    <h3 class="text-white mb-4">Get In Touch</h3>
                    <p><i class="fa fa-map-marker-alt mr-2"></i>123 Street, New York, USA</p>
                    <p><i class="fa fa-phone-alt mr-2"></i>+012 345 67890</p>
                    <p><i class="fa fa-envelope mr-2"></i>info@example.com</p>
                    <div class="d-flex justify-content-start mt-4">
                        <a class="text-white mr-4" href="#"><i class="fab fa-2x fa-twitter"></i></a>
                        <a class="text-white mr-4" href="#"><i class="fab fa-2x fa-facebook-f"></i></a>
                        <a class="text-white mr-4" href="#"><i class="fab fa-2x fa-linkedin-in"></i></a>
                        <a class="text-white" href="#"><i class="fab fa-2x fa-instagram"></i></a>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <h3 class="text-white mb-4">Our Courses</h3>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Web Design</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Apps Design</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Marketing</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Research</a>
                        <a class="text-white-50" href="#"><i class="fa fa-angle-right mr-2"></i>SEO</a>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <h3 class="text-white mb-4">Quick Links</h3>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Privacy Policy</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Terms & Condition</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Regular FAQs</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Help & Support</a>
                        <a class="text-white-50" href="#"><i class="fa fa-angle-right mr-2"></i>Contact</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid bg-dark text-white-50 border-top py-4" style="border-color: rgba(256, 256, 256, .1) !important;">
        <div class="container">
            <div class="row">
                <div class="col-md-6 text-center text-md-left mb-3 mb-md-0">
                    <p class="m-0">Copyright &copy; <a class="text-white" href="#">Your Site Name</a>. All Rights Reserved.
                    </p>
                </div>
                <div class="col-md-6 text-center text-md-right">
                    <p class="m-0">Designed by <a class="text-white" href="https://htmlcodex.com">HTML Codex</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary rounded-0 btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <script>
                                    function showConfirmDialog(usergmail) {
                                        if (confirm("Are you sure about that?")) {
                                            // Gửi yêu cầu xóa đến servlet
                                            window.location.href = "DeleteAccount?usergmail=" + usergmail;
                                        }
                                    }

    </script>
</body>

</html>