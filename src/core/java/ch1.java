package core.java;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author eric
 */
public class ch1 {

    public void ex1(){
        System.out.print("Enter an int: ");
        try (Scanner in = new Scanner(System.in)) {
            int userVal = in.nextInt();
            System.out.println("As binary: " + Integer.toBinaryString(userVal));
            System.out.println("As ocatal: " + Integer.toOctalString(userVal));
            System.out.println("As hex: " + Integer.toHexString(userVal));
            
            double recip = 1 / Double.valueOf(userVal);
            System.out.println("Recip hex: " + Double.toHexString(recip));
        }
    }
    
    public void ex2(){
        System.out.print("Enter an int: ");
        try (Scanner in = new Scanner(System.in)) {
            int angle = in.nextInt();
            int normalized;
            
            if(angle < 0){
                int deg = angle % 360;
                normalized = 360 - Math.abs(deg);
            }else{
                normalized = angle % 360;
            }
            
            System.out.println("Your angle is equal to: " + normalized);
            
            normalized = Math.floorMod(angle, 360);
            System.out.println("With floor mod: " + normalized);
        }
    }
    
    public void ex3(){
        System.out.print("Enter 3 ints: ");
        try (Scanner in = new Scanner(System.in)) {
            int int1 = in.nextInt();
            int int2 = in.nextInt();
            int int3 = in.nextInt();
            
            int max;
            if(int1 < int2){
                max = int2 < int3 ? int3 : int2;
            }else{
                max = int1 < int3 ? int3 : int1;
            }
            System.out.println("Conditional: " + max);
            
            int maxM = Math.max(Math.max(int1, int2), int3);
            System.out.println("Max with Math: " + maxM);
        }
    }
    
    public void ex4(){
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
    }
    
    public void ex5(){
        double maxD = Double.MAX_VALUE;
        int cast = (int) maxD;
        System.out.println(maxD);
        System.out.println(cast);
        System.out.println(Integer.MAX_VALUE);
    }
    
    public void ex6(){
        System.out.println(factorial(BigInteger.valueOf(1000)));
    }
    
    private BigInteger factorial(BigInteger num){
        if(num.compareTo(BigInteger.ONE) == 0) 
            return BigInteger.ONE;
        else{
            return num.multiply(factorial(num.subtract(BigInteger.ONE)));
        }
    }
    
    public void ex7(){
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Enter two shorts between 0 and 65535: ");
            short first = (short)(in.nextInt() - Short.MAX_VALUE - 1);
            short second = (short)(in.nextInt() - Short.MAX_VALUE - 1);
            
            System.out.println("sum: " + 
                ((first + Short.MAX_VALUE + 1) + (second + Short.MAX_VALUE + 1)));
            System.out.println("diff: " + 
                ((first + Short.MAX_VALUE + 1) - (second + Short.MAX_VALUE + 1)));
            System.out.println("product: " + 
                ((first + Short.MAX_VALUE + 1) * (second + Short.MAX_VALUE + 1)));
            System.out.println("quotient: " + 
                ((first + Short.MAX_VALUE + 1) / (second + Short.MAX_VALUE + 1)));
            System.out.println("remainder: " + 
                ((first + Short.MAX_VALUE + 1) % (second + Short.MAX_VALUE + 1)));
        }
    }
    
    public void ex8(){
        try(Scanner in = new Scanner(System.in)){
            System.out.print("Enter a string: ");
            String line = in.nextLine();
            for(char sub : line.toCharArray()){
                if(!String.valueOf(sub).equals("")) System.out.println(sub);
            }
        }
    }
    
    public void ex9(){
        char[] chars = {'w', 'o', 'r', 'l', 'd'};
        String bulitWorld = String.valueOf(chars);
        String literalWorld = "world";
        
        if(bulitWorld.equals(literalWorld)) System.out.println("equals passes");
        if(bulitWorld != literalWorld) System.out.println("but not same object");
    }
    
    public void ex10(){
        System.out.println("random string: " + 
                Long.toString(Math.abs((new Random()).nextLong()), 36).toUpperCase());
    }
    
    public void ex11(){
        String input = "eéaàlmč";
        for(char ch : input.toCharArray()){
            if(ch < 128) continue; // ascii value
            System.out.println("character: " + ch);
            System.out.println("Unicode value: " + 
                    String.format("\\U+%04x", (int) ch).toUpperCase());
        }
    }
    
    public void ex12(){
        //couldn't find any
    }
    
    public void ex13(){
        List<Integer> winningNums = Arrays.stream(IntStream.range(1, 47).toArray())
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
                    Collections.shuffle(collected);
                    return collected.stream();
                }))
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
        
        System.out.println("Winning numbers are: " + winningNums.toString());
    }
    
    public void ex13b(){
        List<Integer> nums = IntStream.range(1, 47).boxed().collect(Collectors.toList());
        Collections.shuffle(nums);
        nums = nums.subList(0, 6);
        nums.sort(null);
        System.out.println("Winning numbers: " + nums);
    }
    
    public void ex14(){
        List<List<Integer>> all = new ArrayList<>();
        
        System.out.println("Enter numbers:");
        
        try(Scanner in = new Scanner(System.in)){
            String line = in.nextLine();
            while(line.length() > 0){
                List<Integer> vals = Arrays.stream(line.trim().split("\\s{1,}"))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());
                all.add(vals);
                line = in.nextLine();
            }
            System.out.println("done");
        }
        
        boolean isMagic = true;
        final int total = all.get(0).stream().mapToInt(Integer::valueOf).sum();
        int tempTotal = 0;
        
        //Check horizontal
        for(List<Integer> head : all){
            
            tempTotal = head.stream().mapToInt(Integer::valueOf).sum();
            
            isMagic = tempTotal == total;
            tempTotal = 0;
        }
        
        if(!isMagic){
            System.out.println("not magic horizontal");
            return;
        }
        
        //check vertical
        for(int i = 0; i < all.size(); i++){
            for(List<Integer> vals : all){
                tempTotal += vals.get(i);
            }
            
            isMagic = tempTotal == total;
            tempTotal = 0;
        }
        
        if(!isMagic){
            System.out.println("not magic vertical");
            return;
        }
        
        //check diagonals
        for(int i=0; i<all.size(); i++){
            tempTotal += all.get(i).get(i);
        }
            
        isMagic = tempTotal == total;
        if(!isMagic){
            System.out.println("not magic diag 1");
            return;
        }
        tempTotal = 0;
        
        for(int i=all.size() -1; i >= 0; i--){
            tempTotal += all.get(i).get(i);
        }
        
        isMagic = tempTotal == total;
        if(!isMagic){
            System.out.println("not magic diag 2");
            return;
        }
        System.out.println("is magic!");
    }
    
    public void ex15(){
        final int pNum;
        try(Scanner in = new Scanner(System.in)){
            pNum = in.nextInt();
        }
        
        List<List<Integer>> triangle = new ArrayList<>();
        for(int i=1; i <= pNum; i++){
            List<Integer> row = new ArrayList<>();
            switch (i) {
                case 1:
                    row.add(1);
                    break;
                case 2:
                    row.addAll(Arrays.asList(1, 1));
                    break;
                default:
                    List<Integer> top = triangle.get(i - 2);
                    row.add(1);
                    for(int j=0; j<top.size()-1; j++){
                        row.add(top.get(j) + top.get(j+1));
                    }   row.add(1);
                    break;
            }
            
            triangle.add(row);
        }
        
        triangle.forEach((row) -> {
            System.out.println(row);
        });
    }
}
