/**
 * Since we can't use extra space, use the same input array to store info of seen elements by marking value indexes negative
 * if an element doesn't exist, its corresponding index would remain positive
 * all such positive values are disappeared numbers
 **/

// Time Complexity: O (N) : N=array size
// Space Complexity: O (1) excluding output array
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class DisappeardNumbers_LC448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Handle empty input
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;        // Get index corresponding to element
            if (nums[val] > 0)
                nums[val] *= -1;                    // If not visited, mark the index element negative
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                output.add(i + 1);                  // all positives are disappeared numbers
        }
        return output;
    }
}
