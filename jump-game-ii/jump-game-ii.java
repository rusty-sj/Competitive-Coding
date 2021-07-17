class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        
        for (int index = nums.length - 2; index >= 0; index--) {
            int min = Integer.MAX_VALUE - 1;
            for (int jump = 1; jump <= nums[index]; jump++) {
                if ((index + jump) < nums.length)
                    min = Math.min(min, dp[index + jump]);
            }
            dp[index] = 1 + min;
        }
        return dp[0];
    }
    /*
    [2,3,1,1,4]
           1 0
    
    */
}