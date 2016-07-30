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
public class FactorizorController {

    @RequestMapping(value = "factorizor", method = RequestMethod.GET)
    public String displayFactorizor() {

        return "factorizor";
    }

    @RequestMapping(value = "/factorizor", method = RequestMethod.POST)
    public String start(HttpServletRequest request, Model model) {
        int i, numberOfFactors1 = 0, isPerfect1 = 0;
        int numberEnteredByUser1;
        numberEnteredByUser1 = Integer.parseInt(request.getParameter("numberEnteredByUser"));
        ArrayList<Integer> listCopy = new ArrayList<>();

        for (i = 1; i < numberEnteredByUser1; i++) {

            if (numberEnteredByUser1 % i == 0) {
                numberOfFactors1++;
                isPerfect1 += i;
                listCopy.add(i);
            }
        }

        if (numberOfFactors1 == 1) {
            model.addAttribute("isPrime", true);
        } else {
            model.addAttribute("isPrime", false);
        }
        if (isPerfect1 == numberEnteredByUser1) {
            model.addAttribute("isPerfect", true);
        } else if (isPerfect1 != numberEnteredByUser1) {
            model.addAttribute("isPerfect", false);
        }
        model.addAttribute("numberEnteredByUser", numberEnteredByUser1);
        model.addAttribute("numberOfFactors", numberOfFactors1);
        model.addAttribute("factorsList", listCopy);

        return "factresponse";
    }

}
