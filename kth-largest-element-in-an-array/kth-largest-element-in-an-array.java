class Solution {
    
    // TC: O(N log K)
    // SC: O(K)
    public int findKthLargest(int[] nums, int k) {
        // Use a min heap that maintains only k elements
        // This would maintain k large elements in the heap
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int num: nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        // kth largest is the smallest of k large elements
        int kthLargest = queue.poll();
        return kthLargest;
    }
}