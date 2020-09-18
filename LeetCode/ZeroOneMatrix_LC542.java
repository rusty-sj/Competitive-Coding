import java.util.LinkedList;
import java.util.Queue;

/**
 * Start BFS in a reverse manner by exploiting 0s instead of 1s as 0 values won't change and we can start calc dist for
 * its immediate neighbors. Keep going level by level with dist 1 values calculated first, then dist 1 and ... dist n
 * <p>
 * Time complexity: O(N) where N is number of cells in matrix
 * Space complexity: O(N) for Queue space
 */
public class ZeroOneMatrix_LC542 {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<Cell> queue = new LinkedList<>();         // Keep track level by level with same dist values
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)                  // To mark unvisited
                    matrix[i][j] = -1;
                else if (matrix[i][j] == 0) {           // Exploit 0s so add them to queue
                    queue.add(new Cell(i, j));
                }
            }
        }

        int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int dist = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();        // Runs per level until all cells are done calculating dist
            dist += 1;
            for (int i = 0; i < size; i++) {
                Cell cell = queue.poll();
                for (int[] dir : directions) {
                    int r = dir[0] + cell.getX();
                    int c = dir[1] + cell.getY();
                    if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length
                            && matrix[r][c] == -1) {
                        matrix[r][c] = dist;
                        queue.add(new Cell(r, c));
                    }
                }
            }
        }
        return matrix;
    }
}
