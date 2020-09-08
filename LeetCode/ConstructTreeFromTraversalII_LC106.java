/**
 * We know for sure that last element from postorder traversal is the root node and thus use that to identify left
 * and right part of tree from inorder array. Once we know the separation point, same length separation is followed by
 * preorder traversal
 * Form left and right inorder and preorder sub trees and iterate recursively util arrays are exhausted
 */
// Time Complexity: O (N) N: number of nodes in tree; Asymptotically
// Space Complexity: O (N) Space asymptotically and O(H) stack space for recursion where H is tree height
// Did this code successfully run on Leetcode : Yes
import java.util.Arrays;

public class ConstructTreeFromTraversalII_LC106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0)
            return null;

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int partitionIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                partitionIndex = i;
                break;
            }
        }

        int[] inleft = Arrays.copyOfRange(inorder, 0, partitionIndex);
        int[] inRight = Arrays.copyOfRange(inorder, partitionIndex + 1, inorder.length);

        int[] postleft = Arrays.copyOfRange(postorder, 0, partitionIndex);
        int[] postRight = Arrays.copyOfRange(postorder, partitionIndex, postorder.length - 1);

        root.left = buildTree(inleft, postleft);
        root.right = buildTree(inRight, postRight);

        return root;
    }
}
