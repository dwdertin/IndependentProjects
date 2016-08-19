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
import com.mycompany.dmdcapstone.model.StaticPage;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class StaticController {
    
    private PostDao dao;
    
    @RequestMapping(value = "/toStatic", method = RequestMethod.GET)
    public String displayStaticPage(HttpServletRequest req, Model model) {
        
        StaticPage p = dao.displayPageByID(Integer.parseInt(req.getParameter("pageID")));
        
        model.addAttribute("StaticPage", p);
        
        return "Static";
    }

    
//    @RequestMapping(value = "/static", method = RequestMethod.GET)
//    public String displayStaticPage() {
//
//        return "Static";
//    }
    
    @Inject
    public StaticController(PostDao dao) {
        this.dao = dao;
    }
    
    
    @RequestMapping(value = "page/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StaticPage getPage(@PathVariable("id") int id) {
        
        return dao.displayPageByID(id);
    }
    
    @RequestMapping(value = "/createPage", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public StaticPage createPage(@RequestBody StaticPage page) {
        
        dao.addPage(page);
        
        return page;
    }
    
    @RequestMapping(value = "/page/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePage(@PathVariable("id") int id) {
        // remove the Contact associated with the given id from the data layer
        dao.deletePage(id);
    }
    
    @RequestMapping(value = "/approvePage/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void approvePost(@PathVariable("id") int id) {
        // remove the Contact associated with the given id from the data layer
        dao.approvePage(id);
    }
    
    @RequestMapping(value = "/editPage/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editPage(@PathVariable("id") int id, @RequestBody StaticPage page) {
     
        page.setPageID(id);
       
        dao.editPage(page);
    }

    @RequestMapping(value = "/displayPages", method = RequestMethod.GET)
    @ResponseBody
    public List<StaticPage> displayPages() {
      
        return dao.displayPage();
    }
}