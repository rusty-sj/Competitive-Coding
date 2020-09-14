import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Use a queue to keep track of nodes in level. Iterate until queue is not empty
 *
 * Time Complexity: O(N), N: Number of nodes
 * Space Complexity: O(N), N: number of nodes
 */
public class BTLevelOrderTraversal_LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();         // Output List
        if (root == null)                                       // Null root
            return output;
        Queue<TreeNode> queue = new LinkedList<>();             // Maintain a queue to keep track of per level nodes
        queue.add(root);                                        // Add root to queue
        TreeNode node;
        List<Integer> level;
        while (!queue.isEmpty()) {                              // Iterate until queue is empty
            level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {                    // Each level will have size number of nodes in queue
                node = queue.poll();
                level.add(node.val);                            // Add node to level array
                if (node.left != null)                          // Add node's left child to queue
                    queue.add(node.left);
                if (node.right != null)                         // Add node's right child to queue
                    queue.add(node.right);
            }
            output.add(level);                                  // Level parsed, add to output
        }
        return output;
    }
}
