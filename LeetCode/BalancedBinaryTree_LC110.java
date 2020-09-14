/**
 * Recursively find left subtree and right subtree's height at any node
 * If absolute difference between left and right height is greater than 1, return -1
 * Also, if any of the two heights was already -1, it means that subtree was unbalanced, hence return -1
 * If not unbalanced, calculate actual height and return it
 * If the final height isn't -1, tree was balanced
 * <p>
 * Time Complexity: O(N) where N is number of nodes in BST
 * Space Complexity: O(H) where H is height ranging from log N to N
 */
public class BalancedBinaryTree_LC110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)       // Null input handling
            return true;

        int height = recurse(root);

        if (height == -1)       // height -1 signifies tree is unbalanced
            return false;
        return true;
    }

    private int recurse(TreeNode node) {
        if (node == null)       // null means leaf node; height 0
            return 0;

        int leftHeight = recurse(node.left);       // get height of left subtree
        int rightHeight = recurse(node.right);      // get height of right subtree

        int heightDiff = Math.abs(leftHeight - rightHeight);
        // If height difference is more than 1, return -1
        // if any of left or right heights are -1, it is unbalanced, so return -1
        if (leftHeight == -1 || rightHeight == -1 || heightDiff > 1)
            return -1;

        // not unbalanced, return actual height at node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
