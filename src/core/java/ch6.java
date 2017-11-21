package core.java;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author eric
 */
public class ch6 {
    
    public void ex3(){
        Table<String, String> tbl = new Table();
        tbl.addEntry("first", "test");
        System.out.println(tbl.getValue("first"));
        tbl.updateEntry("secon", "should fail");
        tbl.updateEntry("first", "second");
        System.out.println(tbl.getValue("first"));
        tbl.removeEntry("first");
        System.out.println(tbl.getValue("first"));
    }
    
    public void ex5(){
        Double[] result = this.<Double>swap(0, 1, 1.5, 2.0, 3.0);
        System.out.println(Arrays.toString(result));
    }
    
    public void ex22() throws IOException{
        doWork(() -> 34*4, IOException::new);
    }
    
    public void ex23(){
        Class<?> c = ch6.class;
    }
    
    public static <T> T[] swap(int i, int j, T ... values){
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }
    
    public <E> ArrayList<E> addAllExtends(ArrayList<E> to, ArrayList<? extends E> from){
        from.forEach((el) -> {
            to.add(el);
        });
        return to;
    }
    
    public <E> ArrayList<? super E> addAllSuper(ArrayList<? super E> to, ArrayList<E> from){
        from.forEach((el)-> {
            to.add(el);
        });
        return to;
    }
    
    public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> results){
        List<T> cp = new ArrayList<>(elements);
        Collections.sort(cp, comp);
        results.add(cp.get(0));
        results.add(cp.get(cp.size() - 1));
    }
    
    public static void closeAll(Closeable[] elems) throws RuntimeException{
        int excps = 0;
        IOException exception = null;
        for(Closeable elem: elems){
            try{
                elem.close();
            }catch(IOException exc){
                excps++;
                if(exception == null){
                    exception = exc;
                }else{
                    exc.initCause(exception);
                    exception = exc;
                }
            }
        }
        
        if(excps > 1){
            throw new RuntimeException(exception);
        }
    }
    
    public static <T, R> ArrayList<R> map(ArrayList<? extends T> to, Function<T, R> fnc){
        ArrayList<R> out = new ArrayList<>(to.stream().map(fnc).collect(Collectors.toList()));
        return out;
    }
    
    public static <V, T extends Throwable> V doWork(Callable<V> c, Function<? super Throwable, T> fnc) throws T{
        try{
            return c.call();
        }catch(Exception exc){
            throw fnc.apply(exc);
        }
    }
}
