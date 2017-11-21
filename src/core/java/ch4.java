package core.java;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author eric
 */
public class ch4 {

    public void ex8(){
        ArrayList<String> al = new ArrayList<>();
        Class<?> alc = al.getClass();
        System.out.println(alc.toString());
        System.out.println(alc.getTypeName());
        System.out.println(alc.getSimpleName());
        System.out.println(alc.toGenericString());
        System.out.println(alc.getName());
        System.out.println(alc.getCanonicalName());
        System.out.println("-------------");
        int[] ia = new int[5];
        Class<?> iac = ia.getClass();
        System.out.println(iac.toString());
        System.out.println(iac.getTypeName());
        System.out.println(iac.getSimpleName());
        System.out.println(iac.toGenericString());
        System.out.println(iac.getName());
        System.out.println(iac.getCanonicalName());
        System.out.println("-------------");
        Class<?> iic = Invoice.InvoiceItem.class;
        System.out.println(iic.toString());
        System.out.println(iic.getTypeName());
        System.out.println(iic.getSimpleName());
        System.out.println(iic.toGenericString());
        System.out.println(iic.getName());
        System.out.println(iic.getCanonicalName());
        System.out.println("-------------");
        Class<?> ic = Integer.class;
        System.out.println(ic.toString());
        System.out.println(ic.getTypeName());
        System.out.println(ic.getSimpleName());
        System.out.println(ic.toGenericString());
        System.out.println(ic.getName());
        System.out.println(ic.getCanonicalName());
    }
    
    public void ex9(){
        ExecutorService exc = Executors.newFixedThreadPool(3);
        System.out.println(universalToStrin(exc));
        exc.shutdownNow();
    }
    
    public void ex10(){
        try {
            Class<?> cl = Class.forName("[I");
            for(Method m : cl.getMethods()){
                System.out.println(
                    Modifier.toString(m.getModifiers()) + " " +
                    m.getReturnType().getCanonicalName() + " " +
                    m.getName() + 
                    Arrays.toString(m.getParameters())
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ex11(){
        try{
            Field o = System.class.getField("out");
            Object outObject = o.get(null);
            Method m = outObject.getClass().getMethod("println", String.class);
            m.invoke(outObject, "hello!");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void ex12(){
        Instant start, end;
        start = Instant.now();
        for(int i = 0; i < 10000; i++){ 
            try{
                Field o = System.class.getField("out");
                Object outObject = o.get(null);
                Method m = outObject.getClass().getMethod("println", String.class);
                m.invoke(outObject, "hello!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        end = Instant.now();
        Duration diffRel = Duration.between(start, end);
        
        start = Instant.now();
        for(int i=0; i < 10000; i++){
            System.out.println("hello!");
        }
        end = Instant.now();
        Duration diffReg = Duration.between(start, end);
        
        System.out.println("reflection took " + diffRel.toMillis());
        System.out.println("Regular took " + diffReg.toMillis());
    }
    
    public String universalToStrin(Object obj){
        String out = obj.getClass().getSimpleName() + "\n";
        for(Field f : obj.getClass().getDeclaredFields()){
            out += f.getName() + "\n";
        }
        return out;
    }
}
