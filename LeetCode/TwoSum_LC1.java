/**
 * A matching pair would be found when complement element exists in array
 * Keep storing deficits in hashmap and whenever element and complement exist, pair is formed
 */

// Time Complexity: O(n)
// Space Complexity: O(n) Worst case all elements will be added to map
// Did this code successfully run on Leetcode : Yep
// Any problem you faced while coding this : NA¬
import java.util.HashMap;

public class TwoSum_LC1 {
    public int[] twoSum(int[] nums, int target) {

        // Store complement values as key: complement, value: index
        HashMap<Integer, Integer> deficits = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (deficits.containsKey(nums[i]))              // If complement value found in array, pair found
                return new int[]{deficits.get(nums[i]), i};
            deficits.put(target - nums[i], i);              // Add deficit to map
        }
        return new int[]{};
    }
}
