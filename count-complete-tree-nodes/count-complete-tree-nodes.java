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
    public int countNodes(TreeNode root) {
        return preorder(root, 0);
    }
    
    public int preorder(TreeNode node, int count) {
        if (node == null) 
            return 0;
        return 1 + preorder(node.left, count) + preorder(node.right, count);
    }
}