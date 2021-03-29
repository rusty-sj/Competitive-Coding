class Solution {
    public int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int num: nums) {
            singleNum ^= num;
        }
        return singleNum;
    }
}