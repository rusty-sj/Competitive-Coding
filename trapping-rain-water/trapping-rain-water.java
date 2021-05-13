class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        
        int p1 = 0, p2 = height.length - 1;
        int water = 0, leftMax = 0, rightMax = 0;
        
        while (p1 < p2) {
            leftMax = Math.max(leftMax, height[p1]);
            rightMax = Math.max(rightMax, height[p2]);
            
            if (height[p1] < height[p2])
                water += leftMax - height[p1++];
            else
                water += rightMax - height[p2--];
        }
        return water;
    }
}