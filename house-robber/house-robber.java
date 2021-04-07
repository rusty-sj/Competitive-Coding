class Solution {
    // TC: O(N)
    // SC: O(N)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length + 2];
        
        for (int i = 2; i < dp.length; i++) {
            // Maximum of choose current house or take prev max robbery
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
        }
        return dp[dp.length - 1];
    }
}