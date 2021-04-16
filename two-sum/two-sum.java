class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (complements.containsKey(comp))
                return new int[]{complements.get(comp), i};
            complements.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}