import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_LC101 {
    public boolean isSymmetric(TreeNode root) {
        return recurse(root, root);
        //return iterativeSymm(root);
    }

    /**
     * A tree is symmetric about it's root when left sbtree's left side resembles right subtree's right side and at the
     * same time, the left subtree's right side resembles right subtree's left side
     * Thus recurse until values at two nodes to be compared don't match or everything was matched and we reached leaves
     */
    // Time Complexity: O (N) N: number of nodes in tree
    // Space Complexity: O (H) Stack Space (H: logn to n)
    boolean recurse(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)         // Root itself is null or done traversing whole tree
            return true;
        else if (node1 == null || node2 == null)    // One of the two subtrees is null
            return false;

        return node1.val == node2.val && recurse(node1.left, node2.right)   // Check if value at node is same
                && recurse(node1.right, node2.left);                // left's left should be equal to right's right and right's left->left's right
    }

    /**
     * A tree is symmetric about it's root when left sbtree's left side resembles right subtree's right side and at the
     * same time, the left subtree's right side resembles right subtree's left side
     *
     * Use a queue to store 2 pairs of nodes to be compared at each point, push above mentioned nodes in queue in order
     * until queue is empty and keep comparing by polling pairs from queue
     *
     * When node values polled dont match, return false
     * If everything was parsed and queue is empty, return true as all nodes matched
     */
    // Time Complexity: O (N) N: number of nodes in tree
    // Space Complexity: O (N) all N nodes pushed onto stack in worst case
    boolean iterativeSymm(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>(); // Push nodes in a queue to compare left subtree with right
        queue.add(node);                            // Add root twice, compare to itself; done for satisfying while loop
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null)         // Root is null
                continue;
            else if (node1 == null || node2 == null)    // One of the two nodes/subtrees is null
                return false;
            else if (node1.val != node2.val)            // If not equal, return false
                return false;

            queue.add(node1.left);          // Add in sequence of compare order, node1's left
            queue.add(node2.right);         // ; node2's right
            queue.add(node1.right);         // ; node1's right
            queue.add(node2.left);          // ; and node2's left
        }
        return true;
    }
}
