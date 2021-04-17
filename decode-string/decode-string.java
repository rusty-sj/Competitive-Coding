class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        int i = 0, number = 0;
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(number);
                strStack.push(sb);
                sb = new StringBuilder();
                number = 0;
            } else if (ch == ']') {
                StringBuilder expansion = strStack.pop();
                for (int j = countStack.pop(); j > 0; j--) {
                    expansion.append(sb);
                }
                sb = expansion;
            }
            else {
                sb.append(ch);
            }
            i++;
        }
        return sb.toString();
    }
}