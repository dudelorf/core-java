package core.java;

import java.util.ArrayList;

/**
 *
 * @author eric
 */
public class Invoice {

    private ArrayList<InvoiceItem> items = new ArrayList<>();
    
    public void printInvoice(){
        items.stream().forEach(System.out::println);
        double total = items.stream().mapToDouble(InvoiceItem::price).sum();
        System.out.println("Total: " + total);
    }
    
    public static class InvoiceItem {
        String description;
        int quantity;
        double unitPrice;
        
        double price(){
            return quantity * unitPrice; 
        }
        
        @Override
        public String toString(){
            return description + " - " + quantity + 
                                 " - " + unitPrice + 
                                 " : " + price();
        }
    }
    
    public void addItem(String description, int quantity, double unitPrice){
        InvoiceItem newInvoiceItem = new InvoiceItem();
        newInvoiceItem.description = description;
        newInvoiceItem.quantity = quantity;
        newInvoiceItem.unitPrice = unitPrice;
        items.add(newInvoiceItem);
    }
    
}
