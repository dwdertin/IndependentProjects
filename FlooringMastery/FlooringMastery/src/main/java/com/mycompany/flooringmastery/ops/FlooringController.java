/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.ops;

import com.mycompany.flooringmastery.dao.OrderDAOimpl;
import com.mycompany.flooringmastery.dao.OrderDAOimplPersistent;
import com.mycompany.flooringmastery.dao.OrderInterface;
import com.mycompany.flooringmastery.dto.Order;
import com.mycompany.flooringmastery.ui.ConsoleIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class FlooringController {

    ConsoleIO console = new ConsoleIO();
    int userInput;
    public OrderInterface orderInterface;
    
    public FlooringController(OrderInterface orderInterface){
        this.orderInterface = orderInterface;
    }

    public void run() throws IOException {
        //orderInterface.readTaxFile();
        //orderInterface.readProductFile();
        orderInterface.readOrderFile();
        do {

            console.write("*********************************************************\n");
            console.write("*                   Flooring Program                    *\n");
            console.write("*                                                       *\n");
            console.write("1. Display Orders                                       *\n");
            console.write("2. Add an Order                                         *\n");
            console.write("3. Edit an Order                                        *\n");
            console.write("4. Remove an Order                                      *\n");
            console.write("5. Save Current Work                                    *\n");
            console.write("6. Quit                                                 *\n");
            console.write("*                                                       *\n");
            console.write("*********************************************************\n");
            console.write(">");

            userInput = console.readInteger("", 1, 6);

            switch (userInput) {
                case 1:
                    controllerDisplayOrders();
                    break;

                case 2:
                    //if you add 2 orders, delete one, and add another the order numbers are wrong
                    controllerAddAnOrder();
                    break;

                case 3:
                    controllerEditAnOrder();
                    break;

                case 4:
                    controllerRemoveAnOrder();
                    break;

                case 5:
                    controllerSaveWork();
                    //save current work
                    break;

                case 6:
                    //Quit
                    break;

            }

        } while (userInput != 6);
        controllerSaveWork();
    }

    public void controllerSaveWork() throws IOException{
        orderInterface.writeOrderFile();
    }
    
    public void controllerDisplayOrders() {
        String date = console.readString("Please enter the date for which you would like to view orders (MMDDYYYY):\n");
        if (orderInterface.displayOrders(date) == null) {
            console.write("Error. No orders exist for that date.\n");
        } else {
            ArrayList<Order> displayOrders = orderInterface.displayOrders(date);
            for (Order o : displayOrders){
                console.write(o.toString() + "\n");
            }
            //console.write(orderInterface.displayOrders(date).toString() + "\n");
        }
    }

    public void controllerAddAnOrder() throws IOException {
        String confirmation;
        String productType;
        String customerName;
        boolean proceed;
        String state;
        ArrayList <String> stateArrayList = orderInterface.displayStates();
        ArrayList <String> productArrayList = orderInterface.displayProducts();
        do {

            do{
            customerName = console.readString("Please enter the customer name (First Last):\n");
            if (customerName.isEmpty()) {
                console.write("Please enter customer name.\n");
                proceed = false;
            } else proceed = true;
            } while (proceed == false);
            
            do {
                console.write("Please enter the state (Abbreviated LL):\n");
                state = console.readString("Available state options are: " + stateArrayList.toString() + "\n");
                
                if (stateArrayList.contains(state)){
                //if (state.equals("MN") || state.equals("OH") || state.equals("PA") || state.equals("IN")) {
                    console.write("\n");
                    proceed = true;
                } else {
                    console.write("Not a valid state. Please try again.\n");
                    proceed = false;
                }
            } while (proceed == false);

            do {
                console.write("Please enter the product type:\n");
                productType = console.readString("Available product types are: " + productArrayList.toString() + "\n");
                if (productArrayList.contains(productType)){
                //if (productType.equals("Tile") || productType.equals("Carpet") || productType.equals("Laminate") || productType.equals("Wood")) {
                    console.write("\n");
                    proceed = true;
                } else {
                    console.write("Not a valid product type. Please try again.\n");
                    proceed = false;
                }
            } while (proceed == false);

            double area = console.readDouble("Please enter the area:\n");

            console.write("You entered:\n");
            console.write("Customer Name: " + customerName + "\n");
            console.write("State: " + state + "\n");
            console.write("Product Type: " + productType + "\n");
            console.write("Area: " + area + "\n");
            console.write("Would you like to commit this order? (Y/N):\n");
            confirmation = console.readString(">");

            if (confirmation.equals("Y")) {
                orderInterface.addOrder(customerName, state, productType, area);
                break;
            }
        } while (confirmation.equals("N"));

    }

    public void controllerEditAnOrder() {
        ArrayList <String> stateArrayList = orderInterface.displayStates();
        ArrayList <String> productArrayList = orderInterface.displayProducts();
        String date1;
        boolean proceed;
        do {
            date1 = console.readString("Please enter the date of the order (MMDDYYYY):\n");
            if (orderInterface.displayOrders(date1) == null) {
                console.write("Error. No orders exist for that date.\n");

            } else {
                console.write("\n");
            }
        } while (orderInterface.displayOrders(date1) == null);

        int orderNumber1;

        do {
            orderNumber1 = console.readInteger("Please enter the order number:\n");
            if (orderInterface.viewOrder(date1, orderNumber1) == null) {
                console.write("Error. Order does not exist.\n");
            } else {
                console.write("\n");
            }

        } while (orderInterface.viewOrder(date1, orderNumber1) == null);

        String newCustomerName = console.readString("Enter customer name (" + (orderInterface.editOrder(date1, orderNumber1).getCustomerName()) + "):");
        if (newCustomerName.isEmpty()) {
            console.write("\n");
        } else {
            orderInterface.editOrder(date1, orderNumber1).setCustomerName(newCustomerName);
            console.write("\n");
        }
        
        do{
            
        String newState = console.readString("Enter state (" + (orderInterface.editOrder(date1, orderNumber1).getState()) + "):");
        if (newState.isEmpty()) {
            console.write("\n");
            proceed = true;
        } else if (stateArrayList.contains(newState)){
        //} else if (newState.equals("MN") || newState.equals("OH") || newState.equals("PA") || newState.equals("IN")){
            orderInterface.editOrder(date1, orderNumber1).setState(newState);
            proceed = true;
            console.write("\n");
        } else {
            console.write("Not a valid state. Please try again.\n");
            proceed = false;
        }
        } while (proceed == false);
      
   
        do{
        String newProductType = console.readString("Enter product type (" + (orderInterface.editOrder(date1, orderNumber1).getProductType()) + "):");
        if (newProductType.isEmpty()) {
            console.write("\n");
            proceed = true;
        } else if (productArrayList.contains(newProductType)){
        //} else if (newProductType.equals("Tile") || newProductType.equals("Carpet") || newProductType.equals("Laminate") || newProductType.equals("Wood")){
            orderInterface.editOrder(date1, orderNumber1).setProductType(newProductType);
            console.write("\n");
            proceed = true;
        } else {
            console.write("Not a valid product type. Please try again.\n");
            proceed = false;
        }
        } while (proceed == false);
        
        
        do{
        String newArea = console.readString("Enter area (" + (orderInterface.editOrder(date1, orderNumber1).getArea()) + "):");
        if (newArea.isEmpty()) {
            console.write("\n");
            proceed = true;
        } else {
            try{
            double newAreaDouble = Double.parseDouble(newArea);
            orderInterface.editOrder(date1, orderNumber1).setArea(newAreaDouble);
            console.write("\n");
            proceed = true;
            }
            catch (NumberFormatException ignore) {
                console.write("Invalid input.\n");
                proceed = false;
            }
        }
        } while (proceed == false);
    }

    public void controllerRemoveAnOrder() {
        String confirmation;
        String date2;
        do {
            date2 = console.readString("Please enter the date of the order (MMDDYYYY):\n");
            if (orderInterface.displayOrders(date2) == null) {
                console.write("Error. No orders exist for that date.\n");
            } else {
                console.write("\n");
            }
        } while (orderInterface.displayOrders(date2) == null);

        int orderNumber2;
        do {
            orderNumber2 = console.readInteger("Please enter the order number:\n");
            if (orderInterface.viewOrder(date2, orderNumber2) == null) {
                console.write("Error. Order does not exist.\n");
            } else {
                console.write("\n");
            }
        } while (orderInterface.viewOrder(date2, orderNumber2) == null);

        console.write("You chose to remove: " + orderInterface.viewOrder(date2, orderNumber2).toString() + "\n"
                + "Proceed? (Y/N)\n");

        confirmation = console.readString(">");
        if (confirmation.equals("Y")) {
            orderInterface.removeOrder(date2, orderNumber2);
            console.write("Order successfully removed.\n");
        } else {
            console.write("Order not removed.\n");
        }
        
    }
    
}
