public class LinkedList1 {

    // nodes are connected using llinks
    // typically each node has two parts
    // first is the data
    // and second is the pointer(reference variable) to next node.
   

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //  head and tail are two important nodes whose data we typically store.
    // head is the first node with data in the linkedlist
    // tail refers to the last node in linkedlist with data(null is nnot the tail node).

    public static Node head;
    public static Node tail;
    public static int size;

    // method to add node at first  // time complexity O(1)
    public void addFirst(int data){
        size++;
        // creating new node
        Node newNode = new Node(data);
        // if node empty:
        if(head == null){
            head = tail = newNode;
            return;
        }
        // otherwise:
        // purane head k aage lgadenge isko
        newNode.next = head;
        // head bnadenge is newNode ko
        head = newNode;
    }

    // method to add node at last  //O(n) time complexity
    // instead of using head, if we had a tail pointer given it would have a time complexity O(1)
    public void addLast(int data){
        size++;
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        Node headCopy = head;
        while(headCopy.next != null){
            headCopy = headCopy.next;
        }
        headCopy.next = newNode;

    }

    // printing a linked list 

    public void printinfLinkedList(){
        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }
        Node headCopy = head;
        while(headCopy != null){
            System.out.print(headCopy.data + " ");
            headCopy = headCopy.next;
        }
        System.out.println();
        System.out.println("size of Linked List is: " + size);
    }

    // adding an element in middle of Linked List
    public void insertAtMiddle(int index, int data){
        Node newNode = new Node(data);
        Node headCopy = head;
        if(index == 0){
            addFirst(data);
            return;
        }
        size++;
        int i = 0;
        while(index-1 != i){
            headCopy = headCopy.next;
            i++;
        }
       
        newNode.next = headCopy.next;
        headCopy.next = newNode;
    }

    public int SizeofLL(){
        int i =0;
        Node headCopy = head;
        while(headCopy != null){
            headCopy = headCopy.next;
            i++;
        }
        return i;
    }

    // removing node from beginning of linked list //
    public void removeFirst(){
        if(size != 0){
            size--;
        }
        if(head.next == null || head == null){
            head = tail = null;
            return;
        }

        head = head.next;
        // garbage collector will delete the prev node automatically.
        // as there is no way we can reach to this node as there is no link back
    }

    // remove from last
    public void removeLast(){
        if(head == null){
            return;
        }
        if(head.next == null){
            size--;
            head = tail = null;
            return;
        }
        Node headCopy=head;
        size--;
        while(headCopy.next.next != null){
            headCopy = headCopy.next;
        }
        headCopy.next = null;
        tail = headCopy.next;
    }

    // iterative search in a Linked List //O(n) time complexity
    // returning first index at which element is stored
      public int linearSearch_iterative(int key){
        int i =0;
        Node temp = head;
        while(temp != null){
            if(temp.data == key) return i;
            i++;
            temp = temp.next;
        }
        // key not in Linked List
        return -1;
      }

    //   helper function for recursive search //O(n)
    public int helper(Node head, int key){
        if(head == null) return -1;
        if(head.data == key) return 0;
        int idx = helper(head.next,key);
        if(idx == -1) return -1;

        return idx +1;
    }

      public int recursive_search(int key){
            return helper(head, key);
      }

    // Reversing a Linked List // it returns the head Node
    // O(n) time complexity
    public Node reversing_LinkedList(){
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node curr = head;
        tail = head;
        Node Next = curr.next;

        while(curr.next != null){
            curr.next = prev;
            prev = curr;
            curr = Next;
            Next = curr.next;
        }
        curr.next = prev;
        prev = curr;
        head = prev;
        return head;
    }

    // find and remove nth Node from end
    // iterative approach // O(n) time complexity
    // nth Node from end = (size-n+1)th Node from beginning
    // jo node hme remove krni h us se ek phle vali node tk hm prev ko leke jaenge
    // or fr prev.next == prev.next.next krdenge jis se node delete hojaega LinkedList se
    public void removeNthFromEnd(int n){
        Node prev = head;
        int i =1; // we here consider head node as 1st node.
        int nb = size - n +1;

        // if nb = size or n = 1, meaning deleting the last node
        if(nb == size){
            removeLast();
            return;
        }
        // if nb = 1 or n = size, meaning deleting the first node
        if(nb == 1){
            removeFirst();
            return;
        }

        while(nb-1 != i){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        size--;
    }

    // Checking if Linked List is a palindrome
    // palindrome ko aage se pdho ya piche se, vo same hote h
    // 1->2->1->null
    // the brute force approach will be to copy Linked List elements into an
    // array or ArrayList or String and check if that is a palindrome
    // this approach will have O(n) Time Complexity and O(n) Space Complexity.
    // but we will use an optimised approach which will have O(1), constant Space Complexity.
    // and O(n) Time Complexity.
    // in this we will use slow-fast concept and reversing half Linked List concept.
    // Step 1: find MidNode, Step2: second half reverse krdenge, Step 3: check if 1st half == second half
    // we will have 2 cases, even and odd based on the size of LinkedList.


    // finding mid node in linkedlist
    // Step1: for finding MidNode, we will use slow fast approach,
    // we will have 2 reference Nodes, slow(turtle) and fast(hare(khargosh)), slow will move by +1, fast will move by +2.
    // for even, jb tk fast null ni ho jata, we will keep moving, and when fast is null, slow will be at middle position
    // slow = mid
    // for odd, fast tail element p rukjaega bcz vo 2 jump leta h ot tail element k bd
    // null h so tail se 2 jump is not possible, hence fast tail p aake rukjaenga
    // so we will keep moving slow and fast till fast.next becomes null,
    // at this point slow will be at mid
    // so we can generalise that when fast == null or fast.next == null, then our slow is at mid in a linked list
    // writing code to find mid Node in a LinkedList.
    // it will return mid node
    public Node findingMid(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;  //+1
            fast = fast.next.next; //+2
        }
        return slow;
    }

    // for reversing second half, our mid will become head and we will aplly reverse method till tail
    // then we will have two LinkedLists, whose heads we will compare and then we will compare the next coming nodes.
    // backward traverse krne k lia hmne reverse kia
    public boolean checkPalindrome(){
        if(head == null || head.next==null){
            return true;
        }
        // Step1: finding midNode
        Node midNode = findingMid();
        // Step2: reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node Next;

        while(curr != null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }

        Node right = prev; // right half head
        Node left = head; //left half head

        // Step 3: checking if right half is equal to left half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public static void main(String[] args){
        // LinkedList1 ll1 = new LinkedList1();
        // ll1.addFirst(2);
        // ll1.addFirst(1);
        // ll1.addLast(3);
        // ll1.addLast(4);
        // ll1.printinfLinkedList();
        // System.out.println(ll1.SizeofLL());
        // ll1.insertAtMiddle(3, 9);
        // ll1.printinfLinkedList();
        // System.out.println(ll1.SizeofLL());
        // ll1.insertAtMiddle(0, 0);
        // ll1.printinfLinkedList();
        // System.out.println(ll1.SizeofLL());
        // ll1.removeFirst();
        // ll1.printinfLinkedList();
        // System.out.println(ll1.SizeofLL());
        // ll1.removeLast();
        // ll1.printinfLinkedList();
        // System.out.println(ll1.SizeofLL());
        // System.out.println(ll1.linearSearch_iterative(9));
        // System.out.println(ll1.recursive_search(9));
        // ll1.addLast(19);
        // ll1.addLast(20);
        // ll1.printinfLinkedList();
        // System.out.println(ll1.SizeofLL());
        // ll1.reversing_LinkedList();
        // ll1.printinfLinkedList();
        // ll1.removeNthFromEnd(3);
        // ll1.printinfLinkedList();
        // System.out.println(ll1.SizeofLL());
        // ll1.removeNthFromEnd(1);
        // ll1.printinfLinkedList();
        // System.out.println(ll1.SizeofLL());
        // ll1.removeNthFromEnd(size);
        // ll1.printinfLinkedList();
        // System.out.println(ll1.SizeofLL());
        LinkedList1 ll2 = new LinkedList1();
        ll2.addLast(1);
        ll2.addLast(2);
        ll2.addLast(2);
        ll2.addLast(1);
        ll2.printinfLinkedList();
        System.out.println(ll2.checkPalindrome());
        ll2.printinfLinkedList();
    }
}
