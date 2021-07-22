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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        recurse(root);
        return max;
    }
    
    public int recurse(TreeNode node) {
        if (node == null) 
            return 0;
        
        int left = recurse(node.left);
        int right = recurse(node.right);
        
        int leftPath = 0, rightPath = 0;
        
        if (node.left != null && node.val == node.left.val) 
            leftPath += 1 + left;
        
        
        if (node.right != null && node.val == node.right.val) 
            rightPath += 1 + right;

        
        max = Math.max(max, leftPath + rightPath);
        
        return Math.max(leftPath, rightPath);
    }
}