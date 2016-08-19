/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dmdcapstone.controller;

import com.mycompany.dmdcapstone.dao.PostDao;
import com.mycompany.dmdcapstone.model.Post;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class SearchController {

    private PostDao dao;
    private List<Post> results;
    private List<String> tagSearched;

    @Inject
    public SearchController(PostDao dao) {
        this.dao = dao;
        this.results = dao.displayPosts();
        this.tagSearched = new ArrayList<>();
    }

    @RequestMapping(value = "search/{tag}", method = RequestMethod.POST)
    @ResponseBody
    public List<Post> searchByTag(@PathVariable("tag") String tag) {
        tagSearched.add(tag);
        List<Post> insideResults = results.stream()
                .filter(p -> p.getTags().contains(tag))
                .collect(Collectors.toList());
                
                
        results.clear();
        results.addAll(insideResults);
        return results;
//        }
//            System.out.println(dao.searchByTag("tag1"));
//        return dao.searchByTag(tag);

    }
    
    @RequestMapping(value="listOfTags", method=RequestMethod.GET)
    @ResponseBody
    public List<String> tagsInList(){
        return tagSearched;
    }
    
    @RequestMapping(value="nixTag/{tag}", method=RequestMethod.POST)
    @ResponseBody
    public List<Post> adjustSearch(@PathVariable("tag") String tag){
        tagSearched.remove(tag);
        List<Post> insideResults = dao.displayPosts().stream()
                .filter(p -> p.getTags().containsAll(tagSearched))
                .collect(Collectors.toList());
                
                
        results.clear();
        results.addAll(insideResults);
        return results;
        
    }
    
    @RequestMapping(value="nevermind", method=RequestMethod.GET)
    @ResponseBody
    public List<Post> clearSearch(){
        results.clear();
        tagSearched.clear();
        results = dao.displayPosts();
        return results;
    }

}
