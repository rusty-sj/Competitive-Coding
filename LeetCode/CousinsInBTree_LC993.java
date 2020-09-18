/**
 * We need to check for two conditions: depth and parent of two nodes to identify siblings
 * Keep global vars that keep track of depths of x and y and their parents
 * Whenever x/y is found at a node update its depth and parent
 * Recurse for left and right
 * Once recursion is over, check for siblings condition from global vars which we updated
 *
 * Time Complexity: O(N), N: Number of nodes
 * Space Complexity: O(N), N: number of nodes
 */
public class CousinsInBTree_LC993 {
    private int xDepth = -1, yDepth = -1;                   // Depths of found x and y in Tree
    private TreeNode xParent = null, yParent = null;        // Parents of x and y when they are found

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return xDepth == yDepth && xParent != yParent;        // Same levels but different parents
    }

    private void dfs(TreeNode node, TreeNode parent, int x, int y, int depth) {
        if (node == null)
            return;
        if (node.val == x) {            // x is found, update its depth and parent
            xDepth = depth + 1;
            xParent = parent;
        } else if (node.val == y) {     // y is found, update its depth and parent
            yDepth = depth + 1;
            yParent = parent;
        }
        if (xDepth != -1 && yDepth != -1)                 // If both depths aren't -1, x and y were found already, return
            return;
        dfs(node.left, node, x, y, depth + 1);     // Recurse left
        dfs(node.right, node, x, y, depth + 1);    // Recurse right
    }
}
