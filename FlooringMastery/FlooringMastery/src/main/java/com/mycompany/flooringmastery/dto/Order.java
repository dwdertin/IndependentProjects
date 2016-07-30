/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dto;

/**
 *
 * @author apprentice
 */
public class Order {

    private int orderNumber;
    private String customerName;
    private String state;
    private double taxRate;
    private String productType;
    private double area;
    private double costPerSquareFoot;
    private double laborCostPerSquareFoot;

    private double materialCost;
    private double laborCost;
    private double tax;
    private double total;

    public Order(int orderNumber, String customerName, String state, double taxRate, String productType, double area, double costPerSquareFoot,
            double laborCostPerSquareFoot) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.state = state;
        this.taxRate = taxRate;
        this.productType = productType;
        this.area = area;
        this.costPerSquareFoot = costPerSquareFoot;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;

        materialCost = costPerSquareFoot * area;
        laborCost = laborCostPerSquareFoot * area;
        tax = (materialCost + laborCost) * (taxRate / 100);
        total = materialCost + laborCost + tax;
    }

    public String toString() {
        return orderNumber + ","
                + customerName + ","
                + state + ","
                + taxRate + ","
                + productType + ","
                + area + ","
                + costPerSquareFoot + ","
                + laborCostPerSquareFoot + ","
                + materialCost + ","
                + laborCost + ","
                + tax + ","
                + total;
    }

    /**
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the taxRate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the costPerSquareFoot
     */
    public double getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    /**
     * @param costPerSquareFoot the costPerSquareFoot to set
     */
    public void setCostPerSquareFoot(double costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    /**
     * @return the laborCostPerSquareFoot
     */
    public double getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    /**
     * @param laborCostPerSquareFoot the laborCostPerSquareFoot to set
     */
    public void setLaborCostPerSquareFoot(double laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    /**
     * @return the materialCost
     */
    public double getMaterialCost() {
        return materialCost;
    }

    /**
     * @return the laborCost
     */
    public double getLaborCost() {
        return laborCost;
    }

    /**
     * @return the tax
     */
    public double getTax() {
        return tax;
    }
    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

}
