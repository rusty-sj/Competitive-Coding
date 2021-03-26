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

// Node for Min-Heap that stores ListNode's value with index of the list and the reference to next ListNode
class PQNode implements Comparable<PQNode> {
    int value;      
    int index;      // Which list does this element belong to
    ListNode list;  // Remaining list pointer
    
    public PQNode(int value, int index, ListNode list) {
        this.value = value;
        this.index = index;
        this.list = list;
    }
    
    @Override
    public int compareTo(PQNode node) {
        // Sort on value; if there's a tie of values, sort on indexes
        if (node.value == this.value)
            return this.index - node.index;
        return this.value - node.value;
    }
    
} 

class Solution {
    
    // TC: O(N log k)
    // SC: O(K) for minheap
    public ListNode mergeKLists(ListNode[] lists) {
        // Build a min-heap that is sorted on values and then index
        PriorityQueue<PQNode> queue = new PriorityQueue();
        
        // Insert first element of each ListNode into MinHeap
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                queue.add(new PQNode(lists[i].val, i, lists[i].next));
        }
        
        ListNode preHead = new ListNode(-1);
        ListNode current = preHead;  // Output iterator pointer
        
        while (!queue.isEmpty()) {
            // Get min element out of all the nodes stored in minheap
            PQNode pqNode = queue.poll();
            
            // Add the popped node into output linkedlist
            current.next = new ListNode(pqNode.value);
            current = current.next;
            
            // Take the next element from the used list and add to min heap
            if (pqNode.list != null)
                queue.add(new PQNode(pqNode.list.val, pqNode.index, pqNode.list.next));
        }
        
        return preHead.next;
    }
}