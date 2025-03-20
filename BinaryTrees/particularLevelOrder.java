import java.util.ArrayList;

public class particularLevelOrder {
    
    class Tree
{
    ArrayList<Integer> al = new ArrayList<>();
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        int h = height(node);
        int i;
        for (i = h; i >= 1; i--)
        //THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
        {
            addGivenLevel(node, i);
        }
        return al;
    }
  
    /* Print nodes at a given level */
    void addGivenLevel(Node node, int level)
    {
        if (node == null)
            return;
        if (level == 1)
            al.add(node.data);
        else if (level > 1)
        {
            addGivenLevel(node.left, level - 1);
            addGivenLevel(node.right, level - 1);
        }
    }
  
    /* Compute the "height" of a tree -- the number of
     nodes along the longest path from the root node
     down to the farthest leaf node.*/
    int height(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);
  
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
}
// O(n^2) time
// O(h) space, h height of binary tree
}
