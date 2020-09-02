/**
 * Use one for loop to calculate left product except self
 * Another for loop for calculating right except self and final array product except self
 **/

// Time Complexity: O (N) : N=arraysize; specifically 2N
// Space Complexity: O (1) excluding output array
// Did this code successfully run on Leetcode : Yes
public class ProductExceptSelf_LC238 {
    public int[] productExceptSelf(int[] nums) {

        // Handle empty input
        if (nums == null || nums.length == 0)
            return new int[0];

        // Output array
        int[] output = new int[nums.length];

        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return output;
    }
}
