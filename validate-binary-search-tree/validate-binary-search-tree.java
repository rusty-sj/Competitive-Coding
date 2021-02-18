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
        return helper(root, -1, -1);
    }
    
    public boolean helper(TreeNode node, int low, int high) {
        if (node == null)
            return true;
        if ((low != -1 && node.val <= low) || (high != -1 && node.val >= high))
            return false;
        return helper(node.left, low, node.val) && helper (node.right, node.val, high);
    }
}