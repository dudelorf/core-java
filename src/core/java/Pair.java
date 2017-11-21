package core.java;

/**
 *
 * @author eric
 */
public class Pair<E> {
    
    E first;
    E second;
    
    public Pair(E first, E second){
        this.first = first;
        this.second = second;
    }
    
    public E getFirst(){
        return first;
    }
    
    public E getSecond(){
        return second;
    }
}
