/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.Order;
import com.mycompany.flooringmastery.dto.Product;
import com.mycompany.flooringmastery.dto.Tax;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Optional;

/**
 *
 * @author apprentice
 */
public class OrderDAOimplPersistent implements OrderInterface {

    ArrayList<Product> productList = new ArrayList<>();
    ArrayList<Tax> taxList = new ArrayList<>();
    HashMap<String, ArrayList<Order>> orderMap = new HashMap<>();
    ArrayList<Order> orderList = new ArrayList<>();
    OrderDataAccess fileAccessObject = new OrderDataAccess();
    ArrayList<String> fileArray = new ArrayList<>();
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        Calendar cal = Calendar.getInstance();
        String theDate = (dateFormat.format(cal.getTime()));
        
   
     public OrderDAOimplPersistent (String file1, String file2){
         productList = fileAccessObject.readProducts(file1);
         taxList = fileAccessObject.readTaxes(file2);
     }   
        
    @Override
    public void readTaxFile(){
        //taxList = fileAccessObject.readTaxes("TaxesFile.txt");
    }
    
    @Override
    public void readProductFile(){
        //productList = fileAccessObject.readProducts("ProductsFile.txt");
    }
    
    @Override
    public void writeOrderFile() throws IOException {
        //first section writes file names per day to documen to hold these
        ArrayList<String> newFileArray = fileAccessObject.readFilesFile("filesToRead.txt");
        String file = theDate + ".txt";
        if (newFileArray.contains(file) == false){
            newFileArray.add(file);
        }
        fileAccessObject.writeFiles(newFileArray, "filesToRead.txt");
        
        //second section writes failes
        //Set <String> keys = orderMap.keySet();
        
            fileAccessObject.writeOrder(orderMap);
        
        //fileAccessObject.writeOrder(orderMap, keys);
           
    }
    
    @Override
    public void readOrderFile() {
        ArrayList<String> newFileArray = fileAccessObject.readFilesFile("filesToRead.txt");
        
        for (String f : newFileArray){
        String keyTitle = f;
        keyTitle = keyTitle.replace(".txt", "");
        orderMap.put(keyTitle, (fileAccessObject.readOrder(f)));
        }
        
    }
    
    @Override
    public ArrayList<Order> displayOrders(String date) {
        ArrayList <Order> resultArray = new ArrayList<>();
        if (orderMap.get(date) != null) {
            resultArray = orderMap.get(date);
            return resultArray;            
            //return orderMap.get(date);
        } else {
            return null;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<String> displayStates(){
        ArrayList<String> resultArray = new ArrayList<>();
        taxList.forEach(v -> resultArray.add(v.getState()));
        return resultArray;
    }
    
    @Override
    public ArrayList<String> displayProducts(){
        ArrayList<String> resultArray = new ArrayList<>();
        productList.forEach(v -> resultArray.add(v.getProductType()));
        return resultArray;
    }

    @Override
    public void addOrder (String customerName, String state, String productType, double area) {     
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        Calendar cal = Calendar.getInstance();
        String theDate = (dateFormat.format(cal.getTime()));
        
        double taxRate;
        Optional<Tax> taxObject = taxList.stream()
                .filter(t -> t.getState().contentEquals(state)).map(m -> m).findAny();
        taxRate = taxObject.get().getTaxRate();

        double costPerSquareFoot;
        Optional<Product> productObject = productList.stream()
                .filter(p -> p.getProductType().contentEquals(productType)).map(m -> m).findAny();
        costPerSquareFoot = productObject.get().getCostPerSquareFoot();

        double laborCostPerSquareFoot;
        Optional<Product> productObject1 = productList.stream()
                .filter(p -> p.getProductType().contentEquals(productType)).map(m -> m).findAny();
        laborCostPerSquareFoot = productObject1.get().getLaborCostPerSquareFoot();

        Optional<String> d = orderMap.keySet().stream()
                .filter(s -> s.equals(theDate))
                .map(m -> m)
                .findAny();
        if (d.isPresent()) {
            ArrayList<Integer> orderNumberList = new ArrayList<>(); 
            orderMap.forEach((k, v) -> {
               if (theDate.equals(k)){
                   Order newOrder = v.get(v.size()-1);
                   orderNumberList.add(newOrder.getOrderNumber()); 
               }   
            });
            int newOrderNumber = orderNumberList.get(0) + 1;
            
     
            orderMap.get(theDate).add(new Order(newOrderNumber, customerName, state, taxRate, productType, area, costPerSquareFoot,
                    laborCostPerSquareFoot));
        } else {

            int orderNumber = 1;
            orderMap.put(theDate, new ArrayList<Order>());
            orderMap.get(theDate).add(new Order(orderNumber, customerName, state, taxRate, productType, area, costPerSquareFoot,
                    laborCostPerSquareFoot));
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public Order editOrder(String date, int orderNumber) {
        Optional<Order> tempOrder = orderMap.get(date).stream()
                .filter(o -> o.getOrderNumber() == (orderNumber))
                .map(m -> m)
                .findAny();

        Order tempObject = tempOrder.get();

        return tempObject;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
        public Order viewOrder(String date, int orderNumber) {
        Optional<Order> tempOrder = orderMap.get(date).stream()
                .filter(o -> o.getOrderNumber() == (orderNumber))
                .map(m -> m)
                .findAny();
        
        if (tempOrder.isPresent()){
            Order tempObject = tempOrder.get();
            return tempObject;
        } else return null;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order removeOrder(String date, int orderNumber) {
        ArrayList<Order> resultArray = new ArrayList<>();
        orderMap.forEach((k, v) -> {
            if (date.equals(k)) {
                ArrayList<Order> orderListCopy = new ArrayList<>(v);
                orderListCopy.stream()
                        //.filter(i -> i !=null)
                        //.filter(i -> i.getOrderNumber() != null)
                        .filter((i) -> (i.getOrderNumber() == (orderNumber))).forEach((i) -> {
                    resultArray.add(i);
                });
            }
        });
        

        orderMap.forEach((k, v) -> {
            if (date.equals(k)) {
                ArrayList<Order> orderListCopy = new ArrayList<>(v);
                orderListCopy.stream()
                        //.filter(i -> i !=null)
                        //.filter(i -> i.getOrderNumber() != null)
                        .filter((i) -> (i.getOrderNumber() == (orderNumber))).forEach((i) -> {
                    v.remove(i);
                    
                });
            }
        });
        
        return resultArray.get(0);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void saveCurrentWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
