/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    // TC: O(N + M)
    // SC: O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Maintain head pointer with temp
        ListNode temp = new ListNode(-1);
        
        // Iterator pointer
        ListNode current = temp;
        
        while (l1 != null && l2 != null) {
            // l1 value is less, use it for sorted link
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // If one of the two pointers are not null, copy that list
        if (l1 != null) current.next = l1;
        else if (l2 != null) current.next = l2;
        
        return temp.next;
    }
}