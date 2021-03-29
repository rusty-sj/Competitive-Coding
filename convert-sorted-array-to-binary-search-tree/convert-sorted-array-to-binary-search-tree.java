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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) 
            return null;
        return recursion(nums, 0, nums.length - 1);
    }
    public TreeNode recursion(int[] nums, int left, int right) {
        if (left > right)
            return null;

        // Ensures height-balanced BST
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        // Divide and Conquerrrrr!!! Thank you Prof. Tadepalli
        node.left = recursion(nums, left, mid - 1);
        node.right = recursion(nums, mid + 1, right);
        
        return node;
    }
}