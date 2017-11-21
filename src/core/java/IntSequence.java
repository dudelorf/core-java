package core.java;

import java.util.Iterator;
/**
 *
 * @author eric
 */
public interface IntSequence{
    
    default boolean hasNext() { return true; }
    
    int next();
    
    public static IntSequence of(int ... vals){
        return new IntSequence() {
            int pos = 0;
            
            public boolean hasNext(){ return pos == vals.length; }
            public int next(){return vals[pos++];}
        };
    }
}
