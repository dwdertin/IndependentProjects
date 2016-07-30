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
public class LuckySevenController {
    
    @RequestMapping(value="luckyseven", method=RequestMethod.GET)
    public String displayLuckySeven(){
        
        return "luckyseven";
    }
    
      @RequestMapping(value="/luckyseven", method=RequestMethod.POST)
      public String start(HttpServletRequest request, Model model) {
        
        int pot, dieRoll1, dieRoll2, diceTotal, maxMoneyzHeld, totalRolls, maxRoll;
        int roundsMax = 0;
        int roundsTotal = 0;
        
        String userBet = request.getParameter("initialBet");
        
        pot = Integer.parseInt(userBet);
        
        maxMoneyzHeld = pot;
        totalRolls = 0;
        maxRoll = 0;
        
        while (pot > 0) {
            totalRolls++;
            
        dieRoll1 = (int)(Math.random() * 6) + 1;
        dieRoll2 = (int)(Math.random() * 6) + 1;
        diceTotal = dieRoll1 + dieRoll2;
            
            if (diceTotal == 7) {
                pot += 4;
                if (pot >= maxMoneyzHeld) {
                    maxMoneyzHeld = pot;
                    maxRoll = totalRolls;
                }
                
            }
            else {
                    pot--; 
                }
            } 
        model.addAttribute("initialBet", userBet);
        model.addAttribute("MaxMoneyHeld", maxMoneyzHeld);
        model.addAttribute("roundsMax", maxRoll);
        model.addAttribute("roundsTotal", totalRolls);
        
        return "lsresponse";
        
            } 
    
}
