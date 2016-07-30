<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr/>
           
            <h2>New DVD Form (No Ajax)</h2>
             <a href="displayDvdListNoAjax">DVD List (No Ajax)</a><br>
            <sf:form class="form-horizontal"
                     modelAttribute="dvd"
                  role="form"
                  action="addDvdNoAjax"
                  method="POST">
                <div class="form-group">
                    <label for="add-title" class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-title" path="title" placeholder="Title"/>
                        <sf:errors path="title" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-release-date" class="col-md-4 control-label">Release Date:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-release-date" path="releaseDate" placeholder="Release Date"/>
                        <sf:errors path="releaseDate" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-rating" class="col-md-4 control-label">Rating:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-rating" path="rating" placeholder="Rating"/>
                        <sf:errors path="rating" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-director" class="col-md-4 control-label">Director:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-director" path="director" placeholder="Director"/>
                        <sf:errors path="director" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-studio" class="col-md-4 control-label">Studio:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-studio" path="studio" placeholder="Studio"/>
                        <sf:errors path="studio" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-user-notes" class="col-md-4 control-label">User Notes:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-user-notes" path="userNotes" placeholder="User Notes"/>
                        <sf:errors path="userNotes" cssClass="error"/>
                        <sf:hidden path="dvdId"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type="submit" id="add-button" class="btn btn-default">Add DVD</button>
                    </div>
                </div>
            </sf:form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
