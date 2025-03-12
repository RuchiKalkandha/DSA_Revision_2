import java.util.Stack;

public class NextGreaterElement {
    void nextGreater(int arr[]){
        int[] nsr = new int[arr.length];
     Stack<Integer> s = new Stack<>();
    for(int i = arr.length-1; i>=0; i--){
        while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
            s.pop();
        }
        if(s.isEmpty()){
            nsr[i] = arr.length;
        }
        else{
            nsr[i] = s.peek();
        }
        s.push(i);
    }
}
}
