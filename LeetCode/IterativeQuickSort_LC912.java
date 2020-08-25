/**
 * Time Complexity : best case: O(n log n); worst case O(n2)
 * Space Complexity: best case: O(log n); worst case O(n)
 * Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/sort-an-array/
 */
public class IterativeQuickSort_LC912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int h) {
        if (l >= h)
            return;
        int[] stack = new int[h - l + 1];       // Stack to handle recursive nature
        int top = -1;                           // top of empty stack
        stack[++top] = l;                       // Insert low and high into stack
        stack[++top] = h;

        // keep popping stack until it's empty
        while (top >= 0) {
            h = stack[top--];       // process for popped l and h
            l = stack[top--];
            int pivotIndex = partition(nums, l, h);  // partition around current pivot
            if (pivotIndex - 1 > l) {                   // push pivotIndex onto stack for left half
                stack[++top] = l;
                stack[++top] = pivotIndex - 1;
            }
            if (pivotIndex < h) {               // push pivotIndex onto stack for right half
                stack[++top] = pivotIndex;
                stack[++top] = h;
            }
        }
    }

    public int partition(int[] nums, int l, int h) {
        int pivot = nums[l + (h - l) / 2];          // Pivot center element
        while (l <= h) {
            while (nums[l] < pivot)
                l++;
            while (nums[h] > pivot)
                h--;
            if (l <= h) {
                swap(nums, l, h);
                l++;
                h--;
            }
        }
        return l;
    }

    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }
}
