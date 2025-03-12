import java.util.*;

import javax.swing.tree.TreeNode;
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
    // diameter

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class info{
    int height;
    int diameter;
    public info(int height, int diameter){
        this.height = height;
        this.diameter = diameter;
    }
}



class Solution {
    public  info helperfunction(Node root){
    if(root == null) return new info(0,0);
    info left_info = helperfunction(root.left);
    info right_info = helperfunction(root.right);
    int self_diameter = Math.max(Math.max(left_info.diameter, right_info.diameter),( left_info.height+right_info.height));
    int self_height = Math.max(left_info.height,right_info.height)+1;
    return new info(self_height, self_diameter);
}
    int diameter(Node root) {
        // Your code here
       info information = helperfunction(root);
       return information.diameter;
    }
}
// subtree
    public boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null) return true;
        if(node == null || subRoot == null || node.data != subRoot.data) return false;
        if(!isIdentical(node.left,subRoot.left)) return false;
        if(!isIdentical(node.right,subRoot.right)) return false;
        return true;
    }
    public boolean isSubtree(Node root, Node subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;
        if(root.data == subRoot.data){
           if( isIdentical(root,subRoot)){
            return true;
           }
        } 
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    // Top view of Binary Tree
    class info2{
        Node node;
        int hd;
        public info2(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    // top-view of binary tree
    public void topView(Node root){
        // Level Order
        Queue<info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;
        q.add(new info2(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            info2 curr = q.remove();
            if(curr == null){
                if(q.isEmpty()) break;
                else q.add(null);
            }else{
            if(!map.containsKey(curr.hd)){ // first occurance of hd
                map.put(curr.hd, curr.node);
            }
            if(curr.node.left != null){
                q.add(new info2(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }
            if(curr.node.right != null){
                q.add(new info2(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
        }

        }
        for(int i = min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }
    // left-view of binary tree
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        if(root==null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            int sizes=q.size();
            for(int i=0;i<sizes;i++){
                Node curr=q.poll();
                if(i==0){
                    res.add(curr.data);
                }
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
            }
        }
        return res;
    }
    // kth level of tree
    public static void KLevel(Node root, int level,  int k){
        if(root == null) return;
        if(level == k){
            System.out.print(root.data + " ");
            return;
        }
        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
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
        System.out.println();
        tree.topView(root);
        tree.KLevel(root,1,2);
    }
}
