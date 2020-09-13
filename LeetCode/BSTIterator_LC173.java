import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * In the constructor, do an inorder scan and store values in a queue so that next and hasNext become O(1)
 *
 * Time Complexity for constructor: O(N) to do a full inorder scan
 * Space Complexity: O(N) for storing inorder traversal and O(H) for recursion stack
 *
 * Time Complexity for next() and hasNext(): O(1)
 * Space Complexity for next() and hasNext(): O(1) although they are using stored Queue of size N
 */
class BSTIterator_LC173 {
    private Queue<Integer> minQ = new LinkedList<>();

    public BSTIterator_LC173(TreeNode root) {
        inorder(root);
    }

    public void inorder(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;

        while (node != null || s.size() > 0) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            this.minQ.add(node.val);
            node = node.right;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!this.minQ.isEmpty())
            return this.minQ.poll();
        else
            return -1;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !this.minQ.isEmpty();
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 *
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */