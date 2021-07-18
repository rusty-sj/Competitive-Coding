/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val).append("#");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    sb.append("X").append("#");
                }
            }
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splits = data.split("#");
        if (splits[0].equals("X"))
            return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            i++;
            if (!splits[i].equals("X")) {
                node.left = new TreeNode(Integer.parseInt(splits[i]));
                queue.add(node.left);
            }
            
            i++;
            if (!splits[i].equals("X")) {
                node.right = new TreeNode(Integer.parseInt(splits[i]));
                queue.add(node.right);
            }
        }
    
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));