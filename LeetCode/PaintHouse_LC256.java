// Time Complexity : O(N) N= Number of houses
// Space Complexity : O(M) = O(3) = O(1) M= number of colors
// Did this code successfully run on Leetcode : No Premium :/
// Any problem you faced while coding this : DP is a little difficult right now
public class PaintHouse_LC256 {
    public static int paintHouses(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;

        int[] dp = costs[0];            // Store intermediate subproblem solution in DP array

        for (int i = 1; i < costs.length; i++) {
            // Take care of alternate colors and calculate minimum cost
            int val1 = costs[i][0] + Math.min(dp[1], dp[2]);
            int val2 = costs[i][1] + Math.min(dp[0], dp[2]);
            int val3 = costs[i][2] + Math.min(dp[0], dp[1]);
            dp[0] = val1;
            dp[1] = val2;
            dp[2] = val3;
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2])); // Minimum cost
    }

    public static void main(String[] args) {
        int[][] costs = new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(paintHouses(costs));
    }
}
