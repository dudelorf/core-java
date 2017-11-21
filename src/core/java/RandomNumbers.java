package core.java;

import java.util.List;
import java.util.Random;

/**
 *
 * @author eric
 */
public class RandomNumbers {
    
    private RandomNumbers(){}
    
    public static <T> T randomElement(T[] elems){
        if(elems.length == 0) return null;
        int idx = (new Random()).nextInt(elems.length -1);
        return elems[idx];
    }
    
    public static <T> T randomElement(List<T> elems){
        if(elems.isEmpty()) return null;
        int idx = (new Random()).nextInt(elems.size() -1);
        return elems.get(idx);
    }
}
