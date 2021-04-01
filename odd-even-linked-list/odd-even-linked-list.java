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
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        
        ListNode dummy1 = head, dummy2 = head.next, evenHead = dummy2;
        
        while (dummy2 != null && dummy2.next != null) {
            dummy1.next = dummy2.next;
            dummy1 = dummy1.next;
            dummy2.next = dummy1.next;
            dummy2 = dummy2.next;
        }  
        dummy1.next = evenHead;
        return head;
    }
}