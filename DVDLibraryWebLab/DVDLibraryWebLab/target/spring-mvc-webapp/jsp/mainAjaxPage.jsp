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
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/mainAjaxPage">DVD List (Ajax)</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayDvdListNoAjax">Display DVD List</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li> 
                </ul>    
            </div>
            <h2>Home Page</h2>


            <div class="row" id="whiteBack">
                <!--
                #2: Add a col to hold the summary table - have it take up half the row
                -->
                <div class="col-md-6">
                    <h2>DVD Library</h2>
                    <%@include file="dvdSummaryTableFragment.jsp"%>
                </div> <!-- End col div -->
                <!--
                #4: Add col to hold the new contact form - have it take up the other
                half of the row
                -->
                <div class="col-md-6">
                    <h2>Add New DVD</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-title" class="col-md-4 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-title"
                                       placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-release-date" class="col-md-4 control-label">
                                Release Date:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-release-date"
                                       placeholder="Release Date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-rating" class="col-md-4 control-label">
                                Rating:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-rating"
                                       placeholder="Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-director" class="col-md-4 control-label">
                                Director:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-director"
                                       placeholder="Director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-studio" class="col-md-4 control-label">
                                Studio:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-studio"
                                       placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-user-notes" class="col-md-4 control-label">
                                User Notes:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-user-notes"
                                       placeholder="User Notes"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-default">
                                    Add DVD
                                </button>
                            </div>
                        </div>
                    </form>
                    <div id="validationErrors" style="color: red"/>
                </div> <!-- End col div -->
            </div> <!-- End row div --> 
        </div>

        <%@include file="detailsEditModalFragment.jsp"%>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdList.js"></script>

    </body>
</html>