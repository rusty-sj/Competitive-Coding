class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s == null || s.length() == 0)
            return maxLength;
        
        Map<Character, Integer> charRefs = new HashMap<>();
        int left = 0, right = 0;
        
        while (right < s.length() && left <= right) {
            char c = s.charAt(right);
            if (!charRefs.containsKey(c)) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = Math.max(left, charRefs.get(c) + 1);
                maxLength = Math.max(maxLength, right - left + 1);
            }
            charRefs.put(c, right);
            right++;
        }
        return maxLength;
    }
}