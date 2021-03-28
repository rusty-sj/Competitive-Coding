/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> oldToNewMap = new HashMap<>();
        Node current = head, dummy = new Node(-1), ptr = dummy;
        
        // Create copies of each node in one pass
        while (current != null) {
            Node newNode = new Node(current.val);
            oldToNewMap.put(current, newNode);
            ptr.next = newNode;
            current = current.next;
            ptr = ptr.next;
        }
        
        current = head;
        ptr = dummy.next;
        while (current != null) {
            ptr.random = oldToNewMap.get(current.random);
            current = current.next;
            ptr = ptr.next;
        }
        return dummy.next;
    }
}