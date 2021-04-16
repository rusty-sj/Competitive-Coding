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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        recursion(root, 0, output);
        return output;
    }
    
    public void recursion(TreeNode node, int level, List<List<Integer>> outList) {
        if (node == null)
            return;
        if (outList.size() == level)
            outList.add(new ArrayList<>());
        outList.get(level).add(node.val);
        
        recursion(node.left, level + 1, outList);
        recursion(node.right, level + 1, outList);
    }
}