
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bebo
 */
public class InvoiceLineTableModel extends AbstractTableModel{
    
    private ArrayList<invoiceLine> data ;
    private String[] cols = {"Item name","Unit price","count"};

    public InvoiceLineTableModel(ArrayList<invoiceLine> data) {
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
        invoiceLine line=data.get(rowIndex);
        switch(columnIndex){
          case 0:
              return line.getItemName();
            case 1:
                return line.getUnitPrice();
            case 2:
                return line.getCount();

        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
