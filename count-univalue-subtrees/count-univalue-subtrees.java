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
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        recursion(root);
        return count;
    }
    
    boolean recursion(TreeNode node) {
        if (node == null)
            return true;
        
        boolean left = recursion(node.left);
        boolean right = recursion(node.right);
        
        if (left == false || right == false)
            return false;
        
        if (node.left != null && node.val != node.left.val)
            return false;
        
        if (node.right != null && node.val != node.right.val)
            return false;
        
        count++;
        return true;
    }
    
}