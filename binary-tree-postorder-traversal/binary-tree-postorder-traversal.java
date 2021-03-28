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
    List<Integer> output;
    public List<Integer> postorderTraversal(TreeNode root) {
        output = new ArrayList<>();
        dfs(root);
        return output;
    }
    
    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        dfs(node.right);
        output.add(node.val);
    }
}