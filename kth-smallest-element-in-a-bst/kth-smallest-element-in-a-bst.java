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
    int kthSmallest = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        recursion(root, k);
        return kthSmallest;
    }
    
    public void recursion(TreeNode node, int k) {
        if (node == null)
            return;
        
        recursion(node.left, k);
        count += 1;
        if (count == k) {
            kthSmallest = node.val;
            return;
        }
        recursion(node.right, k);
    }
}