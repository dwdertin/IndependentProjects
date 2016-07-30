<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flooring Calculator</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Flooring Calculator</h1>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/luckyseven">Lucky Seven</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/factorizor">Factorizor</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/interestcalc">Interest Calculator</a></li>
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/converter">Unit Converter</a></li>
                </ul>    
            </div>
           
            <div>
                <h3>Your Results:</h3><br>
                <p>Length:</p> ${length}
                <p>Width:</p> ${width}
                <p>Cost Per Square Foot:</p> ${costPerSquareFoot}
                <p>Area:</p> ${area}
                <p>Material Cost:</p> ${materialCost}
                <p>Labor Cost:</p> ${laborCost}
                <p>Total Cost:</p> ${totalCost}
                <br>
                <a href="${pageContext.request.contextPath}/flooringcalc">Calculate Again</a>
        </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>