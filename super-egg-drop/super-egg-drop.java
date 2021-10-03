class Solution {
    public int superEggDrop(int eggs, int floors) {
        int[][] dp = new int[floors + 1][eggs + 1];
        int moves = 0;
        while (dp[moves][eggs] < floors) {
            moves++;
            for (int i = 1; i < dp[0].length; i++) {
                dp[moves][i] = 1 + dp[moves - 1][i - 1] + dp[moves - 1][i];
                if (dp[moves][i] >= floors)
                    return moves;
            }
        }
        return moves;
    }
}