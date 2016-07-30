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
public class TipCalcController {
     @RequestMapping(value="tipcalc", method=RequestMethod.GET)
    public String displayTipCalc(){
        
        return "tipcalc";
    }
    
    @RequestMapping(value="/tipcalc", method=RequestMethod.POST)
    public String displayTipCalculator(HttpServletRequest request, Model model){
        double dollarAmount = Double.parseDouble(request.getParameter("dollarAmount"));
        double tipPercentage = Double.parseDouble(request.getParameter("tipPercentage"));
        double tipAmount = (dollarAmount * tipPercentage)/100;
        double subTotal = dollarAmount;
        double grandTotal = subTotal + tipAmount;
        
        model.addAttribute("dollarAmount", dollarAmount);
        model.addAttribute("tipPercentage", tipPercentage);
        model.addAttribute("tipAmount", tipAmount);
        model.addAttribute("subTotal", subTotal);
        model.addAttribute("grandTotal", grandTotal);
        
        return "tcresponse";
    }
    
}
