/**
 * To exploit the fact that rows and columns are sorted in ascending order, we can start search from top right or bottom left
 * and then maneuver through to spot the target
 * we know that top right element has smaller elements to left and bigger under it
 * Thus compare target with current element, if target is more than current element, go down the row
 * else go left the column
 **/

// Time Complexity: O (N + M) : N:rows, M:columns, to reach corner element, we will need to loop N+M times at most
// Space Complexity: O (1) constant space
// Did this code successfully run on Leetcode : Yes

public class Search2DMatrixII_LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)       // Empty input
            return false;

        int i = 0, j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j])
                return true;
            else if (target > matrix[i][j]) {
                i++;
            } else
                j--;
        }
        return false;
    }
}
