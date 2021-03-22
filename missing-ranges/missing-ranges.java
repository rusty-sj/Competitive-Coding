class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> output = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            output.add(findRange(lower, upper));
            return output;
        }
        
        if (lower <= nums[0] - 1)
            output.add(findRange(lower, nums[0] - 1));
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1)
                output.add(findRange(nums[i] + 1, nums[i + 1] - 1));
        }
        if (nums[nums.length - 1] + 1 <= upper)
            output.add(findRange(nums[nums.length - 1] + 1, upper));
        return output;
    }
    
    public String findRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }
}