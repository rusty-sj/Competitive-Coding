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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> output = new ArrayList<>();
        dfs(root, new StringBuilder(), output);
        return output;
    }
    
    public void dfs(TreeNode node, StringBuilder currPath, List<String> output) {
        if (node == null)
            return;
        
        if (node.left == null && node.right == null) {
            output.add(currPath.append(node.val).toString());
            return;
        }
        
        
        dfs(node.left, (new StringBuilder(currPath)).append(node.val).append("->"), output);
       
        dfs(node.right, (new StringBuilder(currPath)).append(node.val).append("->"), output);
        
        
    }
}