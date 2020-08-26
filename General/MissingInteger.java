
/**
 * Problem Statement:
 *
 * Given an array of n-1 integers in the range of 1 to n with no duplicates in list,
 * one of the integers is missing in the list. Write a code to find the missing integer.
 *
 * Test Case 1:
 * Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
 * Output : 4
 *
 * Test Case 2:
 * Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
 * Output : 3
 *
 * Approach:
 * Half array will always be sorted and so reduce search space to half wherever diff of indexes isn't same as diff of elements
 * Eventually low and mid coincide and that's where missing element point lies
 *
 * Edge cases of sorted array/empty array are handled
 * 
 * Time Complexity: log(N)
 * Space Complexity: O(1)
 **/

class MissingInteger {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 5};
        int n = 5;
        System.out.println(findMissingInteger(array, n));
    }

    static int findMissingInteger(int[] array, int n) {

        if (array == null || array.length == 0) {          // When array input in null
            if (n == 1)             // If length of array were to be n=1, missing element is 1
                return 1;
            return -1;
        }

        int low = 0, high = array.length - 1;
        if (array[0] != 1)              // if array doesn't start with 1, that's the missing element
            return 1;
        if (array[high] != n)           // If array doesn't end on n, that's the missing element
            return n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // missing integer lies wherever difference of indexes and elements isn't same
            if ((array[high] - array[mid]) != (high - mid)) {
                if (low == mid)                 // Found missing wherever low and mid coincide
                    return array[low] + 1;
                low = mid;                      // Reduce search space [mid...high]
            } else
                high = mid;                     // Reduce search space [low...mid]
        }
        return -1;
    }
}