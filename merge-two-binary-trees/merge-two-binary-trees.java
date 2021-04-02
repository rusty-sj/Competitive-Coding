/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return recursion(root1, root2);
    }
    
    public TreeNode recursion(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return null;
        
        TreeNode a = null, b = null, c = null, d = null;
        TreeNode root = new TreeNode(0);
        
        if (node1 != null) 
            root.val += node1.val;
        
        if (node2 != null) 
            root.val += node2.val;
        
        if (node1 != null && node1.left != null) 
            a = node1.left;
        
        if (node2 != null && node2.left != null) 
            b = node2.left;
        
        if (node1 != null && node1.right != null) 
            c = node1.right;
        
        if (node2 != null && node2.right != null) 
            d = node2.right;
        
        root.left = recursion(a, b);
        root.right = recursion(c, d);
        
        return root;
    }
}