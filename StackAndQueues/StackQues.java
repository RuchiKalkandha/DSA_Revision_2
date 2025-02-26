import java.util.Stack;

public class StackQues {
    // Inserting at bottom of Stack.
    // Using recursion
    public static Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        if(st.empty()) {
            st.push(x);
            return st;
        }
        int top = st.pop();
        insertAtBottom(st,x);
        st.push(top);
        return st;
    }
    static void reverse(Stack<Integer> s)
    {        if(s.empty()) return;
       int top = s.pop();
        reverse(s);
        insertAtBottom(s,top);
        
    }

    // Reversing String using Stack
    public String reverse(String S){
        Stack<Character> s = new Stack<>();
        int index = 0;
        while(index<S.length()){
            s.push(S.charAt(index));
            index++;
        }
        StringBuilder string = new StringBuilder("");
        while(!s.empty()){
            char c = s.pop();
            string.append(c);
        }
        return string.toString();
    }

    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(45);
        s.push(45);
        s.push(98);
        insertAtBottom(s,67);
        while(!s.empty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
        String str = "Hello World";

    }
}
