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
    
    int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return count;
        
        if (dfs(root, root.val))
            count++;
        
        countUnivalSubtrees(root.left);
        countUnivalSubtrees(root.right);
        
        return count;
    }
    
    public boolean dfs(TreeNode node, int val) {
        if (node == null)
            return true;
        if (node.val != val)
            return false;
        return dfs(node.left, val) && dfs(node.right, val);
    }
}