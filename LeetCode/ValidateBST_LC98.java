/**
 * Recursively call validate with updated low high values at each node level and wherever the binary search tree rule
 * of left less than parent and right greater than parent is violated, return false
 * when node is null, we have reached leaf level and parsed whole tree successfully, return true
 */
// Time Complexity: O (N) N: number of nodes in tree; each node is visited once
// Space Complexity: O (H) stack space H: height of tree between logn to n
// Did this code successfully run on Leetcode : Yes
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ValidateBST_LC98 {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {

        if (node == null)       // leaf reached
            return true;

        if ((low != null && node.val <= low) || (high != null && node.val >= high))     // BST violated
            return false;

        return validate(node.left, low, node.val) && validate(node.right, node.val, high);      // Recurse left and right subtree
    }
}