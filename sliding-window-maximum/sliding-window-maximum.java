class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int left = 0, right = 0;
        
        // Add first interval 
        while (right < k) {
            queue.add(new int[]{nums[right] , right});
            // System.out.println(nums[right] + " " + right);
            right++;
        }
        output[left++] = queue.peek()[0];
        
        while (right < nums.length) {
            queue.add(new int[]{nums[right] , right});
            while (queue.peek() != null && queue.peek()[1] < left) {
                System.out.println(queue.peek()[1]);
                System.out.println(left + " " + right);
                queue.poll();
            }
            output[left] = queue.peek()[0];
            left++;
            right++;
        }
        
        return output;
    }
}