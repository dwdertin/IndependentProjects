<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 
    Document   : Static
    Created on : Aug 8, 2016, 3:46:20 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
        <head>
            <title>Cliente's Client Services</title>
            <!-- Bootstrap core CSS -->
            <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
                  rel="stylesheet">
            <!-- Custom styles for this template -->
            <link href="${pageContext.request.contextPath}/css/starter-template.css"
                  rel="stylesheet">
            <!-- SWC Icon -->
            <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
            <link href="https://fonts.googleapis.com/css?family=Alegreya|Righteous" rel="stylesheet"> 
            <link href="css/simple-sidebar.css" rel="stylesheet">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Styling.css">
        </head>
        <body>
            <div class="container">
                <h1>Cliente's Client Services</h1>
                <hr/>

                <div id="dynamicNav"></div>


      
                <div class="well">
                <div id="postPageContent"> </div>
                <div align="right">
                ${Post.datePosted}
                </div>
                <h2><c:out value="${Post.title}"/></h2>
                   <br>

                   
                   ${Post.contentBody}
                   <br>
                   <a href="home">Return to Home</a>
                </div>
                   
                  
                


            </div>
            <!-- SCRIPTS -->
            <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/homeBlogPage.js"></script>
            <script src="${pageContext.request.contextPath}/js/StaticPage.js"></script>
            <link rel="stylesheet" href="jquery-activmap/css/jquery-activmap.css">
            
        </body>
    </html>
