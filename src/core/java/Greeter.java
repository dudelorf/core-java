package core.java;

/**
 *
 * @author eric
 */
public class Greeter implements Runnable{
    
    String name;
    int n;
    
    public Greeter(String name, int n){
        this.name = name;
        this.n = n;
    }
    
    public void run(){
        for (int i = 0; i < n; i++) {
            System.out.println("Hello " + name);    
        }
    }
}
