class Solution {
    
    List<List<Integer>> output;
    public List<List<Integer>> subsets(int[] nums) {
        output = new ArrayList<>();
        recurse(nums, 0, new ArrayList<Integer>());
        return output;
    }
    
    public void recurse(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            output.add(list);
            return;
        }
        
        recurse(nums, index + 1, new ArrayList<Integer>(list));
        List<Integer> temp = new ArrayList<Integer>(list);
        temp.add(nums[index]);
        recurse(nums, index + 1, temp);
        
    }
}