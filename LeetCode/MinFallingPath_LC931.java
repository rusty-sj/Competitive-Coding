/**
 * For a minimum path, choose the minimum value out to 3 options(edges 2 options) at
 * each row, keep calculating and storing in A.
 * We assume that it's okay to modify A, otherwise copy array will be made
 * The minimum value from last row would be the answer
 **/

// Time Complexity: O (N*N) : N: number of rows in square matrix
// Space Complexity: O (1)
// Did this code successfully run on Leetcode : Yes
public class MinFallingPath_LC931 {
    public int minFallingPathSum(int[][] A) {
        // Handle empty input
        if (A == null || A.length == 0 || A[0].length == 0)
            return -1;

        // Iterate and calculate min at each row and column
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j == 0)                         // Corner case 1
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
                else if (j == A[0].length - 1)      // Corner case 2
                    A[i][j] += Math.min(A[i - 1][j - 1], A[i - 1][j]);
                else                                // Can acess all 3 choices
                    A[i][j] += Math.min(A[i - 1][j + 1], Math.min(A[i - 1][j - 1], A[i - 1][j]));
            }
        }
        return getMin(A[A.length - 1]);
    }

    public int getMin(int[] lastA) {
        int min = Integer.MAX_VALUE;
        for (int num : lastA)
            if (num < min)
                min = num;
        return min;
    }
}
