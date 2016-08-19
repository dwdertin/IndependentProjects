/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    loadPosts();

    $('#edit-button').click(function (event) {
        var contentData = CKEDITOR.instances.editContentBody.getData();
        event.preventDefault();

        $.ajax({
            type: 'PUT',
            url: 'editPost/' + $('#edit-post-id').val(),
            data: JSON.stringify({
                postId: $('#edit-post-id').val(),
                title: $('#edit-title').val(),
                contentBody: contentData,
                //contentBody: $('#edit-content-body').val(),
                //tags: $('#edit-tags').val(),
                tags: $('#edit-tags').val().split(" ")
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
            loadPosts();
        });
    });

});

function loadPosts() {
    clearBlogArea();

    $.ajax({
        url: "displayPosts"
    }).success(function (data, status) {
        var sortedData = 
        data.sort(function(a, b){
            return b.postID - a.postID;
        });
    
        fillBlogArea(sortedData, status);
        fillHomeBlogArea(sortedData, status);
        fillTagArea(sortedData, status);
        approvalsNeeded(sortedData, status);
    });
}

function clearBlogArea() {
    $('#content').empty();
    //$('#sidebar-wrapper').empty();
}

function clearHomeBlogArea() {
    $('#homeContent').empty();
}


function searchPosts(tag) {

    $.ajax({
        type: 'POST',
        url: 'search/' + tag
    }).success(function (data, status) {
        var sortedData =  
        data.sort(function(a, b){
            return b.postID - a.postID;
        });
        //return data;
        clearBlogArea();
        fillBlogArea(sortedData, status);
        clearHomeBlogArea();
        fillHomeBlogArea(sortedData, status);
    });
}

//
//function searchPosts(tag) {
//    
//    $.ajax({
//        type: 'POST',
//        url: 'search/' + tag
//    }).success(function (data, status){
//        return data;
//    });
//
//
//// on click for our add button
//
//$('#searchByTags').click(function (event){
//    event.preventDefault();
//    //searchPosts($('#searchTag'));
//    $.ajax({
//        type: 'POST',
//        url: 'search/' + $('#searchTag').val()
//    }).success(function (data, status){
//        clearBlogArea();
//        fillBlogArea(data, status);
//    });
//   
//});
//}

$('#add-button').click(function (event) {
    var contentData = CKEDITOR.instances.addContentBody.getData();
    event.preventDefault();
    //$('#validationErrors').empty();

    $.ajax({
        type: 'POST',
        url: 'createPost',
        data: JSON.stringify({
            title: $('#add-title').val(),
            contentBody: contentData,
            //contentBody: $('#add-content-body').val(),
            tags: $('#add-tags').val().split(" ")
                    //media: $('#add-media').val()

        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'html'
                // changed dataType because "??" was giving us a JQuery command
    }).success(function (data, status) {

        $('#add-title').val('');
        $('#addContentBody').val('');
        $('#add-tags').val('');
//        $('#add-media').val('');
//        $('#add-date').val('');
//        $('#validationErrors').empty();
        loadPosts();
        //return false;
//    }).error(function (data, status) {
//
//        $.each(data.responseJSON.fieldErrors, function (index, validationError) {
//            var errorDiv = $('#validationErrors');
//            errorDiv.append(validationError.message).append($('<br>'));
//        });
    });
});
$('#editModal').on('show.bs.modal', function (event) {
    //var contentData = CKEDITOR.instances.editContentBody.getData();

    var element = $(event.relatedTarget);
    var postID = element.data('post-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'post/' + postID
    }).success(function (post) {

        var moveMe = "";
        ($.each(post.tags, function (index, tag) {
            moveMe += tag + '  ';
        }));

//modal.find('#post-id').text(post.postID);
        modal.find('#edit-post-id').val(post.postID);
        modal.find('#edit-title').val(post.title);
        modal.find('#editContentBody').val(post.contentBody);
        modal.find('#edit-tags').val(moveMe);
        CKEDITOR.instances['editContentBody'].setData(post.contentBody);
//        modal.find('#edit-date-posted').val(post.datePosted);
//        modal.find('#edit-media').val(post.media);
//        modal.find('#edit-is-live').val(post.isLive);
    });
});
$('#add-modal-button').click(function (event) {
    $('#addModal').modal('show');
});
function deletePost(id) {
    var answer = confirm("Do you really want to delete this post?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'post/' + id
        }).success(function () {
            loadPosts();
        });
    }
}

