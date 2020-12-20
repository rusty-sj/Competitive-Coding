class Solution {
    public int removeDuplicates(int[] nums) {
        // 0,0,1,1,1,2,2,3,3,4
        if (nums == null || nums.length == 0)
            return 0;
        int readHead = 1, writeHead = 1;
        int prev = nums[0];
        while (readHead < nums.length) {
            if (nums[readHead] != prev) {
                nums[writeHead++] = nums[readHead];
            } 
            prev = nums[readHead];
            readHead++;
        }
        return writeHead;
    }
}
