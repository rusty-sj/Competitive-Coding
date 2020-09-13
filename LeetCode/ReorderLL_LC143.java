/**
 * To get the desired order, split the linkedlist into two half linked lists, reverse the second half
 * Make sure to have nulls at the end of both so that cycles aren't formed
 * Once we have two lists, take two pointers and alternatingly point to one another
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class ReorderLL_LC143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)      // null input
            return;

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {    // Divide the linkedlist into halves O(N/2)
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;                               // Point first half ll's end to null to avoid cycles

        ListNode tail = reverse(slow);                  // Reverse the other half

        merge(head, tail);                              // Merge in required order
    }

    private void merge(ListNode head, ListNode tail) {      // O (N)
        ListNode headNext = null, tailNext = null;
        while (head != null) {
            headNext = head.next;       // Save next from head
            tailNext = tail.next;       // Save next from tail

            head.next = tail;           // Assign head's next to tail
            if (headNext != null)
                tail.next = headNext;   // headNext can be null when n is odd, assign tail's next to headNext

            head = headNext;            // Update current head
            tail = tailNext;            // Update current tail
        }

    }

    private ListNode reverse(ListNode node) {           // O(N/2)
        ListNode prev = null, curr = node, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
