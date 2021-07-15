class Solution {
    public void sortColors(int[] nums) {
        int i = 0, low = 0, high = nums.length - 1;
        
        while (i <= high && low <= high) {
            if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            } else if (nums[i] == 0) {
                swap(nums, i, low);
                low++;
                i++;
            } else {
                i++;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}