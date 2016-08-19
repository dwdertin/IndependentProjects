/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
                                )
                        )
                );
    });
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
                                    'data-page-id': page.pageID,
                                    'data-toggle': 'modal',
                                    'data-target': '#editPageModal'
                                })
                                .text('Edit'))));
    });
}
