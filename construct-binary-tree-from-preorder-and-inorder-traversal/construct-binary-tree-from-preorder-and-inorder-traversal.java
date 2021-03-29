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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        int splitpoint = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0])
                splitpoint = i;
        }
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, splitpoint + 1), Arrays.copyOfRange(inorder, 0, splitpoint));
        root.right = buildTree(Arrays.copyOfRange(preorder, splitpoint + 1, preorder.length), Arrays.copyOfRange(inorder, splitpoint + 1, preorder.length));
        return root;
    }
}