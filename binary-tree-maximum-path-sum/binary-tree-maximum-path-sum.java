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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int max = dfs(root);
        return Math.max(result, max);
    }
    
    public int dfs(TreeNode node) {
        
        if (node == null)
            return 0;
        
        int curr = node.val;
        int left = dfs(node.left);
        left = Math.max(left, 0);
        int right = dfs(node.right);
        right = Math.max(right, 0);
        
        int path = curr + left + right;
        result = Math.max(path, result);
        
        System.out.println("left: " + left + " right: " + right + " node: " + curr + " path: "+ path);
        return curr + Math.max(left, right);
    }
}