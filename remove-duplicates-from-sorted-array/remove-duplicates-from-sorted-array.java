class Solution {
    public int removeDuplicates(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
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
