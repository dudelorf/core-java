package core.java;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author eric
 */
public class Cache<K, V> extends LinkedHashMap{
    
    protected int size;
    
    public Cache(int size){
        this.size = size;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest){
        return size() > size;
    }
}
