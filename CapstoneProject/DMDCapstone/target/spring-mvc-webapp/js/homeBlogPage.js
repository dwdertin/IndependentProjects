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

        var tagsArr = $('#edit-tags').val().split(",");
        var finalTags = [];
        $.each(tagsArr, function (index, tag) {
            finalTags.push($.trim(this));
        });
        $.ajax({
            type: 'PUT',
            url: 'editPost/' + $('#edit-post-id').val(),
            data: JSON.stringify({
                postId: $('#edit-post-id').val(),
                title: $('#edit-title').val(),
                contentBody: contentData,
                //contentBody: $('#edit-content-body').val(),
                //tags: $('#edit-tags').val(),
                tags: finalTags
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
            location.href = 'admin';
        });
    });

});

function loadPosts() {
    clearBlogArea();
    clearTagArea();
    clearHomeBlogArea();
    $.ajax({
        url: "displayPosts"
    }).success(function (data, status) {
        var sortedData =
                data.sort(function (a, b) {
                    return b.postID - a.postID;
                });


        fillHomeBlogArea(sortedData, status);
        fillTagArea(sortedData, status);
        fillAdminTagArea(sortedData, status);
        //approvalsNeeded(sortedData, status);
        fillBlogArea(sortedData, status);
    });
}

function clearBlogArea() {
    $('#content').empty();
    //$('#sidebar-wrapper').empty();
}

function loadPostsAfterSearch() {
    $.ajax({
        type: 'GET',
        url: "nevermind"
    }).success(function (data, status) {
        var sortedData =
                data.sort(function (a, b) {
                    return b.postID - a.postID;
                });
        //clearTagArea();
        clearSearchArea();
        clearHomeBlogArea();
        fillHomeBlogArea(sortedData, status);
        fillTagArea(sortedData, status);
        fillAdminTagArea(sortedData, status);
        //approvalsNeeded(sortedData, status);
        fillBlogArea(sortedData, status);
    });
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
                data.sort(function (a, b) {
                    return b.postID - a.postID;
                });
        //return data;

        clearBlogArea();
        fillBlogArea(sortedData, status);
        clearHomeBlogArea();
        fillHomeBlogArea(sortedData, status);
    });

    getTagsSearched();

}
function getTagsSearched() {
    $.ajax({
        type: 'GET',
        url: 'listOfTags'
    }).success(function (data, status) {
        fillSearchArea(data, status);
    });
}
function fillSearchArea(tagList) {
    clearSearchArea();
    var tagsSearched = $('#tagsSearched');
    tagsSearched.append($('<h4>').text('Search Terms'));
    $.each(tagList, function (index, tag) {
        if ($.inArray(tag, tagList) === -1)
            tagList.push(tag);
        tagsSearched
                .append($('<p>').append($('<a type="submit" class="glyphicon glyphicon-remove">')
                        .attr({'onClick': 'removeSearchTag("' + tag + '"); getTagsSearched();'}).text(' ' + tag)));
    });
}
function removeSearchTag(tag) {
    $.ajax({
        type: 'POST',
        url: 'nixTag/' + tag
    }).success(function (data, status) {
        var sortedData =
                data.sort(function (a, b) {
                    return b.postID - a.postID;
                });
        //return data;
        //fillSearchArea(sortedData, status);
        clearBlogArea();
        fillBlogArea(sortedData, status);
        clearHomeBlogArea();
        fillHomeBlogArea(sortedData, status);
        getTagsSearched();
    });


}
function clearSearchArea() {
    $('#tagsSearched').empty();
}


