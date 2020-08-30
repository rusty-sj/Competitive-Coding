// Time Complexity : O(N * M) N = number of coins, M = amount to be reached
// Space Complexity : O(M) M = amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : DP is a little difficult right now


import java.util.Arrays;

// Your code here along with comments explaining your approach
public class CoinChange2_LC518 {
    public int change(int amount, int[] coins) {

        /**
         * Approach 1 2D array for storing sub-problem solutions
         */
        /*
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < coins.length + 1; i++) dp[i][0] = 1;
        for (int i = 1; i < amount + 1; i++) dp[0][i] = 0;

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
        return dp[coins.length][amount]; */

        /**
         * Approach 2 1D array for storing sub-problem solutions
         */
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;                  // 1 way to make amount 0; not choosing any coins

        for (int coin : coins) {
            for (int j = 1; j < amount + 1; j++) {
                if (coin <= j)
                    dp[j] = dp[j] + dp[j - coin];       // Chosen + not chosen
            }
        }
        return dp[amount];
    }
}
