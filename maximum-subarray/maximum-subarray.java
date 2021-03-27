class Solution {
    public int maxSubArray(int[] nums) {
        
        // Empty input
        if (nums == null || nums.length == 0)
            return 0;
        
        // Initialize maxSum and running sum to first element
        int maxSum = nums[0], currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Include current element or discard all prev and take just current
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update maxSum
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}