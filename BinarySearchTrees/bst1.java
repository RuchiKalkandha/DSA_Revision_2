import java.util.ArrayList;
public class bst1{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // insertion in bst
    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            // left subtree
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    // search in bst
    public static boolean search(Node root, int key){
        if(root == null) return false;
        if(root.data == key) return true;
        if(root.data > key) return search(root.left, key);
        else return search(root.right, key);

    }
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    // Deleting a Node in a BST
    public static Node delete(Node root, int val){
        if(root.data < val) root.right = delete(root.right, val);
        else if(root.data > val) root.left = delete(root.left, val);
        else{//root.data == value //isi node ko hme delete krna h
            if(root.left == null && root.right == null) return null;
            // case 2:
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            // Case 3:
            // find inorder successor
            Node is = findInOrderSuccessor(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data);
        }
        return root;
    }
    public static Node findInOrderSuccessor(Node root){
        while(root.left!= null)
        root = root.left;
        return root;
    }
    // printing path function
    public static void printPath(ArrayList<Integer> arr){
        for(int i = 0; i<arr.size()-1;i++){
            System.out.print(arr.get(i) + "->");
        }
        System.out.println(arr.get(arr.size()-1));
        
    }
    // print all paths from root to leaf
    public static void printAllPaths(Node root, ArrayList <Integer> arr){
        if(root == null) return;
        arr.add(root.data);
        if(root.left == null && root.right == null) printPath(arr);
        if(root.left != null) printAllPaths(root.left,arr);
        if(root.right != null) printAllPaths(root.right, arr);
        arr.remove(arr.size()-1);
    }
    
    public static void main(String args[]){
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for(int i = 0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        // inOrder(root);
        // System.out.println();
        // System.out.print(search(root, 4));
        // root = delete(root,1);
        // System.out.println();
        inOrder(root);
        System.out.println();
        ArrayList<Integer> arr = new ArrayList<>();
        printAllPaths(root, arr);
    }
}