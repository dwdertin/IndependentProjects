/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.ops;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;





/**
 *
 * @author apprentice
 */
public class FlooringRunner {
    public static void main(String[] args) throws IOException {
        
        
        //new FlooringController().run();
        
        //FlooringController controller = new FlooringController(new OrderDAOimplPersistent("ProductsFile.txt", "TaxesFile.txt"));
        //controller.run();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller = (FlooringController) ctx.getBean("FlooringController");
        
        controller.run();
        
        
        
    }
}

