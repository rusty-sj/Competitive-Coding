class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int start = 0, end = n;
        while (start <= end) {
            int part1 = (start + end) / 2;
            int part2 = ((n + m + 1) / 2) - part1;
            
            int maxLeft1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            int minRight1 = (part1 == n) ? Integer.MAX_VALUE : nums1[part1];
            
            int maxLeft2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            int minRight2 = (part2 == m) ? Integer.MAX_VALUE : nums2[part2];
            
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found desired partition
                if ((n + m) % 2 == 0) {
                    return ((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                } else {
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
                
            } else if (maxLeft1 > minRight2) {
                end = part1 - 1;
            } else {
                start = part1 + 1;
            }
        }
        return 0.0;
    }
}