$('#add-button').click(function (event) {
    var contentData = CKEDITOR.instances.addContentBody.getData();
    event.preventDefault();
    //$('#validationErrors').empty();
    var tagsArr = $('#add-tags').val().split(",");
    var finalTags = [];
    $.each(tagsArr, function (index, tag) {
        finalTags.push($.trim(this));
    });
    $.ajax({
        type: 'POST',
        url: 'createPost',
        data: JSON.stringify({
            title: $('#add-title').val(),
            contentBody: contentData,
            //contentBody: $('#add-content-body').val(),
            tags: finalTags
                    //media: $('#add-media').val()

        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'html'
                // changed dataType because "??" was giving us a JQuery command
    }).success(function (data, status) {
        location.href = 'admin';
        $('#add-title').val('');
        $('#addContentBody').val('');
        $('#add-tags').val('');
//        $('#add-media').val('');
//        $('#add-date').val('');
        $('#validationErrors').empty();
        loadPosts();
        //return false;
    }).error(function (data, status) {
        event.preventDefault();
        $('#validationErrors').empty();

        $.each(data.responseJSON.fieldErrors, function (index, validationError) {
            var errorDiv = $('#validationErrors');
            errorDiv.append(validationError.message).append($('<br>'));
        });
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
        $('#editValidationErrors').empty();
        var last = post.tags[post.tags.length - 1];
        var moveMe = "";
        ($.each(post.tags, function (index, tag) {
            if (tag !== last) {
                moveMe += tag + ',';
            } else {
                moveMe += tag;
            }
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
    }).error(function (data, status) {
        event.preventDefault();

        $('#editValidationErrors').empty();
        $.each(data.responseJSON.fieldErrors, function (index, validationError) {
            var errorDiv = $('#editValidationErrors');
            errorDiv.append(validationError.message).append($('<br>'));
        });
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
    clearPostsToApprove();
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
    $.each(postList, function (index, post) {
        var moveMe = "";

        ($.each(post.tags, function (index, tag) {
            var insertTag = tag.replace("'", "\\'");
            var method = "onclick=\"searchPosts(\'" + insertTag + "\')\"";
            moveMe += '&nbsp &nbsp &nbsp<a type="submit"' + method + '>#' + tag + '</a>';
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
                                    .append($('<div align="right"><a href="toPost?postID=' + post.postID + '">' + "Link" + '</a></div>'))

                                    )));
        }
    });
}

function fillTagArea(postList, status) {
    var tagList = [];
    var publicPosts = [];
    var tagMap = {};

    $.each(postList, function (index, page) {

        if (page.isLive === true) {
            publicPosts.push(page);
        }
    });
    $.each(publicPosts, function (index, post) {

        $.each(post.tags, function (index, tag) {

            if ($.inArray(tag, tagList) === -1) {
                tagList.push(tag);
                tagMap[tag] = 1;
            } else {
                tagMap[tag]++;
                //tagMap[tag] = [occurs];
            }
        });

    });
    var sideBar = $('#sidebar-wrapper');
    sideBar.empty();
    sideBar.append($('<h4>').text('Browse Popular Tags'));
//        $.each(publicPosts, function (index, post){
//            $.each(post.tags, function (index, tag){
//                
//                if ($.inArray(tag, post.tags === true)){
//                    occurs++;
//                    tagMap[tag] = [tag, occurs];
//                }
//                
//            });
//            occurs = 0;
//        });

    $.each(tagList, function (index, tag) {
        sideBar.append($('<li style="list-style-type:none">')
                .append($('<a type="submit">')
                        .attr({
                            'onClick': 'searchPosts("' + tag + '")'
                        })
                        .text(tag + ' ').append($('<span class="badge">').text(tagMap[tag]))
                        )

                );
    }
    );
    sideBar.append($('<button class="btn btn-info" onclick="clearBlogArea(); clearHomeBlogArea(); loadPosts(); loadPostsAfterSearch()">Reset Search</button>')
            .append($('<ul class="sidebar-nav">')));
}

function fillAdminTagArea(postList, status) {
    var tagMap = {};
    var tagList = [];
    $.each(postList, function (index, post) {

        $.each(post.tags, function (index, tag) {

            if ($.inArray(tag, tagList) === -1) {
                tagList.push(tag);
                tagMap[tag] = 1;

            } else {
                tagMap[tag]++;
            }
        });
    });
    var sideBar = $('#sidebar-wrapper-admin');
    sideBar.empty();
    sideBar.append($('<h4>').text('Browse Popular Tags'));
    $.each(tagList, function (index, tag) {
        sideBar.append($('<li style="list-style-type:none">')
                .append($('<a type="submit">')
                        .attr({
                            'onClick': 'searchPosts("' + tag + '")'
                        })
                        .text(tag + ' ').append($('<span class="badge">').text(tagMap[tag]))
                        )

                );
    }
    );
    sideBar.append($('<button class="btn btn-info" onclick="clearBlogArea(); clearHomeBlogArea(); loadPosts(); loadPostsAfterSearch()">Reset Search</button>')
            .append($('<ul class="sidebar-nav">')));
}


function clearTagArea() {
    $('#sidebar-wrapper').empty();
}

function displayPostByID(ID) {
//event.preventDefault();
    $.ajax({
        type: 'GET',
        url: "getPost/" + ID
    }).success(function (data, status) {

        clearPostArea();
        fillPostArea(data);
    });
}

function fillPostArea(data) {
    clearPostArea();
    var post = $('#postPageContent');
    post.append($('<p>')
            .append(data.datePosted))
            .append($('<p>')
                    .append(data.title))
            .append($('<p>')
                    .append(data.contentBody));
}

function clearPostArea() {
    $('#staticPageContent').empty();
}
