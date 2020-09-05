/**
 * Maintain 2 pointers to extremes and update the less height pointer to explore higher height
 * calculate volume at each i, j position and update max water value
 **/

// Time Complexity: O (N) visit each height once
// Space Complexity: O (1) constant space
// Did this code successfully run on Leetcode : Yes
public class ContainerWater_LC11 {
    public int maxArea(int[] height) {
        // Handle empty input
        if (height == null || height.length <= 1)
            return 0;

        int i = 0, j = height.length - 1;       // Keep two pointers to extreme left and right
        int maxWater = 0;                       // Track max volume of water
        while (i < j) {                         // Manipulate left and right until they cross each other
            int waterVolume = (j - i) * Math.min(height[i], height[j]);     // Calculate current volume
            maxWater = Math.max(maxWater, waterVolume);                     // Update max volume
            if (height[i] > height[j])          // update less valued pointer to search for larger height
                j--;
            else
                i++;
        }

        return maxWater;
    }
}
