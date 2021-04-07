class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        
        int maxRobInclStart = houseRob(nums, 0, nums.length - 2);
        int maxRobInclEnd = houseRob(nums, 1, nums.length - 1);
        return Math.max(maxRobInclStart, maxRobInclEnd);
    }
    
    public int houseRob(int[] nums, int start, int end) {
        if (start > end)
            return 0;
        if (start == end)
            return nums[start];
        
        int n = end - start + 1;
        int[] dp = new int[n + 2];
        
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2 + start], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}