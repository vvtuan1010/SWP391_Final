<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Dashboard Template Â· Bootstrap v5.2</title>
        <!--bootstrap CSS embed-->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/datatables/jquery.dataTables.min.css">
        <!--cus CSS embed-->
        <link href="assets/css/dashboard-common.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/product-management.css">
    </head>

    <body>        

        <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Company name</a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <input class="form-control form-control-dark w-100 rounded-0 border-0" type="text" placeholder="Search"
                   aria-label="Search">
            <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3" href="#">Sign out</a>
                </div>
            </div>
        </header>

        <div class="container-fluid">
            <div class="row">
                <%@include file="sidebar-manage.jsp" %>

                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">Dashboard</h1>
                        <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="btn-group me-2">
                                <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                            </div>
                            <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                                <span data-feather="calendar" class="align-text-bottom"></span>
                                This week
                            </button>
                        </div>
                    </div>
                </main>
            </div>
        </div>

        <h2>Adding Course</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Image</th>
                <th>CategoryID</th>
            </tr>
            <tr>
            <form action="add-one-course" method="post">
                <td>
                    <input name="CourseID" type="number" value="${requestScope.obj.course_id}">
                </td>
                <td>  
                    <input name="CourseName" type="text" value="${requestScope.obj.course_name}">
                </td>
                <td>     
                    <input name="CourseDescription" type="text" value="${requestScope.obj.course_description}">
                </td>
                <td>  
                    <input name="CourseImage" type="text" value="${requestScope.obj.course_image}">
                </td>
                <td>     
                    <input name="CategoryID" type="text" value="${requestScope.obj.category_id}">
                </td>
                <button type="submit">ADD ONE</button>
            </form>

        </tr>
    </table>


    <h2>Update Course</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
            <th>CategoryID</th>
        </tr>
        <tr>
        <form action="update-course" method="post">
            <td>
                <input name="CourseID" type="number" value="${requestScope.obj.course_id}">
            </td>
            <td>  
                <input name="CourseName" type="text" value="${requestScope.obj.course_name}">
            </td>
            <td>     
                <input name="CourseDescription" type="text" value="${requestScope.obj.course_description}">
            </td>
            <td>  
                <input name="CourseImage" type="text" value="${requestScope.obj.course_image}">
            </td>
            <td>     
                <input name="CategoryID" type="text" value="${requestScope.obj.category_id}">
            </td>
            <button type="submit">Update ONE</button>
        </form>

    </tr>
</table>

<h2>Delete Course</h2>
<form action="delete-course" method="post">
    <input name="CourseID" type="number" value="${requestScope.obj.course_id}">
    <button type="submit">DELETE ONE</button>
</form>


</body>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="assets/datatables/jquery-3.5.1.js"></script>
<script src="assets/datatables/jquery.datatables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#table-cpu').DataTable({
            pagingType: 'full_numbers'
        });
        $('#table-vga').DataTable({
            pagingType: 'full_numbers'
        });
        $('#table-ram').DataTable({
            pagingType: 'full_numbers'
        });
        $('#table-mon').DataTable({
            pagingType: 'full_numbers'
        });
        $('#table-main').DataTable({
            pagingType: 'full_numbers'
        });
        $('#table-case').DataTable({
            pagingType: 'full_numbers'
        });
    });
</script>

</html>