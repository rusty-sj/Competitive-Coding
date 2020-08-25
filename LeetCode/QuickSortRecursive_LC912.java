/**
 * Time Complexity : O(n log n); worst case O(n2)
 * Space Complexity: log n Stack frames for recursion; worst case O(n)
 * Did this code successfully run on Leetcode : Yes
 **/
public class QuickSortRecursive_LC912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int partition(int[] arr, int low, int high) {
        //Write code here for Partition and Swap
        int pivot = arr[low + (high - low) / 2];          // Pivot center element
        while (low <= high) {
            while (arr[low] < pivot)
                low++;
            while (arr[high] > pivot)
                high--;
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void quickSort(int[] arr, int low, int high) {
        // Recursively sort elements before
        // partition and after partition
        if (low >= high) return;
        int partition = partition(arr, low, high);
        quickSort(arr, low, partition - 1);
        quickSort(arr, partition, high);
    }
}
