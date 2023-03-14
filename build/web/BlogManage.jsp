<%-- 
    Document   : BlogManage
    Created on : Mar 6, 2023, 4:15:01 PM
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
        <h1 style="color: red; text-align: center">Blog Manage</h1>
        </br>
        <div class="row">
            <div class="col-sm-8">
                <form  method="POST" action="addblog">
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase" class="from-label">Blog ID   </label>
                        
                        <input type="text" class="form-control" placeholder="BlogID" name="bid" id="bid" required>
                    </div> </br>
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase " class="from-label">Blog Title</label>
                        <input type="text" class="form-control" placeholder="Blog Title" name="bt" id="bt" required>
                    </div> </br>
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase" class="from-label">Blog Detail</label>
                        <input type="text" class="form-control" placeholder="Blog Detail" name="bd" id="bd" required>
                    </div> </br>
                    <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase" class="from-label">Blog Image</label>
                        <input type="text" class="form-control" placeholder="Blog Image" name="bi" id="bi" required>
                    </div> </br>
                     <div alight="left">
                        <label style="color: #0dcaf0; text-transform: uppercase" class="from-label">Blog Date </label>
                        <input type="text" class="form-control" placeholder="Blog Date" name="bdt" id="bdt" required>
                    </div> </br>
                    </br>
                    <div alight="right">
                        <input type="submit" value="submit" id="submit" name="submit" class="btn btn-info">
                        <input type="reset" value="reset" id="reset" name="reset" class="btn btn-warning">
                    </div>
                </form>
            </div>
            <div class="col-sm-8">
                <div class="panel-body">
                    <table id="tbl-flash" class="table table-responsive table-bordered" cellpadding="0" width="50%">
                        <thead>
                            <tr>
                                <th>BlogID</th>
                                <th>Blog Title</th>
                                <th>Blog Detail</th>
                                <th>Blog Image</th>
                                <th>Blog Date</th>
                                <th><a>Edit</a></th>
                                <th><a>Delete</a></th>
                            </tr>
                          <c:forEach items="${listB}" var="x">
                            <tr>
                        <td>${x.blog_id}</td>
                        <td>${x.blog_title}</td>
                        <td>${x.blog_detail}</td>
                        <td>${x.blog_image}</td>
                         <td>${x.blog_date}</td>
                        <td>
                            <a href="updateblog?sid=${x.blog_id}" class="btn btn-primary" >Update</a>
                        </td>
                        <td>
                            <a href="deleteblog?did=${x.blog_id}" class="btn btn-danger" >Delete</a>
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