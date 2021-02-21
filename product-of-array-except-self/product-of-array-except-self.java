class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        Arrays.fill(leftProducts, 1);
        Arrays.fill(rightProducts, 1);
        
        for (int i = 1; i < n; i++) 
            leftProducts[i] *= leftProducts[i - 1] * nums[i - 1];
        for (int i = n - 2; i >= 0; i--) 
            rightProducts[i] *= rightProducts[i + 1] * nums[i + 1];
        
        for (int i = 0; i < n; i++) {
            nums[i] = (leftProducts[i] * rightProducts[i]);
        }
        return nums;
    }
}