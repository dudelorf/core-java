package core.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author eric
 */
public class ch5 {
    
    public void ex1() throws IOException{
        Path p = Paths.get("src/resources/test.txt");
        if(!Files.exists(p) || !Files.isReadable(p)){
            throw new IOException("could not open file.");
        }
        try{
            double sum = 0.0;
            for(String line : Files.readAllLines(p)){
                sum += Double.valueOf(line);
            }

            System.out.println("total is: " + sum);
        }catch(NumberFormatException exc){
            System.out.println(exc.getMessage());
        }
    }
    
    public void ex5(){
        Scanner in = null;
        PrintWriter pw = null;
        try{
            in = new Scanner(new File("src/resources/test.txt"));
            pw = new PrintWriter("src/resources/out.txt");
            while (in.hasNext()) {
                String next = in.next();
                pw.println(next);
            }
        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe.getClass().getSimpleName());
        }catch(IllegalStateException ise){
            System.out.println(ise.getClass().getSimpleName());
        }catch(NoSuchElementException nsee){
            System.out.println(nsee.getClass().getSimpleName());
        }catch(Exception ex){
            if(pw.checkError()){
                System.out.println("print writer errr");
            }else{
                System.out.println(ex.getMessage());
            }
        }finally{
            try{
                in.close();
                pw.close();
            }catch(NullPointerException npe){
                System.out.println(npe.getClass().getSimpleName());
            }
        }
    }
    
    public void ex6a(){
        //catch exc in finally
        BufferedReader in = null;
        try{
            in = Files.newBufferedReader(Paths.get(""), StandardCharsets.UTF_8);
        }catch(IOException exc){
            System.err.println(exc.getMessage());
        }finally{
            if(in != null){
                try{
                    in.close();
                }catch(IOException exc){
                    System.out.println(exc.getMessage());
                }
            }
        }
    }
    
    public void ex6b(){
        //try/catch containing a try/finally
        BufferedReader in = null;
        try{
            in = Files.newBufferedReader(Paths.get(""), StandardCharsets.UTF_8);
            if(in != null){
                try{
                    in.close();
                }catch(IOException exc){
                    System.out.println(exc.getMessage());
                }
            }
        }catch(IOException exc){
            System.err.println(exc.getMessage());
        }
    }
    
    public void ex6c(){
        //try with resources with catch
        try(BufferedReader in = Files.newBufferedReader(Paths.get(""), StandardCharsets.UTF_8)){
            
        }catch(IOException exc){
            System.err.println(exc.getMessage());
        }
    }
    
    public void ex8(){
        
    }
    
    public void ex10(){
        System.out.println("5! = " + factorial(5));
    }
    
    public int factorial(int n){
        if(n == 1){
            return 1;
        }else{
            Exception e = new Exception("Calling with " + n);
            e.printStackTrace();
            return n * factorial(n - 1);
        }
    }
}
