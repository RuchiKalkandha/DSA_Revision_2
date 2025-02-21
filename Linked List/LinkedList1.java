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


    public static void main(String[] args){
        LinkedList1 ll1 = new LinkedList1();
        ll1.addFirst(2);
        ll1.addFirst(1);
        ll1.addLast(3);
        ll1.addLast(4);
        ll1.printinfLinkedList();
        System.out.println(ll1.SizeofLL());
        ll1.insertAtMiddle(3, 9);
        ll1.printinfLinkedList();
        System.out.println(ll1.SizeofLL());
        ll1.insertAtMiddle(0, 0);
        ll1.printinfLinkedList();
        System.out.println(ll1.SizeofLL());
        ll1.removeFirst();
        ll1.printinfLinkedList();
        System.out.println(ll1.SizeofLL());
        ll1.removeLast();
        ll1.printinfLinkedList();
        System.out.println(ll1.SizeofLL());
    }
}
