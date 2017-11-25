package core.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author eric
 */
public class ch8 {
    
    public void ex1(){
        String[] arr = {"long", "long", "long", "nin", "long", "nin"}; 
        List<String> lngs = Arrays.stream(arr)
                            .filter(s -> {
                                System.out.println("call");
                                return s.length() > 3;
                            })
                            .limit(4)
                            .collect(Collectors.toList());
        System.out.println(lngs);
    }
    
    public void ex2(){
        try {
            int minSize = 10;
            
            long start = System.currentTimeMillis();
            
            String doc = new String(Files.readAllBytes(Paths.get("src/resources/warandpeace.txt")));
            List<String> words = Arrays.asList(doc.split("\\s"));
            
            long numWords = words.stream()
                    .filter(s -> s.length() > minSize)
                    .count();
            
            long end = System.currentTimeMillis();
            
            System.out.println("found " + numWords);
            System.out.println("Took " + (end - start));
        } catch (Exception e) {
        }
    }
    
    protected static Stream<String> letters(String s){
        return Stream.of(s.split(""));
    }
    
    protected boolean isWord(String s){
        return Stream.of(s.codePoints())
        .filter(Character::isAlphabetic)
        .count() == s.length();
    }
}
