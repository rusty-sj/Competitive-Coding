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
        if (root == null)
            return 0;
        int leftH = countLeftHeight(root);
        int rightH = countRightHeight(root);
        
        if (leftH == rightH) {
            return (1 << leftH) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    public int countLeftHeight(TreeNode node) {
        return node == null ? 0 : 1 + countLeftHeight(node.left);
    }
    
    public int countRightHeight(TreeNode node) {
        return node == null ? 0 : 1 + countRightHeight(node.right);
    }
}