<%-- 
    Document   : home
    Created on : Aug 2, 2016, 4:01:55 PM
    Author     : apprentice
--%>
<!-- #1 Directives -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <link href="css/simple-sidebar.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Styling.css">
    </head>
    <body>
        <div id="wrapper">

            <div id="sidebar-wrapper"> 
            </div>
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">

                            <h1>Cliente's Client Services</h1>
                            <hr/>
                            <div class="navbar">
                                <ul class="nav nav-tabs">
                                    <li role="presentation"  class="active">
                                        <a href="${pageContext.request.contextPath}/home" class="active"><span class="glyphicon glyphicon-home"></span></a>
                                    </li>
                                    <li role="presentation"><a href="${pageContext.request.contextPath}/static">Static for Daisy</a>
                                    </li>
                                    <li role="presentation"><a href="${pageContext.request.contextPath}/admin"><span class="glyphicon glyphicon-lock"></span></a>
                                    </li>
                                </ul>
                            </div>

                            <!-- <a class="btn btn-info" id="menu-toggle" href="#menu-toggle">See Tag List</a> -->
                            <div class="lazy-wrapper">
                                <p id="homeContent"></p>
                            </div>
                        </div>
                    </div>
                    <h3>${message}</h3>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/homeBlogPage.js"></script>
        <link rel="stylesheet" href="jquery-activmap/css/jquery-activmap.css">
        <script src="jquery-lazyloader/js/lazyloader.js"></script>

        <script>
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#wrapper").toggleClass("toggled");
            });
        </script>
    </body>
</html>