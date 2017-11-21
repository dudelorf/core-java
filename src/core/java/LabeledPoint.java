package core.java;

import java.util.Objects;

/**
 *
 * @author eric
 */
public class LabeledPoint extends Point{
    
    protected String label;
    
    public LabeledPoint(String label, double x, double y){
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.label);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabeledPoint other = (LabeledPoint) obj;
        if (!this.label.equals(other.getLabel())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" + "label=" + label + '}';
    }
    
    public void showCanAccessInClass(){
        System.out.println("x is " + x);
        System.out.println("y is " + y);
    }
    
}
