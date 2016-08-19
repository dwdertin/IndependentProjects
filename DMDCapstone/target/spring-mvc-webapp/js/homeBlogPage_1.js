/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    loadPosts();

    $('#edit-button').click(function (event) {

        event.preventDefault();

        $.ajax({
            type: 'PUT',
            url: 'editPost/' + $('#edit-post-id').val(),
            data: JSON.stringify({
                postId: $('#edit-post-id').val(),
                title: $('#edit-title').val(),
                contentBody: $('#edit-content-body').val(),
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
            'dataType': 'json'
        }).success(function () {
            loadPosts();
        });
    });

});

function fillBlogArea(postList, status) {
    clearBlogArea();

    var blogPost = $('#content');

    $.each(postList, function (index, post) {

        blogPost.append($('<div class="well">')
                .append($('<p>').text(post.title)
                
                        .append($('<br>'))
                        .append($('<br>'))
                        .append($('<p>')
                                .text(post.contentBody)
                                .append($('<br>'))
                                .append($('<br>'))
                                .append($('<p>')
                                        .text(post.tags)
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
                                        )))                                                         
                );
    });
}

function loadPosts() {
    clearBlogArea();

    $.ajax({
        url: "displayPosts"
    }).success(function (data, status) {
        fillBlogArea(data, status);
        fillHomeBlogArea(data, status);
        fillTagArea(data, status);
    });
}

function clearBlogArea() {
    $('#content').empty();
    $('#sidebar-wrapper').empty();
}



//function fillTagArea(postList, status) {
//
//    var sideBar = $('#sidebar-wrapper');
//    sideBar.append($('<div id="sidebar-wrapper">')
//            .append($('<ul class="sidebar-nav">'),
//                    $.each(postList, function (index, post) {
//                        $.each(post.tags, function (index, tag) {
//                            sideBar.append($('<li><a>')
//                                    .text(tag)
//                                    );)
//                        }
//                        );
//                    }
//                    )));
//}

// on click for our add button
$('#add-button').click(function (event) {

    event.preventDefault();
    //$('#validationErrors').empty();

    $.ajax({
        type: 'POST',
        url: 'createPost',
        data: JSON.stringify({
            title: $('#add-title').val(),
            contentBody: $('#add-content-body').val(),
            tags: $('#add-tags').val().split(" ")
                    //media: $('#add-media').val()

        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {

        $('#add-title').val('');
        $('#add-content-body').val('');
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

    var element = $(event.relatedTarget);
    var postID = element.data('post-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'post/' + postID
    }).success(function (post) {
//modal.find('#post-id').text(post.postID);
        modal.find('#edit-post-id').val(post.postID);
        modal.find('#edit-title').val(post.title);
        modal.find('#edit-content-body').val(post.contentBody);
        modal.find('#edit-tags').val(post.tags);
//        modal.find('#edit-date-posted').val(post.datePosted);
//        modal.find('#edit-media').val(post.media);
//        modal.find('#edit-is-live').val(post.isLive);
    });
});
$('#add-modal-button').click(function (event) {
    $('#addModal').modal('show')
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

function fillHomeBlogArea(postList, status) {

    var homeBlogPost = $('#homeContent');
    $.each(postList, function (index, post) {
        homeBlogPost.append($('<div class="well">')
                .append($('<p>').text(post.title)
                        .append($('<br>'))
                        .append($('<br>'))
                        .append($('<p>')
                                .text(post.contentBody)
                                .append($('<br>'))
                                .append($('<br>'))
                                .append($('<p>')
                                        .text(post.tags)
                                        .append($('<br>'))

                                        ))));
    });
}

function fillTagArea(postList, status) {

    var sideBar = $('#sidebar-wrapper');
    sideBar.append($('<div id="sidebar-wrapper">')
            .append($('<ul class="sidebar-nav">'),
                    $.each(postList, function (index, post) {
                        $.each(post.tags, function (index, tag) {
                            sideBar.append($('<li><a>')
                                    .text(tag)
                                    );
                        }
                        );
                    }
                    )));
}





//function fillBlogArea(postList, status) {
//    clearBlogArea();
//    var blogPost = $('#content');
//    $.each(postList, function (index, post) {
//        
//        blogPost.append($('<div class="well">')
//                .append($('<h2>').text(post.title))
//                .append($('<br>'))
//                .append($('<br>'))
//                .append($('<h3>')
//                        .text(post.contentBody))
//                .append($('<br>'))
//                .append($('<br>')
//                .text(post.tags))
//                //.each(post.tags, function (index, tag) {
//                //    text((tag + ' ' + tag))
//
//                //})
//                        )
//
//
//                .append($('<br>'))
//                .append($('<br>'))
//                .append($('<button type="submit" class="btn btn-info">')
//                        .attr({
//                            'data-post-id': post.postID,
//                            'data-toggle': 'modal',
//                            'data-target': '#editModal'
//                        })
//                        .text('Edit')
//                        )
//
//                .append($('<button type="submit" class="btn btn-info">')
//                        .attr({
//                            'onClick': 'deletePost(' + post.postID + ')'
//                        })
//                        .text('Delete')
//
//                        )
//    });
//}