/**
 * Although the array is not sorted, Binary Search can be applied
 *
 * Start BS loop and if element at mid is greater than elements at mid-1 and mid+1, it is found, return it
 * If element at mid is smaller than element at mid + 1, halve the search space to [mid+1...high]
 * Else halve it to [low...mid - 1]
 * If loop terminates, low pointer points to peak element handling edge cases of sorted arrays
 */

// Time Complexity: log (n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yep
// Any problem you faced while coding this : NA

public class PeakElement_LC162 {
    public int findPeakElement(int[] nums) {
        // Handle Empty Input
        if (nums == null || nums.length == 0)
            return -1;

        // Variation in Binary Search
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Peak Found if mid element is greater than mid-1 and mid+1
            if (mid > 0 && mid < nums.length - 1
                    && nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid])
                return mid;

            // Halve the search space when element at mid is smaller than the one after/before it
            if (nums[mid + 1] > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;  // Low updates to peak element position
    }
}
