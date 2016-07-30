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
        <script type="text/javascript">

            function hideSelectDivs() {
                document.getElementById("divWeight").style.display = "none";
                document.getElementById("divTemperature").style.display = "none";
            }

            function openDiv() {

                var input = document.getElementById("startingType").value;

                switch (input) {
                    case "Weight":
                        document.getElementById("divWeight").style.display = "block";
                        document.getElementById("divTemperature").style.display = "none";
                        break;
                    case "Temperature":
                        document.getElementById("divTemperature").style.display = "block";
                        document.getElementById("divWeight").style.display = "none";
                        break;
                    default:
                        break;
                }
                return false;
            }
        </script>
    </head>
    <body onload="hideSelectDivs()">
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

            <h3>Enter the value type you would like to convert</h3>
            <select id="startingType" name=startingType>
                <option value="Weight" id=Weight>Weight</option>
                <option value="Temperature" id=Temperature>Temperature</option>
            </select>
            <button onclick="return openDiv();">Submit</button>
            <br>
            <br>
            <br>
            <br>
            <br>

            <div class="Temperature" id="divTemperature">       
                <FORM METHOD=POST action="convertTemp" class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-md-3">
                            Enter the Starting type to convert from:
                        </label>

                        <div class="col-md-3">
                            <select name="tempStartingType">
                                <option value="Fahrenheit">Fahrenheit</option>
                                <option value="Celsius">Celsius</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3">
                            Enter the starting temperature: 
                        </label>
                        <div class="col-md-3">
                            <INPUT TYPE="number" NAME="userInput" value="0">
                            <P><INPUT TYPE=SUBMIT>
                        </div>
                    </div>

                </FORM> 
            </div>

            <div class="Weight" id="divWeight">  
                <FORM METHOD=POST action="convertWeight" class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-md-3">
                            Enter the starting type to convert from:
                        </label>

                        <div class="col-md-3">
                            <select name="weightStartingType">
                                <option value="Pounds">Pounds</option>
                                <option value="Kilograms">Kilograms</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">
                            Enter the starting weight: 
                        </label>
                        <div class="col-md-3">
                            <INPUT TYPE="number" NAME="weightUserInput" value="0">
                            <INPUT TYPE=SUBMIT>
                        </div>
                    </div>
                </FORM> 
            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>