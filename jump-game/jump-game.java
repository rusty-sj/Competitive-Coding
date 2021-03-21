class Solution {
    
    // SC: O(2n)
    // TC: O(max_array_value^size_input)
    public boolean[] dp;       // Store explored answers dp[i] = true
    public boolean[] visited;  // Mark visited if explored
    
    
    // [2,3,1,3,4]
    // [0,1,2,3,4]
    public boolean canJump(int[] nums) {
        dp = new boolean[nums.length];
        visited = new boolean[nums.length];
        
        return recursion(nums, 0);
    }
    
    public boolean recursion(int[] nums, int index) {
        
        // If already explored, take answer from dp array
        if (visited[index] == true)  
            return dp[index];
        
        // Base case: if reached the last index, return true
        if (index == nums.length - 1)
            return true;
        
        // Explore all possible steps from index
        for (int i = 1; i <= nums[index]; i++)
            if (recursion(nums, index + i)) { 
                dp[index] = true;
                return true;
            } 
        // Done exploring steps for index, mark visited
        visited[index] = true;
        
        return false;
    }
}