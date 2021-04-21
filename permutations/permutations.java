class Solution {
    List<List<Integer>> output = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        Integer[] interim = new Integer[nums.length];
        permute(nums, 0, interim);
        return output;
    }
    
    public void permute(int[] nums, int index, Integer[] interim) {
        if (index == nums.length) {
            output.add(Arrays.asList(interim));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (interim[i] == null) {
                Integer[] arr = Arrays.copyOf(interim, interim.length);
                arr[i] = nums[index];
                permute(nums, index + 1, arr);
            }
        }
    }
    
}