/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sitelab.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class FlooringCalcController {
    
    @RequestMapping(value="flooringcalc", method=RequestMethod.GET)
    public String displayFlooringCalc(){
        
        return "flooringcalc";
    }
    
    @RequestMapping(value="/flooringcalc", method=RequestMethod.POST)
    public String displayFlooringCalculator(HttpServletRequest request, Model model){
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        double costPerSquareFoot = Double.parseDouble(request.getParameter("costPerSquareFoot"));
        double area = length * width;
        double materialCost = area * costPerSquareFoot;
        double laborCost = (area/5)*21.5;
        double totalCost = materialCost + laborCost;
        
        model.addAttribute("length", length);
        model.addAttribute("width", width);
        model.addAttribute("costPerSquareFoot", costPerSquareFoot);
        model.addAttribute("area", area);
        model.addAttribute("materialCost", materialCost);
        model.addAttribute("laborCost", laborCost);
        model.addAttribute("totalCost", totalCost);
       
        return "fcresponse";
    }
    
}
