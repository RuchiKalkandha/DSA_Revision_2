import java.util.*;
public class StackusingCollectionsFramework {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(9);
        s.push(900);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
