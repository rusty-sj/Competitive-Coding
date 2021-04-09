class TicTacToe {

    int[] row, col;
    int diag1, diag2, n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.row = new int[n];
        this.col = new int[n];
        this.n = n;
        this.diag1 = 0;
        this.diag2 = 0;
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
        // Place 1 for player 1, -1 for player 2
        int value = player == 1 ? +1 : -1;
        
        // row col placement
        this.row[row] += value;
        this.col[col] += value;
        
        // diag and reverse diag placement
        if (row == col) 
            this.diag1 += value;
        if (row == (n - col - 1))
            this.diag2 += value;
        
        // check if any diag was formed
        if (Math.abs(diag1) == this.n || Math.abs(diag2) == this.n)
            return player;
        
        // check if vert or horiz line was formed
        if (Math.abs(this.row[row]) == this.n || Math.abs(this.col[col]) == this.n)
            return player;
    
        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */