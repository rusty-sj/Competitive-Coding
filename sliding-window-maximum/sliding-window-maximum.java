class Solution {
    // Time Complexity: O(N log N) : worst case heap can grow to size n
    // Space Complexity: O(N)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        
        // Pair of value and index
        // PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int left = 0, right = 0;
        
        // Add first interval 
        while (right < k) {
            queue.add(new int[]{nums[right] , right});
            right++;
        }
        
        // Update first max
        output[left++] = queue.peek()[0];
        
        while (right < nums.length) {                   // O(N log N))
            // Include new element at right index
            queue.add(new int[]{nums[right] , right});  // O(log N)
            
            // If current maximum is out of the current interval, pop it
            while (queue.peek() != null && queue.peek()[1] < left) {
                queue.poll();                           // O(log N)
            }
            
            // Update max for interval
            output[left] = queue.peek()[0];
            left++;
            right++;
        }
        
        return output;
    }
}