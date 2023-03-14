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

                        <a href="Blog.jsp" class="nav-item nav-link">Blogs</a>


                    </div>
                    <c:if test="${sessionScope.acc != null}">                   
                        <div class="nav-item dropdown"">
                            <a href="#" style="color: black" class="nav-link dropdown-toggle" data-toggle="dropdown"><img src="https://img.icons8.com/material-sharp/1x/person-male.png" alt="alt"/>${nameOfUser}</a>
                            <div class="dropdown-menu m-0">
                                <a href="LoadProfile" class="dropdown-item">My Profile</a>

                                <c:if test="${sessionScope.acc.role == 1}">
                                    <a href="LoadProfile" class="dropdown-item">Manage Accounts</a>
                                </c:if>
                                <c:if test="${sessionScope.acc.role == 3}">
                                    <a href="LoadProfile" class="dropdown-item">Manage Courses</a>
                                </c:if>
                                <c:if test="${sessionScope.acc.role == 4}">
                                    <a href="BlogManage.jsp" class="dropdown-item">Manage Blogs</a>
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


        <!-- Header Start -->
        <div class="jumbotron jumbotron-fluid position-relative overlay-bottom" style="margin-bottom: 90px;">
            <div class="container text-center my-5 py-5">
                <h1 class="text-white mt-4 mb-4">Learn From Home</h1>
                <h1 class="text-white display-1 mb-5">Education Courses</h1>
                <div class="mx-auto mb-5" style="width: 100%; max-width: 600px;">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <button class="btn btn-outline-light bg-white text-body px-4 dropdown-toggle" type="button" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">Courses</button>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">Courses 1</a>
                                <a class="dropdown-item" href="#">Courses 2</a>
                                <a class="dropdown-item" href="#">Courses 3</a>
                            </div>
                        </div>
                        <input type="text" class="form-control border-light" style="padding: 30px 25px;" placeholder="Keyword">
                        <div class="input-group-append">
                            <button class="btn btn-secondary px-4 px-lg-5">Search</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End -->
 