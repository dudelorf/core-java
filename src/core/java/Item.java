package core.java;

import java.util.Objects;

/**
 *
 * @author eric
 */
public class Item {
    
    double price;
    String sku;
    
    public Item(double price, String sku){
        this.price = price;
        this.sku = sku;
    }
    
    @Override
    public boolean equals(Object other){
        if(other == this){
            return true;
        }
        if(other == null){
            return false;
        }
        if(!(other instanceof Item)){
            return false;
        }
        Item otherItem = (Item) other;
        
        if(Double.compare(price, otherItem.price) != 0){
            return false;
        }else {
            return sku.equals(otherItem.sku);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.sku);
        return hash;
    }
}
