/**
 * The idea is that when an element is bigger than other, there's no need to compare it win min value because greater element can never
 * be a competent for min value
 * Start by making a pair, find small and big value from the pair; compare small value with min and big one with max
 * This way we save unnecessary computation of both being compared to min and max
 * If array is odd length, compare last value with both min and max
 **/

// Number of computations: 3N/2 + 2 (N/2 because whole array is divided in pairs of 2; 3 computations per pair and; +2 for odd length array
// Time Complexity: O (n/2)
// Space Complexity: O (1) constant space
// Did this code successfully run on Leetcode : Yes
public class MinMaxOptimized {
    public static void main(String[] args) {
        int[] array = new int[]{10, 5, 9, 0, -1, 5, 0, 19, 20, 25, -10, 1, 30, 20};

        getMinMax(array);
    }

    static void getMinMax(int[] array) {
        int n = array.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += 2) {        // Compare in pairs
            if (array[i] > array[i + 1]) {
                max = Math.max(max, array[i]);      // compare bigger elem with max value
                min = Math.min(min, array[i + 1]);  // compare smaller elem with min value
            } else {
                min = Math.min(min, array[i]);
                max = Math.max(max, array[i + 1]);
            }
        }
        if (n % 2 != 0) {                           // Odd length array
            min = Math.min(min, array[n - 1]);
            max = Math.max(max, array[n - 1]);
        }
        System.out.println("Min: " + min + ", Max: " + max);
    }
}