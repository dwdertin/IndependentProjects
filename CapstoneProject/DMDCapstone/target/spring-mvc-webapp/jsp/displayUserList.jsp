<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Users</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Styling.css">
    </head>
    <body>
        <h1>Users</h1>
        <a href="displayUserForm">Add a User</a><br/>
        <a href="${pageContext.request.contextPath}/admin">Return to Admin Page</a>
        <hr/>
        <c:forEach var="user" items="${users}">
            <c:out value="${user.username}"/> |
            <a href="deleteUser?username=${user.username}">Delete</a><br/><br/>
        </c:forEach>
    </body>
</html>
