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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        int uniVal = root.val;
        return preorder(root, uniVal);
    }
    
    public boolean preorder(TreeNode node, int uniVal) {
        if (node == null)
            return true;
        if (node.val != uniVal)
            return false;
        return preorder(node.left, uniVal) && preorder(node.right, uniVal);
    }
}