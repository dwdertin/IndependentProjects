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
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li> 
                </ul>    
            </div>
            <h2>Search</h2>

            <div class="col-md-6">
                <h2>DVD Library</h2>
                <%@include file="dvdSummaryTableFragment.jsp"%>
            </div> 
            
                     <div class="col-md-6">
                    <h2>Search DVD Library</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="search-title" class="col-md-4 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="search-title"
                                       placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-release-date" class="col-md-4 control-label">
                                Release Date:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="search-release-date"
                                       placeholder="Release Date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-rating" class="col-md-4 control-label">
                                Rating:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="search-rating"
                                       placeholder="Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-director" class="col-md-4 control-label">
                                Director:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="search-director"
                                       placeholder="Director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-studio" class="col-md-4 control-label">
                                Studio:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="search-studio"
                                       placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-user-notes" class="col-md-4 control-label">
                                User Notes:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="search-user-notes"
                                       placeholder="User Notes"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="search-button"
                                        class="btn btn-default">
                                    Search DVD Library
                                </button>
                            </div>
                        </div>
                    </form>
                </div> 
            </div> 

        <%@include file="detailsEditModalFragment.jsp"%>
                
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdList.js"></script>

    </body>
</html>