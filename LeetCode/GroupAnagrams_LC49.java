/**
 * Maintain an array of first 26 prime numbers for forming key in hashmap
 * Traverse through array of strings, compute key as multiplication of prime corresponding to character
 * Store Key value pairs in HashMap
 * Return all list of values from HashMap
 */

// Time Complexity: O (N * K) N: Number of strings in strs; K: length of longest string
// Space Complexity: O (N * K) N: Number of strings in strs; K: length of longest string
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        /**
         * Approach 1: Lesser optimal
         * Time Complexity O(N * L log L)
         * Space Complexity O(N * L)
         **/
        /*HashMap<String, List<String>> groups = new HashMap<>();

        for (String string: strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String mapKey = String.valueOf(chars);
            if (!groups.containsKey(mapKey))
                groups.put(mapKey, new ArrayList());
            groups.get(mapKey).add(string);
        }
        return new ArrayList(groups.values());*/

        /**
         * Approach 2
         * Time Complexity O(N*L)
         * Space Complexity O(N*L)
         **/

        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        HashMap<Long, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            long product = 1;
            for (char c : str.toCharArray()) {
                product *= primes[c - 'a'];
            }
            if (!groups.containsKey(product))
                groups.put(product, new ArrayList<String>());
            groups.get(product).add(str);
        }
        return new ArrayList(groups.values());
    }
}
