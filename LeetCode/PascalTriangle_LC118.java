import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_LC118 {
    /**
     * First pascal row is always [1]. Keep it hardcoded. Loop for 2 to n, use prev row elements to find intermediate
     * elements in current row. keep first and last element 1. compute in between
     * 
     * Time Complexity O(N^2) where n is number of rows
     * Space Complexity: O(N^2) all rows are stored
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        if (numRows == 0)
            return rows;

        rows.add(new ArrayList<>());
        rows.get(0).add(1);             // 0th row

        for (int i = 1; i < numRows; i++) {     // Row 1 to numRows
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = rows.get(i - 1);   // Get prev row

            row.add(1);         // First row elem always 1

            for (int j = 0; j < prev.size() - 1; j++) {     // Compute middle elems with prev row
                row.add(prev.get(j) + prev.get(j + 1));
            }

            row.add(1);         // First row elem always 1

            rows.add(row);      // Add calculated row to output
        }
        return rows;
    }
}
