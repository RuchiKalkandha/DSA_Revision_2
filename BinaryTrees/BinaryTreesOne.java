import java.util.*;
public class BinaryTreesOne {
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

    static class BinaryTree{
        static int idx = -1; // recursion m hr level p hm chahte h ki hmara idx update ho.
        // O(n) time complexity.
        public static Node buildPreorderTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1) return null;
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildPreorderTree(nodes);
            newNode.right = buildPreorderTree(nodes);

            return newNode;
        }
        // Pre Order Traversal  O(n)
        public static void preOrder(Node root){
            if(root == null){
                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
            }

            public static void inOrder(Node root){
                if(root == null) return;
                inOrder(root.left);
                System.out.print(root.data + " ");
                inOrder(root.right);        
        }
        public static void postOrder(Node root){
            if(root == null) return;
            postOrder(root.left);
            System.out.print(root.data + " ");
            postOrder(root.right);        
    }
    // Level Order traversal
    public static void levelOrderTraversal(Node root){
        if(root == null) return;
        Queue <Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    } 
    // height of binary tree
    public static int heightOftree(Node root){
        if(root == null) return 0;
        int left_height;
        int right_height;
        left_height = heightOftree(root.left);
        right_height = heightOftree(root.right);
        return Math.max(left_height,right_height)+1;
    }
    // Nodes count
    public int nodesCount(Node root){
        if(root == null) return 0;
        int left_count = nodesCount(root.left);
        int right_count = nodesCount(root.right);
        return left_count+right_count+1;
    }
    //  nodes Sum
    public int nodesSum(Node root){
        if(root == null) return 0;
        int left_sum = nodesSum(root.left);
        int right_sum = nodesSum(root.right);
        return left_sum + right_sum + root.data;
    }
    }
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root= tree.buildPreorderTree(nodes);
        System.out.println(root.data);
        tree.preOrder(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.levelOrderTraversal(root);
        // System.out.println();
        System.out.print(tree.heightOftree(root));
        System.out.println();
        System.out.print(tree.nodesCount(root));
        System.out.println();
        System.out.print(tree.nodesSum(root));
    }
}
