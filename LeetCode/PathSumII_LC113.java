import java.util.ArrayList;
import java.util.List;

/**
 * Traverse all possible root to leaf paths, check the sum in the path
 * If the path's sum equals desired sum, add the path to output array
 * This path is maintained at each level by adding or removing node values
 */
// Time Complexity: O (N) N: number of nodes in tree
// Space Complexity: O (c*H) c=constant, number of lists found with sum, H: height ranging from logn to n
public class PathSumII_LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> output = new ArrayList<>();
        recurse(root, sum, 0, new ArrayList<>(), output);
        return output;
    }

    void recurse(TreeNode node, int target, int curSum, List<Integer> path, List<List<Integer>> output) {
        if (node == null)
            return;
        if (node.left == null && node.right == null && curSum + node.val == target) {   // Sum matches target
            List<Integer> tempPath = new ArrayList<>(path);         // Create copy of path to avoid changes in the same
            tempPath.add(node.val);
            output.add(tempPath);                                   // add to output list
        }

        path.add(node.val);                                         // Update path at node

        recurse(node.left, target, curSum + node.val, path, output);      // Explore left subtree
        recurse(node.right, target, curSum + node.val, path, output);     // Explore right subtree

        path.remove(path.size() - 1);                         // When right is done, we go level up, update path
    }
}
