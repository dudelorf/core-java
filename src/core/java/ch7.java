package core.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 *
 * @author eric
 */
public class ch7 {
    public void ex1(){
        int n = 60;
        int i = n;
        
        Set<Integer> ints = new HashSet<>();
        while(i >= 2){
            ints.add(i--);
        }
        
        i = 2;

        while(Math.pow(i, 2) < n){
            Iterator<Integer> itr = ints.iterator();
            while(itr.hasNext()){
                Integer nxt = itr.next();
                if(nxt != i && nxt % i == 0){
                    itr.remove();
                }
            }
            i++;
        }
        System.out.println(ints);
    }
    
    public void ex2(){
        ArrayList<String> strings = new ArrayList<>();
        Random gen = new Random();
        for(int i = 0; i<10; i++){
            Integer next = gen.nextInt(10000000);
            strings.add(Integer.toString(next, 32));
        }
        
        Iterator<String> itr = strings.iterator();
        ArrayList<String> uppers = new ArrayList<>();
        while(itr.hasNext()){
            String nxt = itr.next();
            uppers.add(nxt.toUpperCase());
        }
        System.out.println(strings);
        System.out.println(uppers);
    }
    
    public void ex2b(){
        ArrayList<String> strings = new ArrayList<>();
        Random gen = new Random();
        for(int i = 0; i<10; i++){
            Integer next = gen.nextInt(10000000);
            strings.add(Integer.toString(next, 32));
        }
        
        for(int j = 0; j<10; j++){
            strings.set(j, strings.get(j).toUpperCase());
        }
        
        System.out.println(strings);
    }
    
    public void ex2c(){
        ArrayList<String> strings = new ArrayList<>();
        Random gen = new Random();
        for(int i = 0; i<10; i++){
            Integer next = gen.nextInt(10000000);
            strings.add(Integer.toString(next, 32));
        }
        
        strings.replaceAll(String::toUpperCase);
        
        System.out.println(strings);
    }
    
    public void ex3(){
        Random gen = new Random();
        Set<Integer> s1 = IntStream
                 .generate(() -> gen.nextInt(10))
                 .limit(5)
                 .boxed()
                 .collect(Collectors.toSet());
         
        Set<Integer> s2 = IntStream
                 .generate(() -> gen.nextInt(10))
                 .limit(5)
                 .boxed()
                 .collect(Collectors.toSet());
        
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        
        Set<Integer> union = new HashSet<>();
        union.addAll(s1);
        union.addAll(s2);
        System.out.println("union: " + union);
        
        Set<Integer> difference = new HashSet<>();
        Set<Integer> d1 = new HashSet(s1);
        d1.removeAll(s2);
        Set<Integer> d2 = new HashSet(s2);
        d2.removeAll(s1);
        difference.addAll(d1);
        difference.addAll(d2);
        System.out.println("difference: " + difference);
        
        Set<Integer> intersection = new HashSet<>();
        intersection.addAll(union);
        intersection.removeAll(difference);
        System.out.println("intesection: " + intersection);
    }
    
    public void ex7(){
        try{
            Map<String, Integer> wordMap = new HashMap<>();
            
            List<String> lines = Files.readAllLines(Paths.get("src/resources/words.txt"));
            
            lines.stream().map((line) -> line.replaceAll("[^\\p{IsAlphabetic} ]", "")
                .toLowerCase().split("\\s")).forEachOrdered((words) -> {
                    for(String word : words){
                        if(word.equals("")) continue;
                        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                    }
            });
            List<Entry<String, Integer>> pairs = new ArrayList<>(wordMap.entrySet());
            pairs.<Comparator<Entry<String, Integer>>>sort((e1, e2) -> {
                return -Integer.compare(e1.getValue(), e2.getValue());
            });
            
            System.out.println(pairs);
        }catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }
}
