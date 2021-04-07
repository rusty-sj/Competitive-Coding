class Solution {
    public int maximalSquare(char[][] matrix) {
        // Empty input
        if (matrix == null || matrix.length == 0)
            return 0;
        
        int m = matrix.length, n = matrix[0].length;
        
        // DP array
        int[][] dp = new int[m + 1][n + 1];
        
        // Maintain global max size
        int maxSide = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Check compute only if value at top left is 1
                if (matrix[i - 1][j - 1] == '1') {
                    int minFromPrev = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(minFromPrev, dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}