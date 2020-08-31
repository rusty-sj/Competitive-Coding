/**
 * Sorting will still make it O(n log n) and so we choose to maintain index array in order to keep track of
 * elements before or after an element(-1/+1)
 * Once radix array is formed, at every index, we have an option to choose or not choose it
 * Solve for getting max rewards
 */

// Time Complexity: O (max (n, maxElement)); n=length of array, maxElement=maximum value in nums
// Space Complexity: O (M); M=maxElement in nums
// Did this code successfully run on Leetcode : Yes
public class DeleteEarn_LC740 {
    public int deleteAndEarn(int[] nums) {
        // Handle empty input
        if (nums == null || nums.length == 0)
            return 0;

        // Initialize & construct radix array
        int[] radixA = new int[getMaxElement(nums) + 1];
        for (int num : nums)
            radixA[num] += num;

        // Problem reduced to House Robber
        int choose = 0, noChoose = 0;
        for (int num : radixA) {
            int temp = Math.max(choose, noChoose);
            choose = noChoose + num;                // Previous shouldn't be chosen
            noChoose = temp;
        }
        return Math.max(choose, noChoose);
    }

    public int getMaxElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums)
            if (num > max)
                max = num;
        return max;
    }
}
