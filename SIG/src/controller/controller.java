
package controller;

import SIG.NewJFrame;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.InvoiceLineTableModel;
import model.invoiceHeader;
import model.invoiceHeaderTableModel;
import model.invoiceLine;


public class controller implements ActionListener , ListSelectionListener{
   private NewJFrame frame;
   
    public controller(NewJFrame frame){
       this.frame=frame;
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand=e.getActionCommand();
        switch(actionCommand)
        {
            case "load files ":
                loadFiles();
                break;
                
            case "save file":
                saveFiles();
                  break;
                  
            case  "create invoice":
                createInvoice();
                  break;
                  
            case "delete invoice":
                deleteInvoice();
                  break;
                  
            case "Create line":
                createLine();
                  break;
                  
            case " delete line":
                deleteLine();
                  break;
        
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Row selected");
        int selectedrow= frame.getInvHeaderTable().getSelectedRow();
        System.out.println(selectedrow);
          ArrayList<invoiceLine> lines=  frame.getInvoiceHeaderList().get(selectedrow).getLines();
        frame.getInvLineTable().setModel(new InvoiceLineTableModel(lines));
    }

    private void loadFiles()  {
        
        
        JFileChooser jf=new JFileChooser();
        int result= jf.showOpenDialog(frame);
        if(result==JFileChooser.APPROVE_OPTION){
            try {
                File headerFile = jf.getSelectedFile();
                String headerpath=headerFile.getAbsolutePath();
                Path headerPath=Paths.get(headerpath);
                List<String> headerLines = Files.lines(headerPath).collect(Collectors.toList());
                ArrayList<invoiceHeader> invoiceHeaderList = new ArrayList<>();
                
                for(String headerLine : headerLines){
                    String[] parts = headerLine.split("  ,  ");
                    
                    int id = Integer.parseInt(parts[0]);
                    invoiceHeader invHeader = new invoiceHeader(id, parts[2], parts[1]);
                    invoiceHeaderList.add(invHeader);
                }
                
                result = jf.showOpenDialog(frame);
                if(result == JFileChooser.APPROVE_OPTION){
                    
                    String lineStrPath=jf.getSelectedFile().getAbsolutePath();
                    Path linePath= Paths.get(lineStrPath);
                    List<String> lineLines = Files.lines(linePath).collect(Collectors.toList());
                    for (String lineline : lineLines){
                        String[] parts = lineline.split("  ,  ");
                        
                        int invid=Integer.parseInt(parts[0]);
                        double price = Double.parseDouble(parts[2]);
                        int count= Integer.parseInt(parts[3]);
                        invoiceHeader header= getinvoiveHeaderByID(invoiceHeaderList, invid);
                        invoiceLine invLine = new invoiceLine(parts[1], price, count, header);
                        header.getLines().add(invLine);
                    }
                    frame.setInvoiceHeaderList(invoiceHeaderList);
                }
            } catch (IOException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
           
        }
    }
    private invoiceHeader getinvoiveHeaderByID(ArrayList<invoiceHeader> invoices , int id){
      for(invoiceHeader invoice : invoices){
          if(invoice.getId()== id){
          return invoice;
          }
      }
      return null;
    }

    private void saveFiles() {
        
    }

    private void createInvoice() {
        
    }

    private void deleteInvoice() {
        
    }

    private void createLine() {
        
    }

    private void deleteLine() {
        
    }
    
}
