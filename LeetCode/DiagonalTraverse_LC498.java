/**
 * Loop until all n*m elements are visited and use i, j as row and column access pointers
 * manipulate i and j for normal and edge cases, use a boolean to maintain direction changes
 **/

// Time Complexity: O (N*M) : rows x columns (each element visited once)
// Space Complexity: O (1) excluding output array
// Did this code successfully run on Leetcode : Yes
class DiagonalTraverse_LC498 {
    public int[] findDiagonalOrder(int[][] matrix) {

        // Handle empty input
        if (matrix == null || matrix.length == 0)
            return new int[0];

        int n = matrix.length, m = matrix[0].length;
        int[] output = new int[n * m];

        int i = 0, j = 0, pointer = 0;
        boolean isUpward = true;

        while (pointer < n * m) {
            output[pointer++] = matrix[i][j];

            if (isUpward) {
                if (j == m - 1) {           // Case when column index is at last column, change to downward and increment row
                    isUpward = false;
                    i++;
                } else if (i == 0) {        // Case when row index is at first row, change to downward and increment column
                    isUpward = false;
                    j++;
                } else {                    // middle upward traversal
                    i--;
                    j++;
                }
            } else {
                if (i == n - 1) {           // Case when row index is at last row, change to upward and increment column
                    isUpward = true;
                    j++;
                } else if (j == 0) {        // Case when column index is at first column, change to downward and increment row
                    isUpward = true;
                    i++;
                } else {                    // middle downward traversal
                    i++;
                    j--;
                }
            }
        }
        return output;
    }
}