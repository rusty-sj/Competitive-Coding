class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int subLen = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                subLen = Math.min(subLen, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return subLen != Integer.MAX_VALUE ? subLen : 0;
    }
}