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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        
        while (!queue.isEmpty()) {
            level += 1;
            int qSize = queue.size();
            TreeNode node;
            for (int i = 0; i < qSize; i++) {
                node = queue.poll();
                if (node.left == null && node.right == null)
                    return level;
                
                if (node.left != null)
                    queue.offer(node.left);
                
                if (node.right != null)
                    queue.offer(node.right);
                
            }
        }
        return level;
    }
}