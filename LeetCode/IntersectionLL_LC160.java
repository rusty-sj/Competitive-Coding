/**
 * Two pointers are made to traverse whole of LL1 and LL2, when any of them hits the end, make them traverse the other
 * This way both pointers will traverse equal number of nodes to meet at the intersection
 *
 * Time Complexity: O(N + M) N: nodes in LL1, M: Nodes in LL2
 * Space Complexity: O(1)
 */
public class IntersectionLL_LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointer1 = headA, pointer2 = headB;        // Init two pointers to start of each LL head
        while (pointer1 != pointer2) {
            if (pointer1 != null)                           // Advance in A until end is reached
                pointer1 = pointer1.next;
            else                                            // Reached end of A, switch to headB
                pointer1 = headB;
            if (pointer2 != null)                           // Advance in B until end is reached
                pointer2 = pointer2.next;
            else                                            // Reached end of B, switch to headA
                pointer2 = headA;
        }
        return pointer1;                                    // Pointer1 and 2 are at same point
    }
}
