/**
 * Keep two pointers left and right to manage 0s and 2s to be kept at the ends
 * Whenever current is 2, push it to right, 0s push to left, 1s just move current to traverse array
 */

// Time Complexity: O (n); n=length of array
// Space Complexity: O (1); constant space
// Did this code successfully run on Leetcode : Yes
public class SortColors_LC75 {
    public void sortColors(int[] nums) {

        // Handle empty input
        if (nums == null || nums.length == 0)
            return;

        int left = 0, right = nums.length - 1, current = 0;     // Left, right and current pointers

        while (current <= right) {              // exploit current until whole array is covered
            if (nums[current] == 2) {           // Put 2s at the end, decrement right
                swap(nums, current, right);
                right--;
            } else if (nums[current] == 0) {    // Put 0s at the start, increment left and move current ahead
                swap(nums, current, left);
                left++;
                current++;
            } else {                            // For 1s, just move current ahead
                current++;
            }
        }
    }

    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
