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
public class OrderDAOimplPersistentTest {
    
    public OrderDAOimplPersistentTest() {
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
     * Test of readTaxFile method, of class OrderDAOimplPersistent.
     */
    @Test
//    public void testReadTaxFile() {
//        System.out.println("readTaxFile");
//        OrderDAOimplPersistent instance = new OrderDAOimplPersistent();
//        instance.readTaxFile();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of readProductFile method, of class OrderDAOimplPersistent.
//     */
//    @Test
//    public void testReadProductFile() {
//        System.out.println("readProductFile");
//        OrderDAOimplPersistent instance = new OrderDAOimplPersistent();
//        instance.readProductFile();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of writeOrderFile method, of class OrderDAOimplPersistent.
//     */
//    @Test
//    public void testWriteOrderFile() throws Exception {
//        System.out.println("writeOrderFile");
//        OrderDAOimplPersistent instance = new OrderDAOimplPersistent();
//        instance.writeOrderFile();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of readOrderFile method, of class OrderDAOimplPersistent.
//     */
//    @Test
//    public void testReadOrderFile() {
//        System.out.println("readOrderFile");
//        OrderDAOimplPersistent instance = new OrderDAOimplPersistent();
//        instance.readOrderFile();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of displayOrders method, of class OrderDAOimplPersistent.
//     */
//    @Test
//    public void testDisplayOrders() {
//        System.out.println("displayOrders");
//        String date = "";
//        OrderDAOimplPersistent instance = new OrderDAOimplPersistent();
//        ArrayList<Order> expResult = null;
//        ArrayList<Order> result = instance.displayOrders(date);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addOrder method, of class OrderDAOimplPersistent.
     */
    
    public void testAddOrderAndDisplayOrder() {
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
        
        int result2 = instance.displayOrders(date).size();
        int expResult2 = 3;
        
        assertEquals(expResult2, result2);
      
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of editOrder method, of class OrderDAOimplPersistent.
     */
    @Test
    public void testEditOrder() {
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
        
        System.out.println("editOrder");
        Order tempOrder = instance.editOrder(theDate, 1);
        String result3 = tempOrder.getProductType().toString();
        String expResult3 = "Tile";
        
        assertEquals(result3, expResult3);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of viewOrder method, of class OrderDAOimplPersistent.
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
        
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrder method, of class OrderDAOimplPersistent.
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
        
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    
    //save work method simply calls the write method- write method is tested in Data Access tests
//    /**
//     * Test of saveCurrentWork method, of class OrderDAOimplPersistent.
//     */
//    @Test
//    public void testSaveCurrentWork() {
//        System.out.println("saveCurrentWork");
//        OrderDAOimplPersistent instance = new OrderDAOimplPersistent();
//        instance.saveCurrentWork();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
