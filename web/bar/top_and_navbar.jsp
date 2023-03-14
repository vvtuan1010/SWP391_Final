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
                <a href="/Online_Learning" class="navbar-brand ml-lg-3">
                    <h1 class="m-0 text-uppercase text-primary"><i class="fa fa-book-reader mr-3"></i>Online learning</h1>
                </a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between px-lg-3" id="navbarCollapse">
                    <div class="navbar-nav mx-auto py-0">
                        <a href="/Online_Learning" class="nav-item nav-link active">Home</a>

                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Category</a>
                            <div class="dropdown-menu m-0">
                                <c:forEach items="${requestScope.categories}" var="category">
                                    <a href="category?categoryId=${category.category_id}" class="dropdown-item">${category.category_name}</a>
                                </c:forEach>
                            </div>
                        </div>
                        <c:if test="${sessionScope.acc.role == 2}">
                            <a href="my-course" class="nav-item nav-link">My courses</a>
                        </c:if>

                        <a href="course.html" class="nav-item nav-link">Blogs</a>


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