/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dmdcapstone.dao;

import com.mycompany.dmdcapstone.model.Post;
import com.mycompany.dmdcapstone.model.StaticPage;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class PostDaoInDbImpl implements PostDao {

    private static final String SQL_INSERT_POST
            = "insert into Posts (Title, ContentBody, Media, `Date`, IsLive) values (?, ?, ?, ?, ?)";
    private static final String SQL_INSERT_TAGS
            = "insert into PostTags (TagName, PostID) values (?,?)";
    private static final String SQL_POPULATE_TAGS
            = "insert  into Tags (TagName) values (?) on duplicate key update TagName=values(TagName)";
    private static final String SQL_DELETE_POST
            = "delete from Posts where PostID = ?";
    private static final String SQL_DELETE_TAGS
            = "delete from PostTags where PostID = ?";
    private static final String SQL_SELECT_POST
            = "select * from Posts where PostID = ?";
    private static final String SQL_SELECT_TAGS
            = "select TagName from PostTags where PostID = ?";
    private static final String SQL_UPDATE_POST
            = "update Posts set Title = ?, ContentBody = ?, Media = ?, isLive = ? where PostID = ?";
    private static final String SQL_TOGGLE_APPROVE
            = "update Posts set isLive = ? where PostID = ?";
    private static final String SQL_SELECT_ALL_POSTS
            = "select * from Posts";
    private static final String SQL_SEARCH_TAGS
            = "select * from Posts join PostTags using(PostID) where TagName = ?";
    
    //static SQL statements
    
    private static final String SQL_INSERT_PAGE
            = "instert into StaticPages (Title, ContentBody, IsLive) values (?, ?, ?)";
    private static final String SQL_DELETE_PAGE
            = "delete from StaticPages where PageID = ?";
    private static final String SQL_UPDATE_PAGE
            = "update StaticPages set Title = ?, ContentBody = ?";
    private static final String SQL_SELECT_PAGE
            ="select Title, ContentBody, IsLive from StaticPages where PageID = ?";
    private static final String SQL_SELECT_ALL_PAGES
            ="select * from StaticPages";
    private static final String SQL_APPROVE_PAGE
            = "update StaticPages set IsLive where PageID = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> displayPosts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_POSTS, new PostMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post addPost(Post post) {
        post.setDatePosted(LocalDate.now());
        jdbcTemplate.update(SQL_INSERT_POST,
                post.getTitle(),
                post.getContentBody(),
                post.getMedia(),
                Date.valueOf(post.getDatePosted()),
                post.getIsLive());
        post.setPostID(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));

        for (String tag : post.getTags()) {
            jdbcTemplate.update(SQL_INSERT_TAGS,
                    tag,
                    post.getPostID());
        };
        for (String tag : post.getTags()) {
            jdbcTemplate.update(SQL_POPULATE_TAGS,
                    tag);
        };

        // used to be here: post.setPostID(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return post;
    }

    @Override
    public void editPost(Post post) {
//        post.setDatePosted(LocalDate.now());
        jdbcTemplate.update(SQL_UPDATE_POST,
                post.getTitle(),
                post.getContentBody(),
                post.getMedia(),
//                Date.valueOf(post.getDatePosted()),
                post.getIsLive(),
                post.getPostID());
        jdbcTemplate.update(SQL_DELETE_TAGS, post.getPostID());
        for (String tag : post.getTags()) {
            jdbcTemplate.update(SQL_INSERT_TAGS,
                    tag,
                    post.getPostID());
        };
    }

    @Override
    public void deletePost(int postID) {
        jdbcTemplate.update(SQL_DELETE_POST, postID);

    }

    @Override
    public List<Post> searchPosts(Map<SearchTerm, String> criteria) {
        try {
            return jdbcTemplate.query(SQL_SEARCH_TAGS,
                    new PostMapper(), criteria);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given id - we just want to
            // return null in this case
            return null;
        }    }

    @Override
    public List<Post> searchByTag(String tag) {
         try {
            return jdbcTemplate.query(SQL_SEARCH_TAGS,
                    new PostMapper(), tag);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given id - we just want to
            // return null in this case
            return displayPosts();
        } 
    }
    
    @Override
    public void approvePosts(int postID) {
        Post thisPost = jdbcTemplate.queryForObject(SQL_SELECT_POST,
                new PostMapper(), postID);
        if (thisPost.getIsLive() == false) {
            jdbcTemplate.update(SQL_TOGGLE_APPROVE,
                    true,
                    postID
            );
        } else if (thisPost.getIsLive() == true) {
            jdbcTemplate.update(SQL_TOGGLE_APPROVE,
                    false,
                    postID
            );
        }

    }

    @Override
    public Post displayPostByID(int postID) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POST,
                    new PostMapper(), postID);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given id - we just want to
            // return null in this case
            return null;
        }
    }

    public Set thisPostTags(int postID) {
        List<String> tags = jdbcTemplate.query(SQL_SELECT_TAGS, new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("TagName");
            }
        }, postID);
        Set<String> ownTags = new HashSet<String>(tags);
        return ownTags;
    }
    
    //Static Page Database stuff

    @Override
    public List<StaticPage> displayPage() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PAGES, new PageMapper());
    }

    @Override
    public StaticPage addPage(StaticPage page) {
        jdbcTemplate.update(SQL_INSERT_PAGE,
                page.getStatTitle(),
                page.getStatBody(),
                page.getIsLive());
        page.setPageID(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return page;
    }

    @Override
    public void editPage(StaticPage page) {
        jdbcTemplate.update(SQL_UPDATE_PAGE,
                page.getStatTitle(),
                page.getStatBody(),
                page.getIsLive());
    }

    @Override
    public void deletePage(int pageID) {
        jdbcTemplate.update(SQL_DELETE_PAGE, pageID);
    }

    @Override
    public void approvePage(int pageID) {
        StaticPage thisPage = jdbcTemplate.queryForObject(SQL_SELECT_PAGE,
                new PageMapper(), pageID);
        if (thisPage.getIsLive() == false) {
            jdbcTemplate.update(SQL_TOGGLE_APPROVE,
                    true,
                    pageID
            );
        } else if (thisPage.getIsLive() == true) {
            jdbcTemplate.update(SQL_TOGGLE_APPROVE,
                    false,
                    pageID
            );
        }
    }

    @Override
    public StaticPage displayPageByID(int pageID) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PAGE,
                    new PageMapper(), pageID);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given id - we just want to
            // return null in this case
            return null;
        }
    }

   

    private final class PostMapper implements RowMapper<Post> {

//        PostDaoInDbImpl a = new PostDaoInDbImpl();
        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setPostID(rs.getInt("postID"));
            post.setTitle(rs.getString("title"));
            post.setDatePosted(rs.getDate("date").toLocalDate());
            post.setContentBody(rs.getString("ContentBody"));
            post.setMedia(rs.getString("Media"));
            post.setIsLive(rs.getBoolean("IsLive"));
            post.setTags(thisPostTags(post.getPostID()));

            return post;
        }
    }
    
    private final class PageMapper implements RowMapper<StaticPage> {

//        PostDaoInDbImpl a = new PostDaoInDbImpl();
        @Override
        public StaticPage mapRow(ResultSet rs, int rowNum) throws SQLException {
            StaticPage page = new StaticPage();
            page.setPageID(rs.getInt("pageID"));
            page.setStatTitle(rs.getString("title"));
            page.setStatBody(rs.getString("contentBody"));
            page.setIsLive(rs.getBoolean("IsLive"));

            return page;
        }
    }

//    private static final class TagMapper implements RowMapper<List> {
//
//        public List mapRow(ResultSet rs, int rowNum) throws SQLException {
//            List fightme = Arrays.asList(rs.getArray("TagName"));
//            
//       
//            return fightme;
//        }
//    }
}
