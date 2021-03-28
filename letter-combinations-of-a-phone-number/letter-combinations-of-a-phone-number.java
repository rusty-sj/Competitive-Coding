class Solution {
    List<String> output;
    public List<String> letterCombinations(String digits) {
        output = new ArrayList<>();
        
        // Empty input
        if (digits == null || digits.length() == 0)
            return output;
        // Store keypad mappings
        Map<Character, String> mappings = new HashMap<>() {{
            put('2', "abc"); put('3', "def"); put('4', "ghi");
            put('5', "jkl"); put('6', "mno"); put('7', "pqrs");
            put('8', "tuv"); put('9', "wxyz");
        }};
        
        backtrack(new StringBuilder(), digits, 0, mappings);
        
        return output;
    }
    
    public void backtrack(StringBuilder sb, String digits, int index, Map<Character, String> map) {
        // Base case
        if (index == digits.length()) {
            output.add(sb.toString());
            return;
        }
        
        // Explore each character
        for (Character c: map.get(digits.charAt(index)).toCharArray()) {
            backtrack(sb.append(c), digits, index + 1, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}