function PostById(id) {
    $.ajax({
        type: 'GET',
        url: 'post/' + id
    }).success(function (data, status) {
        return data.isLive;
    });

}
function approvePost(id) {

    $.ajax({
        type: 'GET',
        url: 'post/' + id
    }).success(function (data, status) {

        if (data.isLive === true) {
            var answer = confirm("Do you really want to take down this post?");
            if (answer === true) {
                $.ajax({
                    type: 'PUT',
                    url: 'approvePost/' + id
                }).success(function () {
                    loadPosts();
                });
            }
        } else if (data.isLive === false) {
            var answer = confirm("Do you really want to publish this post?");
            if (answer === true) {
                $.ajax({
                    type: 'PUT',
                    url: 'approvePost/' + id
                }).success(function () {
                    loadPosts();
                });
            }
        }

    });
}


function fillHomeBlogArea(postList, status) {

    var homeBlogPost = $('#homeContent');
    var tagList = $('#tagArea');
    $.each(postList, function (index, post) {
        var moveMe = "";
        ($.each(post.tags, function (index, tag) {
            moveMe += '<a type="submit" onclick=searchPosts("' + tag + '")>' + tag + '</a>' + ' ';
        }));

        if (post.isLive === true) {
            homeBlogPost.append($('<div class="well">')
                    .append($('<h3>').text(post.title + ' ' + post.formattedDate))
                    .append($('<br>'))
                    .append($('<br>'))
                    .append($('<p>')
                            .append(post.contentBody)
                            .append($('<br>'))
                            .append($('<br>'))
                            .append($('<p id="tagArea">')
                                    .append(moveMe)
                                    .append($('<br>'))

                                    )));
        }
    });
}

function fillTagArea(postList, status) {

    var sideBar = $('#sidebar-wrapper');
    sideBar.append($('<div id="sidebar-wrapper">')
            .append($('<ul class="sidebar-nav">'),
                    $.each(postList, function (index, post) {
                        $.each(post.tags, function (index, tag) {
                            sideBar.append($('<li>')
                                    .append($('<a type="submit">')
                                            .attr({
                                                'onClick': 'searchPosts("' + tag + '")'
                                            })
                                            .text(tag)
                                            )
                                    //.text(tag)
                                    );
                        }
                        );
                    }
                    )));
}

function fillBlogArea(postList, status) {
    clearBlogArea();

    var blogPost = $('#content');
    var tagList = $('#tagArea');
    $.each(postList, function (index, post) {

        var moveMe = "";
        ($.each(post.tags, function (index, tag) {
            moveMe += '<a type="submit" onclick=searchPosts("' + tag + '")>' + tag + '</a>' + ' ';
        }));

        blogPost.append($('<div class="well">')
                .append($('<h3>')
                        .text(post.title + ' (Currently Live? ' + post.isLive + ') ' + post.formattedDate))

                .append($('<br>'))

                .append($('<br>'))
                .append($('<p>')
                        .append(post.contentBody)
                        .append($('<br>'))
                        .append($('<br>'))
                        .append($('<p id="tagArea">')
                                .append(moveMe)

                                //.text(post.tags)
                                .append($('<br>'))
                                .append($('<br>'))
                                .append($('<button type="submit" class="btn btn-info">')
                                        .attr({
                                            'data-post-id': post.postID,
                                            'data-toggle': 'modal',
                                            'data-target': '#editModal'
                                        })
                                        .text('Edit')
                                        )

                                .append($('<button type="submit" class="btn btn-info">')
                                        .attr({
                                            'onClick': 'deletePost(' + post.postID + ')'
                                        })
                                        .text('Delete')

                                        )
                                .append($('<button type="submit" class="btn btn-info">')
                                        .attr({
                                            'onClick': 'approvePost(' + post.postID + ')'
                                        })
                                        .text('Toggle:Live')

                                        )
                                ))
                );
    });
}
