import java.util.*;
public class RemoveDup{

    static String remove_dup(String s){
        StringBuilder sb = new StringBuilder("");
        LinkedHashSet<Character> hs = new LinkedHashSet<>();

        for(int i = 0; i<s.length(); i++){
            hs.add(s.charAt(i));
        }
        for(char c: hs){
            sb.append(c);
        }
        return sb.toString();
    }
   
    public static void main(String args[]){
        System.out.println(remove_dup("aapnaacollege"));
    }
}