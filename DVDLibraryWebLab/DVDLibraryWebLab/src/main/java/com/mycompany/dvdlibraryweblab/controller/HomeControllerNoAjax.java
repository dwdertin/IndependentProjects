/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryweblab.controller;

import com.mycompany.dvdlibraryweblab.dao.DVDLibraryDao;
import com.mycompany.dvdlibraryweblab.model.DVD;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeControllerNoAjax {
    
    private DVDLibraryDao dao;
    
     @Inject
    public HomeControllerNoAjax(DVDLibraryDao dao){
    this.dao = dao;
    }
 

    @RequestMapping(value="/displayDvdListNoAjax", method=RequestMethod.GET)
    public String displayDvdListNoAjax(Model model){
        List<DVD> dList = dao.getAllDVDs();
        model.addAttribute("dvdList", dList);
        
        return "displayDvdListNoAjax";
    }
    
     @RequestMapping(value="/displayNewDvdFormNoAjax", method=RequestMethod.GET)
    public String displayNewDvdFormNoAjax(Model model){
        DVD d = new DVD();
        model.addAttribute("dvd", d);
        return "newDvdFormNoAjax";
    }
    
   @RequestMapping(value="/addDvdNoAjax", method=RequestMethod.POST) 
   public String addNewDvdNoAjax(@Valid @ModelAttribute("dvd") DVD dvd, BindingResult result){
       if (result.hasErrors()){
           return "newDvdFormNoAjax";
       }
       dao.addDVD(dvd);
       return "redirect:displayDvdListNoAjax";   
   }
    
   @RequestMapping(value="/deleteDvdNoAjax", method=RequestMethod.GET)
   public String deleteDvdNoAjax(HttpServletRequest req){
       int dvdId = Integer.parseInt(req.getParameter("dvdId"));
       dao.removeDVD(dvdId);
       
       return "redirect:displayDvdListNoAjax";
   }
   
   
   @RequestMapping(value="/displayEditDvdFormNoAjax", method=RequestMethod.GET)
   public String displayEditDvdFormNoAjax(HttpServletRequest req, Model model){
       int dvdId = Integer.parseInt(req.getParameter("dvdId"));
       
       DVD d = dao.getDVDById(dvdId);
       
       model.addAttribute("dvd", d);
       
       return "editDvdFormNoAjax";
   }
   
   
   
   @RequestMapping(value="editDvdNoAjax", method=RequestMethod.POST)
   public String editDvdNoAjax(@Valid @ModelAttribute("dvd") DVD dvd, BindingResult result){
       if (result.hasErrors()){
           return "editDvdFormNoAjax";
       }
       dao.updateDVD(dvd);
       return "redirect:displayDvdListNoAjax";
       
   }
   
   
   
}
