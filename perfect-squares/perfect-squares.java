class Solution {
    public int numSquares(int n) {
        if (n == 0)
            return 0;
        
        int[] squares = buildSquares(n);
        
        int[][] dp = new int[squares.length + 1][n + 1];
        for (int i = 0; i < n + 1; i++) 
            dp[0][i] = n + 1;
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j < squares[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - squares[i - 1]] + 1);
                }
            }
        }
        return dp[squares.length][n];
    }
    
    public int[] buildSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        int[] squares = new int[sqrt];
        int i = 0;
        while (i < sqrt) {
            squares[i] = (i + 1) * (i + 1);
            i++;
        }
        return squares;
    }
}