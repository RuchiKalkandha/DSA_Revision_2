// Stack using ArrayList
import java.util.ArrayList;
public class Stackb {
    static class Stack1{
        static ArrayList<Integer> list = new ArrayList<>();
        public boolean isEmpty(){
            return list.size() == 0;
        }
        // push    O(1)
        public void push(int data){
            list.add(data); //O(1)
        }
        // peek   O(1)
        public int peek(){
            if(isEmpty()) return -1;
            return list.get(list.size()-1);  //O(1)
        }
        // pop  O(1)
        public int pop(){
            if(isEmpty()) return -1;
            int top = list.get(list.size()-1);  //O(1)
            list.remove(list.size()-1);   //O(1)
            return top;
        }

    }
        public static void main(String args[]){
            Stack1 s = new Stack1();
            s.push(1);
            s.push(2);
            s.push(3);

            while(!s.isEmpty()){
                System.out.println(s.peek());
                s.pop();
            }
        }
    }

