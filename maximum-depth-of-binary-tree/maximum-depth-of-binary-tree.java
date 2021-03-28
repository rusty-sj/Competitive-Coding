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
    int maxDep = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return maxDep;
        }
        dfs(root, 1);
        return maxDep;
    }
    
    void dfs(TreeNode node, int depth) {
        if (node == null)
            return;
        maxDep = Math.max(depth, maxDep);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}