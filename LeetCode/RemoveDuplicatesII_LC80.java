/**
 * We know that array of length 2 is always sorted as per problem, thus start with 3rd element
 * check if current element is same as previous two from insert index
 * if yes, its a duplicate, just move to next element
 * if no, its a value to be considered, add it at insert index and increment insert index
 */

// Time Complexity: O (n); n=length of array
// Space Complexity: O (1); constant space
// Did this code successfully run on Leetcode : Yes

public class RemoveDuplicatesII_LC80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null)           // null array input
            return 0;

        if (nums.length <= 2)       // array is as expected output if length <= 2
            return nums.length;

        // First two elements will always be sorted + non-duplicate so start loop with 2
        int insertIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[insertIndex - 1] || nums[i] != nums[insertIndex - 2]) {     // If current isn't same as previous two at insert index
                nums[insertIndex++] = nums[i];                                              // Not a duplicate, add at insert index
            }
        }

        return insertIndex;                 // Length of final array
    }
}
