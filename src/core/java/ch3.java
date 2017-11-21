package core.java;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 *
 * @author eric
 */
public class ch3 {
    
    public void ex2(){
        class FX {
            Measurable largest(Measurable[] objects){
                return Stream.of(objects)
                    .max((m1, m2) -> Double.compare(m1.getMeasure(), m2.getMeasure()))
                    .orElse(null);
            }
        }
        
        Measurable[] objs = new Measurable[4];
        
        objs[0] = new Employee("bob", 12313213);
        objs[1] = new Employee("joe", 999999999);
        objs[2] = new Employee("francis", 108789790);
        objs[3] = new Employee("andy", 555555);
        
        Employee big = (Employee) new FX().largest(objs);
        
        System.out.println(big.getName());
    }
    
    public void ex4(){
        IntSequence seq = IntSequence.of(1, 3, 4, 55, 22);
        while(seq.hasNext()){ System.out.println(seq.next()); }
    }
    
    public void ex7(){
        ArrayList<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList("one", "banana", "toad", "strawberry", "pool"));
        luckySort(strings, String::compareTo);
    }
    
    public void ex8(){
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(new Greeter("bob", 10000));
        ex.execute(new Greeter("doge", 10000));
        ex.shutdown();
    }
    
    public void ex9a(){
        runTogether(new Greeter("phyilis", 500), 
                    new Greeter("agnes", 500),
                    new Greeter("Borris", 500),
                    new Greeter("Frank", 500));
        System.out.println("Finished!");
    }
    
    public void ex9b(){
        runInOrder(new Greeter("phyilis", 10000), 
                    new Greeter("agnes", 10000),
                    new Greeter("Borris", 10000),
                    new Greeter("Frank", 10000));
        System.out.println("Done");
    }
    
    public void ex10(){
        File f = new File("/home/eric");
        
        File[] dirs1 = f.listFiles(sf -> sf.isDirectory());
        File[] dirs2 = f.listFiles(File::isDirectory);
        File[] dirs3 = f.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        
        System.out.println(Arrays.toString(dirs1));
        System.out.println(Arrays.toString(dirs2));
        System.out.println(Arrays.toString(dirs3));
    }
    
    public void ex11(){
        File dir = new File("/home/eric/projects/core-java/src/core/java");
        String[] files = dir.list((d, name) -> { 
            return name.startsWith("ch");
        });
        Arrays.asList(files).stream().forEach(System.out::println);
    }
    
    public void ex12(){
        File dir = new File("/home/eric");
        File[] files = dir.listFiles();
        List<File> list = Arrays.asList(files);
        list.sort((f1, f2) -> {
            if(f1.isDirectory() && !f2.isDirectory()){
                return -1;
            }else if(f2.isDirectory() && !f1.isDirectory()){
                return 1;
            }else{
                return f1.getName().compareTo(f2.getName());
            }
        });
        list.stream().forEach(System.out::println);
    }
    
    public void ex13(){
        runAll(new Greeter("phyilis", 3), 
                    new Greeter("agnes", 3),
                    new Greeter("Borris", 3),
                    new Greeter("Frank", 3)
        ).run();
    }
    
    public void ex14(){
        Employee[] emps = {
            new Employee("joe bob", 100),
            new Employee("anders", 100),
            new Employee("boss hogs", 5000000),
            new Employee("xavier", 20)
        };
        Arrays.sort(emps, Comparator
            .comparing(Employee::getSalary)
            .thenComparing(Employee::getName, Comparator.reverseOrder())
        );
        Arrays.stream(emps).forEach(System.out::println);
    }
    
    public void ex15(){
        
    }
    
    public void luckySort(ArrayList<String> strings, Comparator<String> comp){
        ArrayList<String> cp;
        int count = 0;
        do{
            Collections.shuffle(strings);
            cp = new ArrayList<>(strings);
            cp.sort(comp);
            count++;
        }while(!cp.equals(strings));
        System.out.println("Took : " + count);
    }
    
    public void runTogether(Runnable ... tasks){
        ExecutorService ex = Executors.newCachedThreadPool();
        for(Runnable t : tasks){
            ex.execute(t);
        }
        ex.shutdown();
        try{
            ex.awaitTermination(1, TimeUnit.DAYS);
        }catch(InterruptedException exc){
            exc.printStackTrace();
        }
    }
    
    public void runInOrder(Runnable ... tasks){
        for(Runnable t : tasks){
            t.run();
        }
    }
    
    public Runnable runAll(Runnable ... tasks){
        return () -> { for(Runnable t : tasks){ t.run(); } };
    };
    
    public static class RandomSequence implements IntSequence{
        
        private final Random gen;
        private final int low;
        private final int high;
        
        public RandomSequence(int low, int high){
            gen = new Random();
            this.low = low;
            this.high = high;
        }
        
        @Override
        public int next(){
            return low + gen.nextInt(high - low + 1);
        }
        
    }
    
}
