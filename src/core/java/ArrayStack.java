package core.java;

import java.lang.reflect.Array;

/**
 *
 * @author eric
 */
public class ArrayStack<E> {
    
    E[] elems;
    int pos;
    
    public ArrayStack(Class<E> c){
        elems = (E[]) Array.newInstance(c, 10);
        pos = -1;
    }
    
    public void push(E elem){
        if(pos == elems.length - 1){
            E[] newElems = (E[]) Array.newInstance(elem.getClass(), pos * 2);
            System.arraycopy(elems, 0, newElems, 0, elems.length);
            elems = newElems;
        }
        elems[++pos] = elem;
    }
    
    public E pop(){
        if(pos == -1){ 
            return null; 
        }else{
            return elems[--pos];
        }
    };
    
    public boolean isEmpty(){
        return pos == -1;
    }
}
