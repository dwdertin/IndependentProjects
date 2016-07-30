/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// #1: document ready
$(document).ready(function () {
    drawChart();
});
//// #2: draw the bar chart
//function drawChart() {
//    // #3: dummy data - will be replaced with Ajax call
//    var data = google.visualization.arrayToDataTable([
//        ['Company', '# Contacts'],
//        ['Oracle', 10],
//        ['Apple', 11],
//        ['Microsoft', 6],
//        ['SWC Guild', 18]
//    ]);
//    // #4: this sets up the size of the chart, the main title, and the axis titles
//    var options = {
//        title: 'Contacts By Company',
//        vAxis: {title: 'Company', titleTextStyle: {color: 'red'}},
//        hAxis: {title: 'Num Contacts', titleTextStyle: {color: 'red'}},
//        'width': 500,
//        'height': 400
//    };
//    // #5: create a new BarChart object, handing it the div into which we want it to render
//    var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
//    // #6: tell the chart to draw itself
//    chart.draw(data, options);
//}
//;

//need a DTO to coordinate with my dataList json, write queries to return an aggregate result 
//of what I want to display
function drawChart() {
    
    
    var Rcall = ($.ajax({
        url: "ratedR"
    }).success(function (data, status) {
       return window.alert(data.size);
    }));
    
    // #3: dummy data - will be replaced with Ajax call
    var data = google.visualization.arrayToDataTable([
        ['Rating', '# DVD'],
        ['R', 4],
        ['PG-13', 3],
        ['PG', 2],
        ['G', 1]
    ]);
    // #4: this sets up the size of the chart, the main title, and the axis titles
    var options = {
        title: 'DVDs By Rating',
        vAxis: {title: 'Rating', titleTextStyle: {color: 'red'}},
        hAxis: {title: 'Number of DVDs', titleTextStyle: {color: 'red'}},
        'width': 500,
        'height': 400
    };
    // #5: create a new BarChart object, handing it the div into which we want it to render
    var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
    // #6: tell the chart to draw itself
    chart.draw(data, options);
}
