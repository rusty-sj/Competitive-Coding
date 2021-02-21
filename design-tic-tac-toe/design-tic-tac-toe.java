class TicTacToe {

    int n;
    int[] rows;
    int[] cols;
    int diagonal1;
    int diagonal2;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonal1 = 0;
        this.diagonal2 = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int play = (player == 1 ? 1 : -1);
        this.rows[row] += play;
        this.cols[col] += play;
        if (row == col)
            this.diagonal1 += play;
        if (row == (this.n - col - 1))
            this.diagonal2 += play;
        
        if (Math.abs(this.rows[row]) == this.n || Math.abs(this.cols[col]) == this.n || Math.abs(this.diagonal1) == this.n || Math.abs(this.diagonal2) == this.n)
            return player;
         return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */