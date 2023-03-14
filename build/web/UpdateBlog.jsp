<%-- 
    Document   : UpdateBlog
    Created on : Mar 7, 2023, 3:02:02 AM
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
        <h1 style="color: red; text-align: center">Update Blog</h1>
        </br>
        <div class="row">
            <div class="col-sm-8">
                <form  method="POST" action="updateblog">
                    <div alight="left">
                        <label  style="color: #0dcaf0; text-transform: uppercase" class="from-label">Blog ID   </label>
                        
                        <input value="${bl.blog_id}" type="text" class="form-control" placeholder="BlogID" name="bid" id="bid" required>
                    </div> </br>
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase " class="from-label">Blog Title</label>
                        <input value="${bl.blog_title}" type="text" class="form-control" placeholder="Blog Title" name="bt" id="bt" required>
                    </div> </br>
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase" class="from-label">Blog Detail</label>
                        <input value="${bl.blog_detail}" type="text" class="form-control" placeholder="Blog Detail" name="bd" id="bd" required>
                    </div> </br>
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase" class="from-label">Blog Image</label>
                        <input value="${bl.blog_image}" type="text" class="form-control" placeholder="Blog Image" name="bi" id="bi" required>
                    </div> </br>
                     <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase" class="from-label">Blog Date </label>
                        <input value="${bl.blog_date}" type="text" class="form-control" placeholder="Blog Date" name="bdt" id="bdt" required>
                    </div> </br>
                    </br>
                    <div alight="right">
                        <input type="submit" value="submit" id="submit" name="submit" class="btn btn-info">
                        <input type="reset" value="reset" id="reset" name="reset" class="btn btn-warning">
                    </div>
                </form>
            </div>