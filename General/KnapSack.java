public class KnapSack {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int capacity = 6;
        System.out.println(maximizeValue(weights, values, capacity));
    }

    private static int maximizeValue(int[] weights, int[] values, int capacity) {
        // Handle empty input
        if (weights == null || weights.length == 0 || values == null || values.length == 0)
            return 0;

        // DP array
        int[][] dp = new int[values.length + 1][capacity + 1];

        for (int i = 1; i < values.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (weights[i - 1] > j)                 // current weight more than coln for capacity
                    dp[i][j] = dp[i - 1][j];
                else                                    // Choose current or don't, take max
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);

            }
        }
        return dp[values.length][capacity];
    }
}
