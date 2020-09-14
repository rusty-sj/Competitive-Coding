/**
 * Step 1: Find midpoint of linkedlist using slow and fast pointers, mark first half's end point to null
 * Step 2: Reverse second half linkedlist
 * Step 3: Compare value at each node of both linkedlist for checking palindrome condition
 *
 * PS. Input linkedlist gets modified
 *
 * Time Complexity: O(N), N: Number of nodes in LL
 * Space Complexity: O(1)
 */
public class PalindromeLL_LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null)                       // null input is a valid palindrome
            return true;

        ListNode middle = findMiddle(head);     // Find end point of first half of divided linkedlist

        ListNode ptr1 = head;
        ListNode ptr2 = reverse(middle.next);   // Reverse second half of linkedlist
        middle.next = null;                     // Point first half's end to null to avoid loops

        while (ptr2 != null) {                  // Check for palindrome
            if (ptr1.val != ptr2.val)
                return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode node) {        // Slow(1x) and fast(2x) pointers to get mid point
        ListNode slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode current = node, previous = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
