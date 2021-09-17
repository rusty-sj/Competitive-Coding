class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums)
            sum += num;
        
        if (sum % 2 != 0)
            return false;
        
        boolean[][] dp = new boolean[nums.length + 1][(sum/2) + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j - nums[i - 1] < 0)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }   
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}