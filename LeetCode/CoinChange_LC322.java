/**
 * Dynamic programming top down approach
 */

// Time Complexity: O (N*K)  N=coins, K=amount
// Space Complexity: O (K) due to memoization
// Did this code successfully run on Leetcode : Yes

public class CoinChange_LC322 {
    public int coinChange(int[] coins, int amount) {
        //Handle empty input
        if (coins == null || coins.length == 0 || amount == 0)
            return 0;

        /**
         * Approach 1 with 2D memoization
         * Keep a 2D array that keeps track of min coins needed for each denomination to reach amount
         * The answer will be located at last row and column of dp array
         */
        /*int[][] dp = new int[coins.length + 1][amount + 1];     // DP array

        for (int i = 0; i < coins.length + 1; i++) dp[i][0] = 0;        // 0 coins used to reach 0 amount
        for (int i = 0; i < amount + 1; i++) dp[0][i] = amount + 1;     // infinite coins of 0 needed to reach amount

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1])                                   // Denomination more than amount to be reached
                    dp[i][j] = dp[i - 1][j];                            // Use previous subproblem's solution
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);     // take min of new soln vs prev subproblem soln
            }
        }
        return dp[coins.length][amount] < amount + 1 ? dp[coins.length][amount] : -1;   // value is inf, there's no soln*/

        /**
         * Approach 2 with 1D memoization; avoid 2D array since we need only one previous row for calculating subproblem's soln
         * Keep a 1D array that keeps track of min coins needed to reach intermediate amountsØ
         * The answer will be located at last index of dp array
         */
        int[] dp = new int[amount + 1];         // DP array

        for (int i = 0; i < amount + 1; i++)    // Initialize array to infinity: amount + 1
            dp[i] = amount + 1;

        dp[0] = 0;                              // 0 coins used to reach 0 amount

        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (coin <= i)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
