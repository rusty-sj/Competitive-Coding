import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * loop from 0 to n and for every element keep left right pointers to explore 3 elements sum
 * manage left, right as per the desired sum=0, move it towards more positive or more negative to reach sum 0
 * to handle duplicates skip over them wherever found
 */

// Time Complexity: O (n2); n=length of array
// Space Complexity: O (1); constant space
// Did this code successfully run on Leetcode : Yes

public class ThreeSum_LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i != 0 && nums[i] == nums[i - 1])       // For not adding same set twice in the output list
                continue;

            int left = i + 1, right = nums.length - 1; // ith element, left from i+1 to n

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {                          // If sum is less than 0, we need more positive value
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;    // Skip duplicates
                } else if (sum > 0) {                   // If sum is more than 0, we need lesser value
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else {
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));    // sum 0, add to output

                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;

                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return output;
    }
}
