class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() > word2.length())
            return minDistance(word2, word1);
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) 
            dp[i][0] = i;
        
        for (int j = 0; j <= n; j++) 
            dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }
        return dp[m][n];
    }
}