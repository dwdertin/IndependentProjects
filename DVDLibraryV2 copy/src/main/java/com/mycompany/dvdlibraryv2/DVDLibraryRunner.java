/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryv2;

import com.mycompany.dvdlibraryv2.ops.DVDLibraryController;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DVDLibraryRunner {
    public static void main(String[] args) throws IOException {
        new DVDLibraryController().run();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

//     
//       Event skiJumpEvent = new SkiJumpEvent();
//        Olympian olympianSkiJumper = new Olympian(skiJumpEvent);
//        olympianSkiJumper.competeInEvent();
//
//        Olympian usaSkiJumper = (Olympian) ctx.getBean("usaSkiJumper");
//        usaSkiJumper.competeInEvent();
//        Olympian usaSpeedSkater = (Olympian) ctx.getBean("usaSpeedSkater");
//        usaSpeedSkater.competeInEvent();
//        Olympian canadaSpeedSkater = (Olympian) ctx.getBean("canadianSpeedSkater");
//        canadaSpeedSkater.competeInEvent();
    
    }
}
