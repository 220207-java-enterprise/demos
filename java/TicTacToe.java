// Your First Program
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        String s = "we are we are to we";
        System.out.println(recurringWordII(s));
        
    }
    public static char recurringWordII(String s) {
        List<Integer> countlist = new ArrayList<Integer>();
        for (int i =0; i<s.length(); i++){
            int count = 0;
            String s1 = "";
            while(s.charAt(i) != ' '){
                s1 += s.charAt(i);
            }
            System.out.println(s1);
            for (int j=0; j<s.length(); j++){
                String s2 = "";
                while(s.charAt(j) != ' '){
                    s2 += s.charAt(j);
                }
                System.out.println(s2);
                if (s1.equals(s2)){
                    count++;
                }
            }
            countlist.add(count);
        }
        Integer max = Collections.max(countlist);
        return s.charAt(countlist.indexOf(max));
    }
    
}
