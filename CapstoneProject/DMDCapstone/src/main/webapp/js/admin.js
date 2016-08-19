/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function clearPostsToApprove(){
    $('#postsToApprove').empty();
}
function fillBlogArea(postList, status) {
    clearBlogArea();
    clearPostsToApprove();
    var blogPost = $('#content');
    var tagList = $('#tagArea');
    var approvalArea = $('#postsToApprove');
    var toApprove = 0;
    $.each(postList, function (index, post) {

        var moveMe = "";
        ($.each(post.tags, function (index, tag) {
            var insertTag = tag.replace("'", "\\'");
            moveMe += '&nbsp &nbsp &nbsp<a type="submit" onclick=searchPosts("' + insertTag + '")>#' + tag.trim() + '</a>';
        }));
        if (post.isLive === false){
          toApprove++;
        }
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
                                //.append($('<sec:authorize access="hasRole(\'ROLE_ADMIN\')">')
                                .append($('<button type="submit" class="btn btn-info">')
                                        .attr({
                                            'onClick': 'deletePost(' + post.postID + ')'
                                        })
                                        .text('Delete')

                                        ))
                        //.append($('<sec:authorize access="hasRole(\'ROLE_ADMIN\')">')
                        .append($('<button type="submit" class="btn btn-info">')
                                .attr({
                                    'onClick': 'approvePost(' + post.postID + ')'
                                })
                                .text('Toggle:Live')

                                )
                        )
                );
    });
    //approvalArea.append($('<h4>').text('Posts Pending Approval: ' + toApprove));
    approvalArea.append($('<h4>').text('Posts Pending Approval: ').append($('<span class="badge">').text(toApprove)));
}

function createTable(PageList, status) {
    clearPageTable();
    var sTable = $('#contentRows');
    $.each(PageList, function (index, page) {
        sTable.append($('<tr>')
                .append($('<td>')
                        .text(page.statTitle))
                .append($('<td>')
                        .text(page.isLive))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'approvePage(' + page.pageID + ')'
                                })
                                .text('Public/Private')))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-page-id': page.pageID,
                                    'data-toggle': 'modal',
                                    'data-target': '#editPageModal'
                                })
                                .text('Edit')))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deletePage(' + page.pageID + ')'
                                })
                                .text('Delete'))));

    });
}

