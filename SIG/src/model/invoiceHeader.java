/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Bebo
 */
public class invoiceHeader {
    private int id;
    private String customerName;
    private String date;
    ArrayList<invoiceLine> lines;
 
    public invoiceHeader(int id, String customerName, String date) {
        this.id = id;
        this.customerName = customerName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getInvoiceTotal() {
        double total=0;
        for (invoiceLine line:getLines()){
            total+=line.getLinetotal();
    }
        return total;
    }

   
    

    @Override
    public String toString() {
        return "invoiceHeader{" + "id=" + id + ", customerName=" + customerName + ", date=" + date + '}';
    }
    
     public ArrayList<invoiceLine> getLines() {
         if(lines== null){
         lines = new ArrayList<>();
         }
        return lines;
    }

   

   
    
}
