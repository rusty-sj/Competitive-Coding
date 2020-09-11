public class ReverseLinkedList_LC206 {
    public ListNode reverseList(ListNode head) {
        // return reverseIterative(head);
        return reverseRecursive(head);
    }

    /**
     * Keep three pointers at a node, it's previous, itself and its next. Iterate until end/null is reached
     * In every iteration, save copy of next, make current's next point to previous and update previous and current
     *
     * Time Complexity: O(N) N:number of nodes
     * Space Complexity: O(1)
     *
     * @param node
     * @return
     */
    ListNode reverseIterative(ListNode node) {
        ListNode previous = null, current = node, temp = null;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    /**
     * With recursive function, reach all the way down to last node which would be head for reversedlist
     * Once end is reached, keep returning and update current node such that returned and reversed nodes point to
     * the current node. Change pointers while returning from each recursive call
     *
     * Time Complexity: O(N) N:number of nodes
     * Space Complexity: O(N) Stack space
     *
     * @param node
     * @return
     */
    ListNode reverseRecursive(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode head = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
