/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int index = getPeakElement(mountainArr, length);
        
        int found = binarySearchLeft(mountainArr, index, target);
        if (found == -1) {
            found = binarySearchRight(mountainArr, index, length, target);
        }
        return found;
    }
    
    public int binarySearchLeft(MountainArray mountainArr, int index, int target) {
        int low = 0, high = index;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) == target)
                return mid;
            else if (mountainArr.get(mid) < target) 
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    
    public int binarySearchRight(MountainArray mountainArr, int index, int n, int target) {
        int low = index + 1, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) == target)
                return mid;
            else if (mountainArr.get(mid) > target) 
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    
    public int getPeakElement(MountainArray mountainArr, int n) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else
                high = mid;
        }
        return low;
    }
}