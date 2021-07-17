class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            // i -> current index
            for (int step = 1; step <= nums[i]; step++) {
                // take j steps from i
                if (dp[i + step] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
    
    
    /* 3 2 1 0 4
       0 1 2 3 4
       
          0
       /  |   \
     1    2    3 
    /\    |    
   2  3   3
   |
   3
   
  index  0 1 2 3 4 
  array  2 3 1 1 4
  
         T T T T T   
            
  
    
    */
}