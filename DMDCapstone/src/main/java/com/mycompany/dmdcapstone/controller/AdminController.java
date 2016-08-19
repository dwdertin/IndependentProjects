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
import javax.inject.Inject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class AdminController {
    
    private PostDao dao;

    @RequestMapping(value ={"/admin"}, method = RequestMethod.GET)
    public String displayHomePage() {

        return "admin";
    }
    
    @Inject
    public AdminController(PostDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/approvePosts", method = RequestMethod.GET)
    @ResponseBody
    public void approvePosts(@PathVariable("id") int id) {
      
        dao.approvePosts(id);
        
    }
   
}
