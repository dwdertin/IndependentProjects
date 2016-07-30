/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.Order;
import com.mycompany.flooringmastery.dto.Product;
import com.mycompany.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
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
public class OrderDataAccessTest {
    
    public OrderDataAccessTest() {
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
     * Test of readProducts method, of class OrderDataAccess.
     */
    @Test
    public void testReadProducts() {
         try {
        PrintWriter out = new PrintWriter(new FileWriter("TestProductsFile.txt"));
        out.println("Tile,3.50,4.15");
        out.flush();
        out.close();
        } catch (IOException e){
            System.out.println("Write Failed");
        }
        
        System.out.println("readProducts");
        String file = "TestProductsFile.txt";
        OrderDataAccess instance = new OrderDataAccess();
        ArrayList<Product> expResult = new ArrayList<>();
        
        expResult.add(new Product("Tile", 3.50, 4.15));
        String expResult2 = expResult.toString();
        
        ArrayList<Product> result = instance.readProducts(file);
        
        String result2 = result.toString();
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of readTaxes method, of class OrderDataAccess.
     */
    @Test
    public void testReadTaxes() {
           try {
        PrintWriter out = new PrintWriter(new FileWriter("TestReadTaxesFile.txt"));
        out.println("ND,5.75");
        out.flush();
        out.close();
        } catch (IOException e){
            System.out.println("Write Failed");
        }
        
        System.out.println("readTaxes");
        String file = "TestReadTaxesFile.txt";
        OrderDataAccess instance = new OrderDataAccess();
        ArrayList<Tax> expResult = new ArrayList<>();
        expResult.add(new Tax("ND", 5.75));
        String expResult1 = expResult.toString();
        ArrayList<Tax> result = instance.readTaxes(file);
        String result1 = result.toString();
        assertEquals(expResult1, result1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of readFilesFile method, of class OrderDataAccess.
     */
    
    public void testReadFilesFile() {
          try {
        PrintWriter out = new PrintWriter(new FileWriter("TestReadFilesFile.txt"));
        out.println("05141988.txt");
        out.flush();
        out.close();
        } catch (IOException e){
            System.out.println("Write Failed");
        }
        
        System.out.println("readFilesFile");
        String file = "TestReadFilesFile.txt";
        OrderDataAccess instance = new OrderDataAccess();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("05141988.txt");
        ArrayList<String> result = instance.readFilesFile(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeFiles method, of class OrderDataAccess.
     */
    
    public void testWriteFiles() throws Exception {
        System.out.println("writeFiles");
        ArrayList<String> fileArray = new ArrayList<>();
        fileArray.add("12252016.txt");
                
        String file = "TestFilesToRead.txt";
        OrderDataAccess instance = new OrderDataAccess();
        instance.writeFiles(fileArray, file);
        
        ArrayList<String> resultArray = new ArrayList<>();
        Scanner sc = new Scanner (new BufferedReader(new FileReader(file)));
        String temp;
        
        while (sc.hasNextLine()){
            temp = sc.nextLine();
            resultArray.add(temp);
        }
        
        String result = resultArray.toString();
        String expResult = "[12252016.txt]";
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeOrder method, of class OrderDataAccess.
     */
 
    public void testWriteOrder() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        Calendar cal = Calendar.getInstance();
        String theDate = (dateFormat.format(cal.getTime()));
        
        HashMap<String, ArrayList<Order>> testMap = new HashMap<>();
        ArrayList<Order> testArray = new ArrayList<>();
        int orderNumber = 1;
        String customerName = "Adam";
        String state = "OH";
        double taxRate = 6.25;
        String productType = "Wood";
        double area = 4040.00;
        double costPerSquareFoot = 5.15;
        double laborCostPerSquareFoot = 4.75;
        double materialCost = 20806.0;
        double laborCost = 19190.0;
        double tax = 249975.0;
        double total = 289971.0;
        
        testArray.add(new Order(orderNumber, customerName, state, taxRate, productType, area, costPerSquareFoot,
                laborCostPerSquareFoot));
        testMap.put(theDate, testArray);       
        
        System.out.println("writeOrder");
        //HashMap<String, ArrayList<Order>> orderMap = null;
        String file = "FlooringWriteOrderTextFile.txt";
        OrderDataAccess instance = new OrderDataAccess();
        instance.writeOrder(testMap);
        
        ArrayList<String> resultArray = new ArrayList<>();
        Scanner sc = new Scanner (new BufferedReader(new FileReader(file)));
        String temp;
        
        while (sc.hasNextLine()){
            temp = sc.nextLine();
            resultArray.add(temp);
        }
        String result = resultArray.toString();
        String expResult = "[1,Adam,OH,6.25,Wood,4040.0,5.15,4.75,20806.0,19190.0,249975.0,289971.0]";
        assertEquals(expResult, result);
       
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }

    /**
     * Test of readOrder method, of class OrderDataAccess.
     * @throws java.io.IOException
     */
    @Test
    public void testReadOrder() throws IOException {
        try {
        PrintWriter out = new PrintWriter(new FileWriter("FlooringReadOrderTestFile.txt"));
        out.println("1,Dustin,MN,5.75,Tile,50.0,3.5,4.15,175.0,207.50000000000003,2199.375,2581.875");
        out.flush();
        out.close();
        } catch (IOException e){
            System.out.println("Write Failed");
        }

        System.out.println("readOrder");
        String file = "FlooringReadOrderTestFile.txt";
        OrderDataAccess instance = new OrderDataAccess();
        ArrayList<Order> result = instance.readOrder(file);
        assertNotNull(result);

//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
