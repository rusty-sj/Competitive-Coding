class Solution {
    
    List<List<Integer>> output;
    
    public List<List<Integer>> subsets(int[] nums) {
        output = new ArrayList<>();
        recurse(nums, 0, new ArrayList<Integer>());
        return output;
    }
    
    public void recurse(int[] nums, int index, List<Integer> list) {
        // A subset is found when we have covered all indices in input
        if (index == nums.length) {
            output.add(list);
            return;
        }
        
        // Do not include element at index: Create copy to avoid referencing issue
        recurse(nums, index + 1, new ArrayList<Integer>(list));
        
        // Include element at index: Create copy to avoid referencing issue
        List<Integer> temp = new ArrayList<Integer>(list);
        temp.add(nums[index]);
        recurse(nums, index + 1, temp);
    }
}