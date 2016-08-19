/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dmdcapstone.dao;

import com.mycompany.dmdcapstone.model.Post;
import com.mycompany.dmdcapstone.model.StaticPage;
import com.mycompany.dmdcapstone.model.Tag;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public interface PostDao {
    
    public List<Post> displayPosts();
    
    public Post addPost(Post post);
    
    public void editPost(Post post);
    
    public void deletePost(int postID);
    
    public List<Post> searchPosts(Map<SearchTerm, String> criteria);
    
    public void approvePosts(int postID);
    
    public Post displayPostByID(int postID);
    
    public List<Post> searchByTag(String tag);
    
    //static methods
    
    public List<StaticPage> displayPage();
    
    public StaticPage addPage(StaticPage page);
    
    public void  editPage(StaticPage page);
    
    public void deletePage(int pageID);
    
    public void approvePage(int pageID);
    
    public StaticPage displayPageByID(int pageID);
    
    public Set displayTags();
}
