/**
 * Maintain two HashMaps for two way mappings (Bijection)
 * Iterate through str and check if mappings match with the one's in stored hashmaps,
 * wherever conflict is found, return false
 */

// Time Complexity: O (N) N: Number of strings in strs;
// Space Complexity: O(M) + O(26) M: Number of distinct strs in strMap, O(26) for charMap
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

public class WordPattern_LC290 {
    public boolean wordPattern(String pattern, String str) {
        // Edge case
        if (str == null || str.length() == 0)
            return false;

        String[] strings = str.split("\\s+");

        // If sizes are different, one to one mappings aren't possible
        if (pattern.length() != strings.length)
            return false;

        // Two maps for two way mapping; Bijection
        HashMap<Character, String> charMap = new HashMap<>();
        HashMap<String, Character> strMap = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            char c = pattern.charAt(i);
            if (!strMap.containsKey(strings[i]))        // Add new mapping
                strMap.put(strings[i], c);
            else if (!strMap.get(strings[i]).equals(c))      // Mapping exists but mismatch spotted
                return false;
            if (!charMap.containsKey(c))                // Add new mapping
                charMap.put(c, strings[i]);
            else if (!charMap.get(c).equals(strings[i]))     // Mapping exists but mismatch spotted
                return false;
        }
        return true;
    }
}
