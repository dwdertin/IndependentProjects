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
public class ConverterController {

    @RequestMapping(value = "converter", method = RequestMethod.GET)
    public String displayConverter() {

        return "converter";
    }
    //the value mapping cannot be repeated for multiple gets and posts- cannot have /converter for both posts
    @RequestMapping(value = "/convertTemp", method = RequestMethod.POST)
    public String convertTemp(HttpServletRequest request, Model model) {
        double userInput = Double.parseDouble(request.getParameter("userInput"));
        String tempStartingType = request.getParameter("tempStartingType");
        model.addAttribute("tempStartingType", tempStartingType);
        
        if ("Fahrenheit".equals(tempStartingType)) {
            model.addAttribute("degreesF", userInput);
            model.addAttribute("degreesC", (((userInput - 32) * 5) / 9));

        } else if ("Celsius".equals(tempStartingType)) {
            model.addAttribute("degreesC", userInput);
            model.addAttribute("degreesF", (((userInput * 9) / 5) + 32));
        }
        return "csresponse";
    }

    
//     @RequestMapping(value = "convertWeight", method = RequestMethod.GET)
//    public String displayConverterWeight() {
//
//        return "converter";
//    }
    
    //need to add another get for this method with a unique mapping?
    //request mapping value either appears here or in form action
    @RequestMapping(value = "/convertWeight", method = RequestMethod.POST)
    public String convertWeight(HttpServletRequest request, Model model) {
        double weightUserInput = Double.parseDouble(request.getParameter("weightUserInput"));
        String weightStartingType = request.getParameter("weightStartingType");
        model.addAttribute("weightStartingType", weightStartingType);
        
        if ("Pounds".equals(weightStartingType)) {
            model.addAttribute("weightPounds", weightUserInput);
            model.addAttribute("weightKilograms", (weightUserInput / 2.2046226218));

        } else if ("Kilograms".equals(weightStartingType)) {
            model.addAttribute("weightKilograms", weightUserInput);
            model.addAttribute("weightPounds", (weightUserInput * 2.2046226218));
        }
        return "csresponse";
        
    }
    
}

//
// @RequestMapping(value = "/converter", method = RequestMethod.POST)
//    public String convertTemp(HttpServletRequest request, Model model) {
//        double userInput = Double.parseDouble(request.getParameter("userInput"));
//        String tempStartingType = request.getParameter("tempStartingType");
//
//        if ("Fahrenheit".equals(tempStartingType)) {
//            model.addAttribute("degreesF", userInput);
//            model.addAttribute("degreesC", (((userInput - 32) * 5) / 9));
//
//        } else if ("Celsius".equals(tempStartingType)) {
//            model.addAttribute("degreesC", userInput);
//            model.addAttribute("degreesF", (((userInput * 9) / 5) + 32));
//        }
//        return "csresponse";
//    }
//
//    @RequestMapping(value = "/converter", method = RequestMethod.POST)
//    public String convertWeight(HttpServletRequest request, Model model) {
//        double weightUserInput = Double.parseDouble(request.getParameter("weightUserInput"));
//        String weightStartingType = request.getParameter("weightStartingType");
//
//        
//        if ("Pounds".equals(weightStartingType)) {
//            model.addAttribute("weightPounts", weightUserInput);
//            model.addAttribute("weightKilograms", (weightUserInput / 2.2046226218));
//
//        } else if ("Kilograms".equals(weightStartingType)) {
//            model.addAttribute("weightKilograms", weightUserInput);
//            model.addAttribute("weightPounts", (weightUserInput * 2.2046226218));
//        }
//        return "csresponse";
//        
//    }