package core.java;

import java.util.ArrayList;

/**
 *
 * @author eric
 */
public class Stack<E> {
    
    ArrayList<E> elems;
    int pos;
    
    public Stack(){
        this.elems = new ArrayList<>();
        pos = -1;
    }
    
    public E pop(){
        if(pos == 0){
            return null;
        }else{
            return elems.get(pos--);
        }
    }
    
    public void push(E elm){
        elems.add(elm);
        pos++;
    }
    
    public boolean isEmpty(){
        return pos == -1;
    }
}
