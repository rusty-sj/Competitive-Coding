/**
 * Maintain a HashMap<char, char> for storing key(char in s)->value(char in t) mappings
 * To make sure that one multiple characters don't point to same char in t, maintain a HashSet of mapped value chars of t
 * Wherever mapping is violated, return false
 */

// Time Complexity: O (N) N: number of characters in s/t
// Space Complexity: O(26) + O(26) since only 26 unique characters are possible in HashMap and HashSet
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings_LC205 {
    public boolean isIsomorphic(String s, String t) {

        // Handle Empty Input
        if (s == null || t == null)
            return false;

        if (s.length() != t.length())
            return false;

        // Map for storing char(s) --> char(t) mappings
        Map<Character, Character> mappings = new HashMap<>();
        Set<Character> mappedChars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (!mappings.containsKey(cs)) {        // New key
                if (mappedChars.contains(ct))       // Check if value is already mapped to some char in t
                    return false;
                mappings.put(cs, ct);
                mappedChars.add(ct);
            } else {
                if (!mappings.get(cs).equals(ct))   // If doesn't follow mapping in hashmap
                    return false;
            }
        }
        return true;
    }
}
