/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dmdcapstone.controller;

import com.mycompany.dmdcapstone.dao.PostDao;
import com.mycompany.dmdcapstone.dao.SearchTerm;
import com.mycompany.dmdcapstone.model.Post;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    @Inject
    public SearchController(PostDao dao) {
        this.dao = dao;
    }
    
//    @RequestMapping(value = "search/{tag}", method = RequestMethod.POST)
//    @ResponseBody
//        public List<Post> searchPosts(@PathVariable("tag") String tag){
////public List<Post> searchPosts(@RequestBody Map<String, String> searchMap) {
//        // Create the map of search criteria to send to the DAO
//        Map<String, String> searchMap = new HashMap<>();
//        
//        Map<SearchTerm, String> criteriaMap = new HashMap<>();
//
//        // Determine which search terms have values, translate the String
//        // keys into SearchTerm enums, and set the corresponding values
//        // appropriately.
//        String currentTerm = searchMap.get("tag");
//        if (!currentTerm.isEmpty()) {
//            criteriaMap.put(SearchTerm.TAG, currentTerm);
//        }
//     
//        return dao.searchPosts(criteriaMap);
//    }
    
        
        @RequestMapping(value = "search/{tag}", method = RequestMethod.POST)
        @ResponseBody
        public List<Post> searchByTag(@PathVariable("tag") String tag){
////public List<Post> searchPosts(@RequestBody Map<String, String> searchMap) {
//        // Create the map of search criteria to send to the DAO
//        Map<String, String> searchMap = new HashMap<>();
//        
//        Map<SearchTerm, String> criteriaMap = new HashMap<>();
//
//        // Determine which search terms have values, translate the String
//        // keys into SearchTerm enums, and set the corresponding values
//        // appropriately.
//        String currentTerm = searchMap.get("tag");
//        if (!currentTerm.isEmpty()) {
//            criteriaMap.put(SearchTerm.TAG, currentTerm);
//        }
            System.out.println(dao.searchByTag("tag1"));
        return dao.searchByTag(tag);
           
    }
        
}
