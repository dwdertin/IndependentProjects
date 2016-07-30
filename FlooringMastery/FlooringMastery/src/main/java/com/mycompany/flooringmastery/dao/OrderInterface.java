/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.Order;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface OrderInterface {
    
    public ArrayList<Order> displayOrders(String date);
    public void addOrder(String customerName, String state, String productType, double area);
    public Order editOrder(String date, int orderNumber);
    public Order removeOrder(String date, int orderNumber);
    public void saveCurrentWork();
    public Order viewOrder(String date, int orderNumber);
    public void readTaxFile();
    public void readProductFile();
    public void writeOrderFile() throws IOException;
    public void readOrderFile();
    public ArrayList<String> displayStates();
    public ArrayList<String> displayProducts();
    
}
