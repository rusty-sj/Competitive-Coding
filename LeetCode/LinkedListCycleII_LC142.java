/**
 * Take two pointers with speeds 1x and 2x, keep incrementing until either both of them meet or if end is reached,
 * Once their intersection point is found, start from beginning and intersection point with both 1x speed,
 * wherever they meet is the start point of cycle
 *
 * Time Complexity O(N) Asymptotically; when no cycle O(N/2)
 * Space Complexity O(1)
 */
public class LinkedListCycleII_LC142 {
    public ListNode detectCycle(ListNode head) {
        ListNode intersect = findIntersection(head);  // Get intersection point if cycle exists, else null
        if (intersect == null)                         // No cycle
            return null;

        ListNode slow = head;                       // Start from head and intersect
        while (slow != intersect) {                 // when they are same, start point is found
            slow = slow.next;
            intersect = intersect.next;
        }
        return slow;
    }

    private ListNode findIntersection(ListNode node) {
        ListNode slow = node, fast = node;      // Two pointers moving with speeds 1x and 2x

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)                   // Both meet, cycle exists, intersection found
                return slow;
        }
        return null;                            // No cycle
    }
}
