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
        <h1>Add User Form</h1>
        <a href="${pageContext.request.contextPath}/displayUserList">Return to User List</a>
        <form method="POST" action="addUser">
            Username: <input type="text" name="username"/><br/>
            Password:&nbsp; <input type="password" name="password"/><br/>
            Admin User? <input type="checkbox" name="isAdmin" value="yes"/> <br/>
            <input type="submit" value="Add User"/><br/>
        </form>
    </body>
</html>
