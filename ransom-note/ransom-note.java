class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> counts = new HashMap<>();
        
        for (char ch: magazine.toCharArray()) 
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        
        for (char ch: ransomNote.toCharArray()) {
            if (counts.getOrDefault(ch, 0) == 0)
                return false;
            counts.put(ch, counts.get(ch) - 1);
        }
        return true;
    }
}