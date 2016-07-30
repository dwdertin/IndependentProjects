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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class OrderDataAccess {

    public ArrayList<Product> readProducts(String file) {
        ArrayList<Product> readProductList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
            String temp;
            String[] tempStrings;

            while (sc.hasNextLine()) {
                temp = sc.nextLine();
                tempStrings = temp.split(",");
                readProductList.add(new Product(tempStrings[0], Double.parseDouble(tempStrings[1]), Double.parseDouble(tempStrings[2])));
            }
        } catch (FileNotFoundException e) {
            //No relevant action to be performed
        }
        return readProductList;
    }

    public ArrayList<Tax> readTaxes(String file) {
        ArrayList<Tax> readTaxList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
            String temp;
            String[] tempStrings;

            while (sc.hasNextLine()) {
                temp = sc.nextLine();
                tempStrings = temp.split(",");
                readTaxList.add(new Tax(tempStrings[0], Double.parseDouble(tempStrings[1])));
            }
        } catch (FileNotFoundException e) {
            //no relevant action to be performed
        }
        return readTaxList;
    }
  
    public ArrayList<String> readFilesFile(String file) {
        ArrayList<String> readFilesList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
            String temp;
            while (sc.hasNextLine()){
                temp = sc.nextLine();
                readFilesList.add(temp);
            }        
        } catch (FileNotFoundException e) {
            //no relevant action to be performed
        }
        return readFilesList;
    }
    
    
    public void writeFiles(ArrayList<String> fileArray, String file) throws IOException{
        try{
        PrintWriter out = new PrintWriter(new FileWriter(file));
       for (String f : fileArray){
           out.println(f);
       }
       out.flush();
       out.close();  
       } catch (IOException e) {
           System.out.println("Write failed.");
       }
    }

    public void writeOrder(HashMap<String, ArrayList<Order>> orderMap) throws IOException {
        try {  
        ArrayList<Order> resultArray;
        PrintWriter out;
        for (String k : orderMap.keySet()) {
            String file = k +".txt"; 
            out = new PrintWriter(new FileWriter(file));
            resultArray = orderMap.get(k);
            for (Order v : resultArray) {
                out.println(v.getOrderNumber() + ","
                        + v.getCustomerName() + ","
                        + v.getState() + ","
                        + v.getTaxRate() + ","
                        + v.getProductType() + ","
                        + v.getArea() + ","
                        + v.getCostPerSquareFoot() + ","
                        + v.getLaborCostPerSquareFoot() + ","
                        + v.getMaterialCost() + ","
                        + v.getLaborCost() + ","
                        + v.getTax() + ","
                        + v.getTotal()
                );
            }
            out.flush();
            out.close();
        }
        } catch (IOException e) {
            System.out.println("Write failed.");
        }
    }

    public ArrayList<Order> readOrder(String file) {
        ArrayList<Order> resultArray = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
            String temp;
            String[] tempStrings;

            while (sc.hasNextLine()) {
                temp = sc.nextLine();
                tempStrings = temp.split(",");
                resultArray.add(new Order(Integer.parseInt(tempStrings[0]), tempStrings[1], tempStrings[2], Double.parseDouble(tempStrings[3]),
                        tempStrings[4], Double.parseDouble(tempStrings[5]), Double.parseDouble(tempStrings[6]), Double.parseDouble(tempStrings[7])));

            }
        } catch (FileNotFoundException e) {
            return null;
        }

        return resultArray;
    }
    

}
