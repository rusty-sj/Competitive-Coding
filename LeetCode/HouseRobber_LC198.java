/**
 * Use Dynamic Programming memoization and initialize a dp array with size n+1
 * such that ith index will correspond to stealing ith house
 * 0th index: no house, 1st index: 1st house, ..., nth index: nth house
 * <p>
 * For maximizing dollars, go bottom up filling max stolen value at ith index of dp array
 * At any point use previously calculated max robbed value and find maximum of including current house or including previous
 */

// Time Complexity: O (N)
// Space Complexity: O (1) due to memoization
// Did this code successfully run on Leetcode : Yes
public class HouseRobber_LC198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        /** Approach 1 Using 1D DP array
         * Keep filling DP array by taking current house and solution till that point into consideration
         * Answer lies at last index of DP array
         */
        /*int[] dp = new int[nums.length + 1];        // DP array
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);   // Choose max between prev solution and previous to previous solution plus current house
        }
        return dp[nums.length];*/

        /** Approach 2 without DP array
         * At each house, you either choose it or don't
         * Keep 2 varibles to keep track of maximum house amount robbed when house was chosen or when it wasn't
         */
        int choose = 0, noChoose = 0;
        for (int num : nums) {
            int temp = noChoose;
            noChoose = Math.max(choose, noChoose);
            choose = temp + num;
        }
        return Math.max(choose, noChoose);
    }
}
