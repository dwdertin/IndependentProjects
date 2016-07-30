/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.Order;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class OrderDAOimplTest {
    
    public OrderDAOimplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of addOrder method, of class OrderDAOimpl.
     */
    @Test
    public void testAddOrderAndDisplayOrders() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        String theDate = (dateFormat.format(cal.getTime()));
        
        System.out.println("addOrder");
        String customerName = "Bob";
        String state = "MN";
        String productType = "Tile";
        double area = 100.0;
        OrderDAOimpl instance = new OrderDAOimpl("ProductsFile.txt", "TaxesFile.txt");
        
        instance.addOrder(customerName, state, productType, area);
        String date = theDate;
        ArrayList <Order> result = instance.displayOrders(date);
        assertNotNull(result);
        
        System.out.println("addOrder");
        String customerName1 = "Sally";
        String state1 = "OH";
        String productType1 = "Wood";
        double area1 = 100.0;
        instance.addOrder(customerName1, state1, productType1, area1);
        
        System.out.println("addOrder");
        String customerName2 = "Tom";
        String state2 = "OH";
        String productType2 = "Wood";
        double area2 = 100.0;
        instance.addOrder(customerName2, state2, productType2, area2);
        
        int result2 = instance.displayOrders(date).size();
        int expResult2 = 3;
        
        assertEquals(expResult2, result2);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editOrder method, of class OrderDAOimpl.
     */
    @Test
    public void testEditOrder() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        String theDate = (dateFormat.format(cal.getTime()));
        
        System.out.println("addOrder");
        String customerName = "Bob";
        String state = "MN";
        String productType = "Tile";
        double area = 100.0;
        OrderDAOimpl instance = new OrderDAOimpl("ProductsFile.txt", "TaxesFile.txt");
        
        instance.addOrder(customerName, state, productType, area);
        String date = theDate;
        ArrayList <Order> result = instance.displayOrders(date);
        assertNotNull(result);
        
        System.out.println("addOrder");
        String customerName1 = "Sally";
        String state1 = "OH";
        String productType1 = "Wood";
        double area1 = 100.0;
        instance.addOrder(customerName1, state1, productType1, area1);
        
        System.out.println("addOrder");
        String customerName2 = "Tom";
        String state2 = "OH";
        String productType2 = "Wood";
        double area2 = 100.0;
        instance.addOrder(customerName2, state2, productType2, area2);
        
        System.out.println("editOrder");
        Order tempOrder = instance.editOrder(theDate, 1);
        String result3 = tempOrder.getProductType().toString();
        String expResult3 = "Tile";
        
        assertEquals(result3, expResult3);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrder method, of class OrderDAOimpl.
     */
    @Test
    public void testRemoveOrder() {
       SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        Calendar cal = Calendar.getInstance();
        String theDate = (dateFormat.format(cal.getTime()));
        
        System.out.println("addOrder");
        String customerName = "Bob";
        String state = "MN";
        String productType = "Tile";
        double area = 100.0;
        OrderDAOimplPersistent instance = new OrderDAOimplPersistent("ProductsFile.txt", "TaxesFile.txt");
       
        instance.addOrder(customerName, state, productType, area);
        String date = theDate;
        ArrayList <Order> result = instance.displayOrders(date);
        assertNotNull(result);
        
        System.out.println("removeOrder");
        instance.removeOrder(theDate, 1);
        
        int result3 = instance.displayOrders(date).size();
        int expResult3 = 0;
        
        assertEquals(expResult3, result3);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of viewOrder method, of class OrderDAOimpl.
     */
    @Test
    public void testViewOrder() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        Calendar cal = Calendar.getInstance();
        String theDate = (dateFormat.format(cal.getTime()));
        
        System.out.println("addOrder");
        String customerName = "Bob";
        String state = "MN";
        String productType = "Tile";
        double area = 100.0;
        OrderDAOimplPersistent instance = new OrderDAOimplPersistent("ProductsFile.txt", "TaxesFile.txt");
        
        instance.addOrder(customerName, state, productType, area);
        String date = theDate;
        ArrayList <Order> result = instance.displayOrders(date);
        assertNotNull(result);
        
        System.out.println("addOrder");
        String customerName1 = "Sally";
        String state1 = "OH";
        String productType1 = "Wood";
        double area1 = 100.0;
        instance.addOrder(customerName1, state1, productType1, area1);
        
        System.out.println("addOrder");
        String customerName2 = "Tom";
        String state2 = "OH";
        String productType2 = "Wood";
        double area2 = 100.0;
        instance.addOrder(customerName2, state2, productType2, area2);
           
        System.out.println("viewOrder");
        Order tempOrder = instance.viewOrder(theDate, 2);
        String result3 = tempOrder.getProductType().toString();
        String expResult3 = "Wood";
        assertEquals(expResult3, result3);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of saveCurrentWork method, of class OrderDAOimpl.
     */
//    @Test
//    public void testSaveCurrentWork() {
//        System.out.println("saveCurrentWork");
//        OrderDAOimpl instance = new OrderDAOimpl();
//        instance.saveCurrentWork();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
