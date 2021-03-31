class Solution {
    public int titleToNumber(String columnTitle) {
        int multiplier = 26;
        int output = 0;
        
        int i = columnTitle.length() - 1;
        for (char c: columnTitle.toCharArray()) {
            output = output + (((int)(c - 'A') + 1) * (int) Math.pow(multiplier, i--));
        }
        return output;
    }
}