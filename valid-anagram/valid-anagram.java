class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c: t.toCharArray()) {
            if (!map.containsKey(c))
                return false;
            else
                map.put(c, map.getOrDefault(c, 0) - 1);
        }
        
        for (Integer count: map.values()) {
            if (count != 0)
                return false;
        }
        return true;
    }
}