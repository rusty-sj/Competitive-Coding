/**
 * Keep 3 pointers: one at rightmost of nums1, one at rightmost of nums2, one at rightmost filled element of nums1
 * compare values at indexes and put max element at write index, break out when one of the two are exhausted
 * copy other array if it wasnt exhausted
 **/

// Time Complexity: O (N+M) both arrays of size n and m are traversed entirely
// Space Complexity: O (1) constant space
// Did this code successfully run on Leetcode : Yes
public class MergeSorted_LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Keep 3 pointers to modify values in place
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];        // put max value at k index
            else
                nums1[k--] = nums2[j--];
        }

        while (j >= 0)                          // nums2 wasn't parsed completely; nums1 exhausted; copy nums2
            nums1[k--] = nums2[j--];
    }
}
