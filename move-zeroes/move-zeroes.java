class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, start = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
            }
            i++;
        }
    }
}