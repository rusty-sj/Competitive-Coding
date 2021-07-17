class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (mid > 0 && nums[mid] > nums[mid - 1] 
                && mid < nums.length - 1 && nums[mid] > nums[mid + 1])
                return mid;
            
            if (nums[mid + 1] > nums[mid])
                low = mid + 1; 
            else
                high = mid - 1;
        }
        return low;
    }
    
    // 1 2 3 4 5 3 2 1
}