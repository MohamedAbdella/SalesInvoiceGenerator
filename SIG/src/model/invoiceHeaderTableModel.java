/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bebo
 */
public class invoiceHeaderTableModel extends AbstractTableModel{
  private ArrayList<invoiceHeader> data;
   private String[] cols = {"ID ","Name","Date"}; 

    public invoiceHeaderTableModel(ArrayList<invoiceHeader> data) {
        this.data = data;
    }
  
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
                return cols.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        invoiceHeader header=data.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                return header.getId(); 
            case 1:
                return header.getCustomerName();
            case 2:
                return header.getDate();
                
        }
                return null ;

    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    
}

