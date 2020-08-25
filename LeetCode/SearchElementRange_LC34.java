/**
 * Use binary search twice to find left index and right index separately
 * Modify binary search to find leftmost index such that it searches to the left of found index and vice versa for right index
 * If element is not found, return [-1, -1]
 */

// Time Complexity: 2 * log (n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yep

public class SearchElementRange_LC34 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = -1, rightIndex = -1;
        int low = 0, high = nums.length - 1;

        // Find left index using BS
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                leftIndex = mid;                // When target is spotted, set high to search towards left
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Find right index using BS
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {          // When target is spotted, set low to search towards right
                rightIndex = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }
}
