<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Unit Converter</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        
    </head>
    <body>
        <div class="container">
            <h1>Unit Converter</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/luckyseven">Lucky Seven</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/factorizor">Factorizor</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/interestcalc">Interest Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/converter">Unit Converter</a></li>
                </ul>    
            </div>
                    <c:choose>
            <c:when test="${tempStartingType != null}">
                <div id="${tempStartingType}">
                    <h1>Here are your results:</h1>
                    <h2>Converting from: ${param.tempStartingType} </h2>
                    <h3>Degrees Fahrenheit: ${degreesF}</h3>
                    <h3>Degrees Celsius: ${degreesC} </h3>
                    <a href="${pageContext.request.contextPath}/converter">Convert Again</a>
                </div>
            </c:when>
            <c:when test="${weightStartingType != null}">
            <div id="${weightStartingType}">
                <h1>Here are your results:</h1>
                <h2>Converting from: ${weightStartingType} </h2>
                <h3>Weight in Pounds: ${weightPounds} </h3>
                <h3>Weight in Kilograms: ${weightKilograms} </h3>
                <a href="${pageContext.request.contextPath}/converter">Convert Again</a>
            </div> 
            </c:when>
                    </c:choose>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


    </body>
</html>