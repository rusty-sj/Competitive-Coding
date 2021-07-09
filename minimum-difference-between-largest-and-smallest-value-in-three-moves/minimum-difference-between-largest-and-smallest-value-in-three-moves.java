class Solution {
    public int minDifference(int[] nums) {
        if (nums == null || nums.length <= 4)
            return 0;
        Arrays.sort(nums);
    
        int n = nums.length;
        int[] trials = new int[4];
        
        trials[0] = nums[n - 1] - nums[3];
        trials[1] = nums[n - 4] - nums[0];
        trials[2] = nums[n - 3] - nums[1];
        trials[3] = nums[n - 2] - nums[2];
        
        Arrays.sort(trials);
        return trials[0];
    }
}