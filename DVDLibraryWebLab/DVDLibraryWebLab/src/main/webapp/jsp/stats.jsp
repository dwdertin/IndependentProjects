<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dvdlibrarystyle.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/mainAjaxPage">DVD List (Ajax)</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayDvdListNoAjax">Display DVD List</a></li>   
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li> 
                </ul>    
            </div>
        
            <div class="row">
                <!-- #1: Contacts Per Company Chart -->
                <div class="col-md-12">
                    <h2>Statistics</h2>
                    <!-- #2: this is where we'll render the bar chart -->
                    <div id="chart_div"></div>
                </div>
            </div>


        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <!-- #1: Include and load Google Charts - both steps are required -->
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script>
            google.load('visualization', '1.0', {'packages': ['corechart']});
        </script> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdList.js"></script>
        <script src="${pageContext.request.contextPath}/js/stats.js"></script>


    </body>
</html>