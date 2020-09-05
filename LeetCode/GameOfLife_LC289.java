/**
 * The dead to alive and alive to dead changes shouldn't affect neighor as all of them change their states at once
 * Thus encode changes with temporary values to preserve old as well as new information
 * visit each cell, compute its next state and change it as per neighbor conditions
 * once all values are computed as per encodings, decode them
 **/

// Time Complexity: O (nRow * nColumn)
// Space Complexity: O (1) constant space for 8 directions calculations
// Did this code successfully run on Leetcode : Yes
public class GameOfLife_LC289 {
    static int rowDir[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int colDir[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public void gameOfLife(int[][] board) {
        // Handle empty input
        if (board == null || board.length == 0)
            return;

        // Loop through each value in board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int neighbors = getNeighborCount(board, i, j);      // Get Alive neighbors count

                // Encode values for neglecting intermediate state changes
                if (board[i][j] == 1 && (neighbors < 2 || neighbors > 3))   // Encode alive to dead as 2
                    board[i][j] = 2;
                else if (board[i][j] == 0 && neighbors == 3)                // Encode dead to alive as 4
                    board[i][j] = 4;
            }
        }

        for (int i = 0; i < board.length; i++) {                            // Decode computed values
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 0;
                else if (board[i][j] == 4)
                    board[i][j] = 1;
            }
        }
    }

    int getNeighborCount(int[][] board, int i, int j) {         // Get count of alive neighbors (8 directions)
        int count = 0;
        for (int x = 0; x < rowDir.length; x++) {
            int row = i + rowDir[x];
            int column = j + colDir[x];
            if (row >= 0 && column >= 0 && row < board.length && column < board[0].length
                    && (board[row][column] == 2 || board[row][column] == 1))
                count++;
        }
        return count;
    }
}
