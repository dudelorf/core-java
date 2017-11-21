package core.java;

import java.util.ArrayList;

/**
 *
 * @author eric
 */
public class NetworkEx {
    
    public class Member {
        private String name;
        private ArrayList<Member> friends;
        
        public Member(String name){
            this.name = name;
            friends = new ArrayList<>();
        }
    }
    
    private ArrayList<Member> members;
}
