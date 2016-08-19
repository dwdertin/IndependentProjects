/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    loadPages();
    
    $(window).scroll(function () {
      //if you hard code, then use console
      //.log to determine when you want the 
      //nav bar to stick.  
      console.log($(window).scrollTop());
    if ($(window).scrollTop() > 100) {
      $('#awesome').addClass('sticky');
    }
    if ($(window).scrollTop() < 99) {
      $('#awesome').removeClass('sticky');
    }
  });


    $('#edit-static-button').click(function (event) {
        var contentData = CKEDITOR.instances.editStaticBody.getData();
        event.preventDefault();

        $.ajax({
            type: 'PUT',
            url: 'editPage/' + $('#edit-page-id').val(),
            data: JSON.stringify({
                pageID: $('#edit-page-id').val(),
                statTitle: $('#edit-static-title').val(),
                statBody: contentData
                        //contentBody: $('#edit-content-body').val(),
                        //tags: $('#edit-tags').val(),

//                datePosted: $('#edit-date-posted').val(),
//                media: $('#edit-media').val(),
//                isLive: $('#edit-is-live').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'html'
                    // changed dataType because "??" was giving us a JQuery command
        }).success(function () {
            loadPages();
        });
    });

});

$('#add-page-button').click(function (event) {
    var contentData = CKEDITOR.instances.addStatBody.getData();
    event.preventDefault();
    //$('#validationErrors').empty();

    $.ajax({
        type: 'POST',
        url: 'createPage',
        data: JSON.stringify({
            statTitle: $('#add-stat-title').val(),
            statBody: contentData
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'html'
                // changed dataType because "??" was giving us a JQuery command
    }).success(function (data, status) {

        $('#add-stat-title').val('');
        $('#addStatBody').val('');
        loadPages();
        //return false;
//    }).error(function (data, status) {
//
//        $.each(data.responseJSON.fieldErrors, function (index, validationError) {
//            var errorDiv = $('#validationErrors');
//            errorDiv.append(validationError.message).append($('<br>'));
//        });
    });
});

function loadPages() {
    clearPageTable();
    clearPageArea();
    clearNavArea();

    $.ajax({
        url: "displayPages"
    }).success(function (data, status) {

        loadNavBar(data, status);
        //loadUserNavBar(data, status);
        //approvalsNeeded(sortedData, status);
        createTable(data, status);
        //displayPageByID(loadID);
    });
}

function approvePage(id) {

    $.ajax({
        type: 'GET',
        url: 'page/' + id
    }).success(function (data, status) {

        if (data.isLive === true) {
            var answer = confirm("Do you really want make this private?");
            if (answer === true) {
                $.ajax({
                    type: 'PUT',
                    url: 'approvePage/' + id
                }).success(function () {
                    loadPages();
                });
            }
        } else if (data.isLive === false) {
            var answer = confirm("Do you really want make this public?");
            if (answer === true) {
                $.ajax({
                    type: 'PUT',
                    url: 'approvePage/' + id
                }).success(function () {
                    loadPages();
                });
            }
        }

    });
}

function deletePage(id) {
    var answer = confirm("Do you really want to delete this static page?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'page/' + id
        }).success(function () {
            loadPages();
        });
    }
}
//function changeNav(pageList, status) {
//    var tabs = $('#navi');
//    $.each(pageList, function (index, page) {
//        $('#tabby').change(function () {
//            $(this).find("ul").each(function () {
//
//                tabs.append($('<li role="presentation">')
//                        .append($('<a>')
//                    .attr({
//                            'data-page-id': page.pageID,
//                            'onClick': 'displayPageByID(' + page.pageID + ')'
//                        })));
//            });
//        });
//    });
//}



