<%-- 
    Document   : Blog
    Created on : Mar 6, 2023, 1:56:04 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style.css" rel="stylesheet">
        <title>My Blog</title>
        <%@include file="bar.jsp" %>        
    </head>
    <body>
        
        
        <main>

            <c:forEach items="${listC}" var="o">

                <div class="blog-post">
                    <h2>${o.blog_title}</h2>
                    <img src="${o.blog_image}" width="600" height="400">
                    <p>${o.blog_detail}</p>
<!--                    <a href="#">Đọc tiếp</a>-->
                </div>
                    <div class="comments">
    <ul>
      <li>
        <div class="comment">
          <p>Comment content...</p>
          <span class="comment-meta">Posted by John Doe on 1 January 2022</span>
          <button class="like-button">Like</button>
        </div>
      </li>
    </ul>

    <form class="comment-form">
      <label for="comment">Leave a comment:</label>
      <textarea id="comment" name="comment"></textarea>
      <button type="submit">Submit</button>
    </form>
  </div>
            </c:forEach>

