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

    // method to add node at first  // time complexity O(1)
    public void addFirst(int data){
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

    public void printinfLinkedList(Node head){
        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }
        Node headCopy = head;
        while(headCopy != null){
            System.out.println(headCopy.data);
            headCopy = headCopy.next;
        }
    }


    public static void main(String[] args){
        LinkedList1 ll1 = new LinkedList1();
        ll1.addFirst(2);
        ll1.addFirst(1);
        ll1.addLast(3);
        ll1.addLast(4);
        ll1.printinfLinkedList(head);
    }
}
