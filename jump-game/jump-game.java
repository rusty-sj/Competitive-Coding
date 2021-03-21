class Solution {
    
    public boolean[] dp;  // Store explored answers
    public boolean[] visited;  // Mark visited if explored
    
    public boolean canJump(int[] nums) {
        dp = new boolean[nums.length];
        visited = new boolean[nums.length];
        return recursion(nums, 0);
    }
    
    public boolean recursion(int[] nums, int index) {
        if (visited[index] == true)
            return dp[index];
        if (index >= nums.length - 1)
            return true;
        for (int i = 1; i <= nums[index]; i++)
            if (recursion(nums, index + i)) {
                dp[index] = true;
                return true;
            }
        visited[index] = true;
        
        return false;
    }
}