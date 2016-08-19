/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dmdcapstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mycompany.dmdcapstone.dao.PostDao;
import com.mycompany.dmdcapstone.model.Post;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
    
    private PostDao dao;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {

        return "home";
    }
    
    @RequestMapping(value = "/static", method = RequestMethod.GET)
    public String displayStaticPage() {

        return "Static";
    }

    @Inject
    public HomeController(PostDao dao) {
        this.dao = dao;
    }
    
    
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Post getPost(@PathVariable("id") int id) {
        
        return dao.displayPostByID(id);
    }
    
    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Post createPost(@RequestBody Post post) {
        
        dao.addPost(post);
        
        return post;
    }
    
    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") int id) {
        // remove the Contact associated with the given id from the data layer
        dao.deletePost(id);
    }
    
    @RequestMapping(value = "/approvePost/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void approvePost(@PathVariable("id") int id) {
        // remove the Contact associated with the given id from the data layer
        dao.approvePosts(id);
    }
    
    @RequestMapping(value = "/editPost/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editPost(@PathVariable("id") int id, @RequestBody Post post) {
     
        post.setPostID(id);
       
        dao.editPost(post);
    }

    @RequestMapping(value = "/displayPosts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> displayPosts() {
      
        return dao.displayPosts();
    }
  
}
