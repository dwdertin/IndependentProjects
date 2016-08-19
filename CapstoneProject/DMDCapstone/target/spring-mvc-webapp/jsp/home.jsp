<%-- 
    Document   : home
    Created on : Aug 2, 2016, 4:01:55 PM
    Author     : apprentice
--%>
<!-- #1 Directives -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cliente's Client Services</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <link href="https://fonts.googleapis.com/css?family=Alegreya|Righteous" rel="stylesheet"> 
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Styling.css">
    </head>
    <body>
        <div id="wrapper">


            <div class="container">
                <div class="row">
                    <div class="col-sm-10">
                        <h1>Cliente's Client Services</h1>

                    </div>
                    <div class="col-sm-2">
                        <a href="${pageContext.request.contextPath}/login">Log in</a>
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_USER')"> 
                            <p><a href="${pageContext.request.contextPath}/admin">Admin</a></p>
                        </sec:authorize> 
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">

                        <hr/>
                        <div id="dynamicNav"></div>

                    </div>
                </div>
                <!--                            <div class="navbar" id="navi">
                                                <ul class="nav nav-tabs" id="tabby">
                                                    <li role="presentation"  class="active">
                                                        <a href="${pageContext.request.contextPath}/home" class="active"><span class="glyphicon glyphicon-home"></span></a>
                                                    </li>
                                                    <li role="presentation" id="test"></li>
                                                    <li role="presentation"><a href="${pageContext.request.contextPath}/static">Static for Daisy</a>
                                                    </li>
                                                    
                                                    <li role="presentation"><a href="${pageContext.request.contextPath}/admin"><span class="glyphicon glyphicon-lock"></span></a>
                                                    </li>
                                                    <li role="presentation" class="nav nav-tabs navbar-right"><a href="${pageContext.request.contextPath}/login">Log in</a></li>
                
                                                </ul>
                                            </div>-->

                <!-- <a class="btn btn-info" id="menu-toggle" href="#menu-toggle">See Tag List</a> -->
                <div class="lazy-wrapper">
                    <div class="row">
                        <div class="col-md-2 col-sm-2 col-xs-2 hidden-sm hidden-xs">
                            <p id="tagsSearched"></p>

                            <div class="bs-sidebar"  id="sidebar-wrapper" role="navigation"> 

                            </div>
                        </div>
                        <div class="col-md-10 col-sm-10 col-xs-10">
                            <div class="scroll">
                            <p id="homeContent"></p>
                            <div id="loading"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/homeBlogPage.js"></script>
        <script src="${pageContext.request.contextPath}/js/StaticPage.js"></script>
        <script src="${pageContext.request.contextPath}/js/admin.js"></script>
    </body>
</html>