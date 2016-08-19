<%-- 
    Document   : admin
    Created on : Aug 2, 2016, 4:10:51 PM
    Author     : apprentice
--%>
<!-- #1 Directives -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <link href="https://fonts.googleapis.com/css?family=Alegreya|Righteous" rel="stylesheet"> 
    </head>
    <body>

        <div id="wrapper">

            <div id="page-content-wrapper">
                <div class="container-fluid">

                    <div class="row">
                        <div class="col-sm-10">
                            <h1>Cliente's Client Services || Administrator Page</h1>

                        </div>
                        <div class="col-sm-2">
                            <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a><br>
                            <a href="${pageContext.request.contextPath}/displayUserList">Manage Users</a>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">


                            <hr/>
                            <div id="dynamicNav"></div>

                            <div class="col-md-2 col-sm-2 col-xs-2 hidden-md hidden-sm hidden-xs">
                                <p id="tagsSearched"></p>
                                <div class="bs-sidebar"  id="sidebar-wrapper-admin" role="navigation"> 
                                </div>
                            </div>                            
                            <div class="col-lg-5">
                                <button type="submit" id="add-modal-page-button" class="btn btn-info">Add A New Page</button>

                                <table id="sTable" class="table table-hover">
                                    <tr>
                                        <th width="40%">Title</th>
                                        <th width="15%">Public</th>
                                        <th width="25%"></th>
                                        <th width="10%"></th>
                                        <th width="10%"></th>
                                    </tr>
                                    <tbody id="contentRows"></tbody>
                                </table>
                            </div>
                            <div class="col-lg-5">
                                <div class="row">
                                    <div class="col-md-4">
                                        <button type="submit" id="add-modal-button" class="btn btn-info">Add A New Post</button>
                                    </div>
                                    <div class="col-md-8">
                                        <p id="postsToApprove"></p>
                                    </div>
                                </div>

                                </form>

                                <%@include file="AddEditFrag.jsp"%>



                                <div>
                                    <sec:authorize access="not hasRole('ROLE_ADMIN')"> 
                                        <p id="content"></p>
                                        <script src="${pageContext.request.contextPath}/js/user.js"></script>
                                    </sec:authorize> 

                                    <sec:authorize access="hasRole('ROLE_ADMIN')"> 
                                        <p id="content"></p>
                                        <script src="${pageContext.request.contextPath}/js/admin.js"></script>
                                    </sec:authorize> 
                                </div>
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
        <script>

            // Replace the <textarea id="editor1"> with a CKEditor
            // instance, using default configuration.
            CKEDITOR.replace('addContentBody');
            CKEDITOR.replace('editContentBody');
            CKEDITOR.replace('editStaticBody');
            CKEDITOR.replace('addStatBody');


        </script>
        <script>
            $.fn.modal.Constructor.prototype.enforceFocus = function () {
                modal_this = this;
                $(document).on('focusin.modal', function (e) {
                    if (modal_this.$element[0] !== e.target && !modal_this.$element.has(e.target).length
                            && !$(e.target.parentNode).hasClass('cke_dialog_ui_input_select')
                            && !$(e.target.parentNode).hasClass('cke_dialog_ui_input_text')) {
                        modal_this.$element.focus();
                    }
                });
            };
        </script>
    </body>
</html>