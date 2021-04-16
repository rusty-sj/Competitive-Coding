class Solution {
    public int lengthOfLongestSubstring(String s) {
        // handle empty input
        if (s == null || s.length() == 0)
            return 0;
        
        Map<Character, Integer> occurences = new HashMap<>();
        int start = 0, end = 0, maxLength = 0;
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (occurences.containsKey(endChar)) {
                start = Math.max(occurences.get(endChar) + 1, start);
            }
            maxLength = Math.max(maxLength, end - start + 1);
            occurences.put(endChar, end);
            end++;
        }
        return maxLength;
    }
}