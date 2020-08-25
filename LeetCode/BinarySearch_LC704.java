/**
 * Time Complexity : O(log n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode : Yes
 */
public class BinarySearch_LC704 {

    public int search(int[] nums, int target) {
        return binarySearchIterative(nums, 0, nums.length - 1, target);
        // return binarySearchRecursive(nums, 0, nums.length - 1, target);
    }

    /**
     * Iterative Binary Search
     *
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public int binarySearchIterative(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;    // To prevent int overflow in (left + right) / 2

            if (nums[mid] == target)                // Target found
                return mid;

            if (nums[mid] > target)                 // Discard right half
                right = mid - 1;
            else                                    // Discard left half
                left = mid + 1;
        }
        return -1;
    }

    /**
     * Recursive Binary Search
     *
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public int binarySearchRecursive(int[] nums, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                return binarySearchRecursive(nums, mid + 1, right, target);
            else
                return binarySearchRecursive(nums, left, mid - 1, target);
        }
        return -1;
    }
}
