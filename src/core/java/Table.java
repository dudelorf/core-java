package core.java;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *
 * @author eric
 */
public class Table<K, V> {
    
    ArrayList<Entry<K, V>> elems;
    
    public Table(){
        elems = new ArrayList<>();
    }
    
    public void addEntry(K key, V val){
        Entry<K, V> e = new KVPair<>(key, val);
        boolean contains = elems.stream()
                           .map(ent -> ent.getKey())
                           .collect(Collectors.toList())
                           .contains(key);
        if(contains){
            updateEntry(key, val);
        }else{
            elems.add(e);
        }
    }
    
    public void updateEntry(K key, V val){
        Entry<K, V> existing = elems.stream()
                               .filter(e -> e.getKey().equals(key))
                               .findFirst()
                               .orElse(null);
        if(existing == null){
            System.out.println("key doesn't exist");
        }else{
            elems.remove(existing);
            existing.setValue(val);
            elems.add(existing);
        }
    }
    
    public void removeEntry(K key){
        Entry<K, V> existing = elems.stream()
                               .filter(e -> e.getKey().equals(key))
                               .findFirst()
                               .orElse(null);
        if(existing == null){
            System.out.println("key doesn't exist");
        }else{
            elems.remove(existing);
        }
    }
    
    public V getValue(K key){
        return elems.stream()
               .filter(e -> e.getKey().equals(key))
               .findFirst()
               .map(e -> e.getValue())
               .orElse(null);
    }
    
    
    public static class KVPair<K, V> implements Entry<K, V>{

        K key;
        V val;        
        
        public KVPair(K key, V val){
            this.key = key;
            this.val = val;
        }
        
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return val;
        }

        @Override
        public V setValue(V value) {
            val = value;
            return value;
        }
        
    }
    
}
