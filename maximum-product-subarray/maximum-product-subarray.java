class Solution {
    public int maxProduct(int[] nums) {
        // Empty input
        if (nums == null || nums.length == 0)
            return 0;
        
        int maxProd = nums[0], currMin = nums[0], currMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int tempCurrMin = Math.min(nums[i], Math.min(nums[i] * currMin, nums[i] * currMax));
            currMax = Math.max(nums[i], Math.max(nums[i] * currMin, nums[i] * currMax));
            currMin = tempCurrMin;
            maxProd = Math.max(maxProd, currMax);
        }
        return maxProd;
    }
}