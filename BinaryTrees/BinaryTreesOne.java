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
        // Pre Order Transversal
        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
            }
    }
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root= tree.buildPreorderTree(nodes);
        System.out.println(root.data);
        tree.preOrder(root);
    }
}
