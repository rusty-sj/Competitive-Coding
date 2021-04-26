class Solution {
    
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    boolean[][] visited;
    int n, m;
    
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Call backtrack if start of word is found
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, i, j, word, 1))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean backtrack(char[][] board, int i, int j, String word, int indexWord) {
        if (indexWord == word.length())
            return true;
        
        for (int[] direction: directions) {
            visited[i][j] = true;
            int row = i + direction[0];
            int column = j + direction[1];
            if (row >= 0 && row < board.length
               && column >= 0 && column < board[i].length
               && visited[row][column] == false
               && word.charAt(indexWord) == board[row][column])
                if(backtrack(board, row, column, word, indexWord + 1))
                    return true;
            visited[i][j] = false;
        }
        return false;
    }
    
}