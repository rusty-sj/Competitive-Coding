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
    public boolean isValidBST(TreeNode root) {
        return recursion(root, null, null);
    }
    
    public boolean recursion(TreeNode node, Integer low, Integer high) {
        if (node == null)
            return true;
        
        if ((low != null && node.val <= low) || (high != null && node.val >= high))
            return false;
        
        return recursion(node.left, low, node.val) && recursion(node.right, node.val, high);
    }
}