function loadNavBar(pageList, status) {
    var nav = $('#dynamicNav');
    var bar = $('<div class="navbar" id="awesome">');
    var tab = $('<ul class="nav nav-tabs">');
    var publicPages = [];

    $.each(pageList, function (index, page) {
        if (page.isLive === true) {
            publicPages.push(page);
        }
    });
    nav.append(bar
            .append(tab
                    .append($('<li role="presentation">')
                            .append($('<a href="home">Home</a>'))),
//
//                    .append($('<li role="presentation">')
//                            .append($('<a href="admin">Admin</a>'))),
                    $.each(publicPages, function (index, page) {
                        tab.append($('<li role="presentation">')
                                .append($('<a href="toStatic?pageID=' + page.pageID + '">' + page.statTitle + '</a>')));
                        //.append($('<a href="static" onclick="displayPageByID(' + page.pageID + ')">' + page.statTitle + '</a>')));
                    })
                    ));
}

//function loadNavBar(pageList, status) {
//    var nav = $('#dynamicNav');
//    
//    var bar = $('<div class="navbar">');
//    var tab = $('<ul class="nav nav-tabs">');
//    var publicPages = [];
//    
//    $.each(pageList, function (index, page) {
//        if (page.isLive === true) {
//            publicPages.push(page);
//        }
//    });
//    nav.append(bar
//            .append(tab
//                    .append($('<li role="presentation">')
//                            .append($('<a href="home">Home</a>')))
//
//                    .append($('<li role="presentation">')
//                            .append($('<a href="admin">Admin</a>'))),
//                    $.each(publicPages, function (index, page) {
//                        tab.append($('<li role="presentation">')
//                        .append($('<a href="toStatic?pageID=' + page.pageID+ '">' + page.statTitle + '</a>')));
//                               //.append($('<a href="static" onclick="displayPageByID(' + page.pageID + ')">' + page.statTitle + '</a>')));
//                    })
//                    ));
//}
$('#add-modal-page-button').click(function (event) {
    $('#addPageModal').modal('show');
});

function displayPageByID(ID) {
    //event.preventDefault();
    $.ajax({
        type: 'GET',
        url: "page/" + ID
    }).success(function (data, status) {

        clearPageArea();
        fillStaticPageArea(data);

    });
}

function fillStaticPageArea(data) {
    clearPageArea();
    var page = $('#staticPageContent');
    page.append($('<p>')
            .append(data.statTitle))
            .append($('<p>')
                    .append(data.statBody));
}
//
//function createTable(PageList, status) {
//    clearPageTable();
//    var sTable = $('#contentRows');
//    $.each(PageList, function (index, page) {
//        sTable.append($('<tr>')
//                .append($('<td>')
//                        .text(page.statTitle))
//                .append($('<td>')
//                        .text(page.isLive))
//                .append($('<td>')
//                        .append($('<a>')
//                                .attr({
//                                    'onClick': 'approvePage(' + page.pageID + ')'
//                                })
//                                .text('Public/Private')))
//                .append($('<td>')
//                        .append($('<a>')
//                                .attr({
//                                    'data-page-id': page.pageID,
//                                    'data-toggle': 'modal',
//                                    'data-target': '#editPageModal'
//                                })
//                                .text('Edit')))
//                .append($('<td>')
//                        .append($('<a>')
//                                .attr({
//                                    'onClick': 'deletePage(' + page.pageID + ')'
//                                })
//                                .text('Delete'))));
//
//    });
//}

$('#editPageModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var pageID = element.data('page-id'); //giving correct ID
    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: 'page/' + pageID
    }).success(function (editPage) {
        modal.find('#edit-page-id').val(editPage.pageID);
        modal.find('#edit-static-title').val(editPage.statTitle);
        modal.find('#editStaticBody').val(editPage.statBody);
        CKEDITOR.instances['editStaticBody'].setData(editPage.statBody);
    });
});

function clearPageTable() {
    $('#contentRows').empty();
}

function clearPageArea() {
    $('#staticPageContent').empty();
}

function clearNavArea() {
    $('#dynamicNav').empty();
}

//function clearNavArea() {
//    $('#content').empty();
//$('#sidebar-wrapper').empty();
//}
