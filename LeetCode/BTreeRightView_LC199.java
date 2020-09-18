import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Use simple iterative level order traversal using BFS but insert node value into answer only when it is last of that level
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class BTreeRightView_LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();       // Output array
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();     // Queue to keep track of levels
        queue.add(root);

        while (!queue.isEmpty()) {                      // Iterate per level
            int size = queue.size();
            for (int i = 0; i < size; i++) {            // Iterate for all elements inside a level
                TreeNode node = queue.poll();
                if (i == size - 1)                      // Add only last element to result
                    result.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return result;
    }
}
