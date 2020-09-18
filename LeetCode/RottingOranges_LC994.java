import java.util.LinkedList;
import java.util.Queue;

/**
 * Instead of visiting fresh oranges and checking if it has rotten oranges, we spot rotten ones and look for fresh
 * neighbors to rot them
 * Use a queue of all rotten oranges, keep rotting fresh neighbors of them per iteration
 * 
 * Time Complexity: O(N) where N is total number of oranges in grid
 * Space Complexity: O(N) Used by Queue
 */
public class RottingOranges_LC994 {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, iterations = 0;
        Queue<Cell> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                if (grid[i][j] == 2)            // Add rotten to queue
                    queue.add(new Cell(i, j));
            }
        }

        int[][] directions = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (fresh == 0)                 // All fresh oranges are done rotting
                return iterations;
            iterations += 1;
            for (int i = 0; i < size; i++) {
                Cell cell = queue.poll();
                int x = cell.getX(), y = cell.getY();
                for (int[] dir : directions) {
                    int r = x + dir[0];
                    int c = y + dir[1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        fresh--;
                        queue.add(new Cell(r, c));
                    }
                }
            }
        }
        return fresh == 0 ? 0 : -1;         // If there were no fresh oranges or if everything can't be rotten
    }
}

class Cell {
    private int x;
    private int y;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
