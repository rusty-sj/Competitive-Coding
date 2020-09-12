public class RemoveNthFromEnd_LC19 {

    /**
     * To delete nth from end, we need to spot (n + 1)th from end to change pointers
     * Use two pointers and create a distance of n between them so that when fast pointer reaches end, slow will be at
     * n distance from the end
     * In case where we have to delete head itself, we need to have a dummy node to be able to preserve head
     *
     * Time Complexity O(N)
     * Space Complexity O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headTracker = new ListNode(-1);    // Dummy for not loosing head (when is to be deleted)
        headTracker.next = head;
        ListNode slow = headTracker, fast = headTracker;
        for (int i = 0; i <= n; i++)    // Place slow and fast n spaces apart
            fast = fast.next;
        while (fast != null) {          // when fast reaches the end, slow will be at n from end
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;     // Deletion
        return headTracker.next;
    }
}
