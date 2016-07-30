<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayDvdListNoAjax">Display DVD List</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li> 
                </ul>    
            </div>
            <h2>Display DVD List (No Ajax)</h2>
            <div>
                Hello <sec:authentication property="principal.username" />!<br/> 
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="displayNewDvdFormNoAjax">Add a DVD</a><br>
                </sec:authorize>
                <hr>
                <c:forEach var="dvd" items="${dvdList}">
                    <s:url value="deleteDvdNoAjax"
                           var="deleteDvd_url">
                        <s:param name="dvdId" value="${dvd.dvdId}"></s:param>
                    </s:url>
                    <s:url value="displayEditDvdFormNoAjax"
                           var="editDvd_url">
                        <s:param name="dvdId" value="${dvd.dvdId}"></s:param>
                    </s:url>
                    Title: ${dvd.title} | 
                    
                    <sec:authorize access="hasRole('ROLE_ADMIN')"> 
                    <a href="${deleteDvd_url}">Delete</a> | 
                    <a href="${editDvd_url}">Edit</a> <br>
                    </sec:authorize> 
                    Release Date: ${dvd.releaseDate}<br>
                    Rating: ${dvd.rating}<br>
                    Director: ${dvd.director}<br>
                    Studio: ${dvd.studio}<br>
                    User Notes: ${dvd.userNotes}<br>
                    <hr>
                </c:forEach>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>