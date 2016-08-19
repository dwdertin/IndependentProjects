/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dmdcapstone.dao;

import com.mycompany.dmdcapstone.model.Post;
import com.mycompany.dmdcapstone.model.StaticPage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class PostDaoInMemoryImpl implements PostDao {
    private static int postIDcounter = 0;
    private Map<Integer, Post> postMap = new HashMap<>();
    
   
    @Override
    public List<Post> displayPosts() {
        Collection<Post> p = postMap.values();
        return new ArrayList<>(p);
    }

    @Override
    public Post addPost(Post post) {
        post.setPostID(postIDcounter);
        postIDcounter++;
        post.setDatePosted(LocalDate.now());
        postMap.put(post.getPostID(), post);
        return post;
    }

    @Override
    public void editPost(Post post) {
        postMap.put(post.getPostID(), post);
    }

    @Override
    public void deletePost(int postID) {
        postMap.remove(postID);
    }

    @Override
    public List<Post> searchPosts(Map<SearchTerm, String> criteria) {
       String tagCriteria = criteria.get(SearchTerm.TAG);
       
       Predicate<Post> tagMatches;
       
       Predicate<Post> truePredicate = (p) -> {
           return true;
       };
       
       tagMatches = (tagCriteria == null || tagCriteria.isEmpty())
               ? truePredicate
               : (p) -> p.getTags().contains(tagCriteria);
       
       return postMap.values().stream()
               .filter(tagMatches)
               .collect(Collectors.toList());
      
    }
    
    //forgot about these InMem

    @Override
    public void approvePosts(int postID) {
        Post p = postMap.get(postID);
        p.setIsLive(true);
    }

    @Override
    public Post displayPostByID(int postID) {
        return postMap.get(postID);
    }

    @Override
    public List<Post> searchByTag(String tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StaticPage> displayPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StaticPage addPage(StaticPage page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editPage(StaticPage page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePage(int pageID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void approvePage(int pageID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StaticPage displayPageByID(int pageID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
