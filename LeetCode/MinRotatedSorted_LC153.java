/**
 * On noticing pattern of rotations, if element at mid is greater than element at end, the skew lies in the right half
 * and so update start to begin with mid+1
 * If element at mid is smaller than element at end, that means the portion is sorted and so we make end point to mid;
 * not mid-1 as per BS
 * Continue the search until start < end
 * return array element at position start
 */

// Time Complexity: log (n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yep

public class MinRotatedSorted_LC153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right])        // Skew in right half if mid value is larger than rightmost value
                left = mid + 1;
            else
                right = mid;                    // Don't want to lose mid so don't do mid-1
        }
        return nums[left];
    }
}
