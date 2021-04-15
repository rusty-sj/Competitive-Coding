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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        // Base case, never found a start point for t in s
        if (s == null) 
            return false;
        
        // Done finding entire t
        if (t == null)
            return true;
        
        // check if node values and entire subtrees from them are equal
        if (areIdentical(s, t))
            return true;
        
        // try to find start point for t in s
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean areIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        
        return s.val == t.val 
            && areIdentical(s.left, t.left) 
            && areIdentical(s.right, t.right);
    }
    
    
}