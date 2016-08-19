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
        <link href="css/simple-sidebar.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Styling.css">
    </head>
    <body>
        <h1>Cliente's Client Services</h1>
                            <hr/>
                            <div class="navbar">
                                <ul class="nav nav-tabs">
                                    <li role="presentation"  class="active">
                                        <a href="${pageContext.request.contextPath}/home"><span class="glyphicon glyphicon-home"></span></a>
                                    </li>
                                    <li role="presentation"><a href="${pageContext.request.contextPath}/static" class="active">Static for Daisy</a>
                                    </li>
                                    <li role="presentation"><a href="${pageContext.request.contextPath}/admin"><span class="glyphicon glyphicon-lock"></span></a>
                                    </li>
                                </ul>
                            </div>
        <!-- SCRIPTS -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/homeBlogPage.js"></script>
        <link rel="stylesheet" href="jquery-activmap/css/jquery-activmap.css">
    </body>
</html>
