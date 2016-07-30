/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sitelab.controller;

import java.util.ArrayList;
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
public class InterestCalcController {

    @RequestMapping(value = "interestcalc", method = RequestMethod.GET)
    public String displayFactorizor() {

        return "interestcalc";
    }

    @RequestMapping(value = "/interestcalc", method = RequestMethod.POST)
    public String start(HttpServletRequest request, Model model) {

        int startingYear, yearsInvested, yearNumber, interestEarned, finalPrincipal;
        float annualRate, prevYear, initialPrincipal;
        String output;
        startingYear = 2015;
        ArrayList<String> resultArray = new ArrayList<>();

        annualRate = Float.parseFloat(request.getParameter("annualRate"));
        initialPrincipal = Float.parseFloat(request.getParameter("initialPrincipal"));
        yearsInvested = Integer.parseInt(request.getParameter("yearsInvested"));

        for (int i = 0; i < yearsInvested; i++) {
            //prevYear = totalYear previous year earnings = total yearly earnings

            prevYear = initialPrincipal;
            //totalYear = initialPrincipal

            for (int j = 0; j < 4; j++) {
                initialPrincipal = initialPrincipal * (1 + (annualRate / 400));
            }
            output = "The current year is " + (startingYear + i + 1) + " You started the year"
                    + " with $" + prevYear + ". Your interest was $" + (initialPrincipal - prevYear) + ". Now"
                    + " your total investment is $" + initialPrincipal + ". <br>";
            resultArray.add(output);
        }
        model.addAttribute("resultArray", resultArray);
        return "icresponse";
    }
}



