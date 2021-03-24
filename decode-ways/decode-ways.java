class Solution {
    int count = 0;
    Map<Integer, Integer> seens;
    public int numDecodings(String s) {
        seens = new HashMap<>();
        recursion(s, 0);
        return count;
    }
    
    public void recursion(String s, int index) {
        if (seens.containsKey(index)) {
            count += seens.get(index);
            return;
        }
        
        if (index == s.length()) {
            count++;
            return;
        }
        
        if (s.charAt(index) == '0') {
            return;
        }
        
        // Choice 1: pick single digit
        recursion(s, index + 1);
        
        // Choice 2: pick 2 digit number
        if (index < s.length() - 1) {
            int number = Integer.parseInt(s.substring(index, index + 2));
            if (number <= 26)
                recursion(s, index + 2);
        }
        
        seens.put(index, count);
    }
}