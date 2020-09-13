/**
 * Due to not having head pointer, there is no way of going a node previous to the node to be deleted
 * Thus, we copy the value of node next to the node to be deleted and then delete the next node
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class DeleteWithoutHeadLL {
    void deleteNode(Node node) {
        // Your code here
        if (node.next == null) {  // If node to be deleted is the last node
            node = null;
            return;
        }
        node.data = node.next.data;     // Copy next element's value
        node.next = node.next.next;     // Delete next element
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
