package other.thing;

import core.java.LabeledPoint;

/**
 *
 * @author eric
 */
public class TestAccess {
    
    public static void main(String[] args) {
        LabeledPoint p = new LabeledPoint("label", 3, 5);
        p.showCanAccessInClass();
        //Compilation error
        //System.out.println("x outside is " + p.x);
    }
}
