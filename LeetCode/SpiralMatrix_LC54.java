import java.util.ArrayList;
import java.util.List;

/**
 * Use four pointers top, left, bottom, and right to access indexes and traverse array in a spiral
 * fashion
 **/

// Time Complexity: O (N*M) : rows x columns (each element visited once)
// Space Complexity: O (1) excluding output arraylist
// Did this code successfully run on Leetcode : Yes
class SpiralMatrix_LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new ArrayList<>();

        List<Integer> traversal = new ArrayList<>();

        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {

            // Row left to right
            for (int i = left; i <= right; i++)
                traversal.add(matrix[top][i]);
            top++;

            // Column top to bottom
            for (int i = top; i <= bottom; i++)
                traversal.add(matrix[i][right]);
            right--;

            // Row right to left
            if (top <= bottom) {            // Handle non-square matrix
                for (int i = right; i >= left; i--)
                    traversal.add(matrix[bottom][i]);
                bottom--;
            }

            // Column bottom to top
            if (left <= right) {            // Handle non-square matrix
                for (int i = bottom; i >= top; i--)
                    traversal.add(matrix[i][left]);
                left++;
            }
        }
        return traversal;
    }
}