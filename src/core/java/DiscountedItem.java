package core.java;

/**
 *
 * @author eric
 */
public class DiscountedItem extends Item{
    
    double discount;
    
    public DiscountedItem(double price, String sku, double discount){
        super(price, sku);
        this.discount = discount;
    }
    
    @Override
    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        if(!(other instanceof DiscountedItem)){
            return false;
        }
        if(other.getClass() == Item.class){
            return super.equals(other);
        }
        DiscountedItem asDI = (DiscountedItem) other;
        if(Double.compare(price, asDI.price) != 0){
            return false;
        }else if(!sku.equals(asDI.sku)){
            return false;
        }else{
            return Double.compare(discount, asDI.discount) == 0;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.discount) ^ (Double.doubleToLongBits(this.discount) >>> 32));
        return hash;
    }
}
