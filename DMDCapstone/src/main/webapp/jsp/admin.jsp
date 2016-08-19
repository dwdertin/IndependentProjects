<%-- 
    Document   : admin
    Created on : Aug 2, 2016, 4:10:51 PM
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
        <title>Admin Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" 
              rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Styling.css"> 
        <script src="//cdn.ckeditor.com/4.5.10/standard/ckeditor.js"></script>
    </head>
    <body>

        <div id="wrapper">

            <div id="sidebar-wrapper">
            </div>
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">

                            <h1>Admin Page</h1>
                            <hr/>
                            <div class="navbar">
                                <ul class="nav nav-tabs">
                                    <li role="presentation">
                                        <a href="${pageContext.request.contextPath}/home">
                                            <span class="glyphicon glyphicon-home"></span>
                                        </a>
                                    </li>
                                    <li role="presentation" class="active">
                                        <a href="${pageContext.request.contextPath}/admin"  class="active"><span class="glyphicon glyphicon-lock"></span></a>
                                    </li>
                                </ul>
                            </div>
                            <h2>Look at these awesome posts!</h2>
                            
                            <button type="submit" id="add-modal-button" class="btn btn-info">Add A New Post</button>
                           <!--
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Tag to Search: </label>
                                    <div class="col-md-8">
                                    <input type="text" class="form-control" id="searchTag">
                                    </div>
                                <button type="submit" id="searchByTags" class="btn btn-info">Search Posts By Tag</button>
                                </div>
                            -->
                            </form>
                            <!--<a class="btn btn-info" id="menu-toggle" href="#menu-toggle">See Tag List</a> -->
                            <%@include file="AddEditFrag.jsp"%>
                            <!--                    <div class="well">
                                                <h2>Add A New Post</h2>
                                                <form class="form-horizontal" role="form">
                                                    <div class="form-group">
                                                        <label for="add-title" class="col-md-4 control-label">Title: </label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control" id="add-title" name="title"/>
                                                        </div> 
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="add-content" class="col-md-4 control-label">Content: </label>
                                                        <div class="col-md-8">
                                                            <textarea class="form-control" id="add-content" name="content"></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="add-tags" class="col-md-4 control-label">Tags: </label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control" id="add-tags" name="tags" placeholder="Please put a space between tags"/>
                                                        </div>
                                                    </div>
                                                    
                                                    <select name="isItLive" id="dropdown">
                                            <option value=true >Post</option>
                                            <option value=false>Save</option>
                                    </select>
                                                  <button type="submit" id="submit-button" class="btn btn-info">Go</button> 
                              
                                                </form>
                                                </div>-->
                            <div>
                                
                                <p id="content"></p>
                                
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

        <script>
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#wrapper").toggleClass("toggled");
            });
        </script>
        <script>

            // Replace the <textarea id="editor1"> with a CKEditor
            // instance, using default configuration.
            CKEDITOR.replace('addContentBody');
            CKEDITOR.replace('editContentBody');
            
        </script>
    </body>
</html>