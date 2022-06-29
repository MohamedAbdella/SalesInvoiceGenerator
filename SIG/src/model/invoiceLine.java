/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Bebo
 */
public class invoiceLine {
    private String itemName;
    private double unitPrice; 
    private int count;
    private invoiceHeader header;

    public invoiceLine(String itemName, double unitPrice, int count, invoiceHeader header) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.count = count;
        this.header = header;
    }

    public invoiceHeader getHeader() {
        return header;
    }

    public void setHeader(invoiceHeader header) {
        this.header = header;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getLinetotal() {
        return count*unitPrice;
    }

    @Override
    public String toString() {
        return "invoiceLine{" + "itemName=" + itemName + ", unitPrice=" + unitPrice + ", count=" + count + ", linetotal=" + getLinetotal() + '}';
    }

    
    
    
    
}
