class Solution {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch: S.toCharArray()) {
            if (ch == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }
        return count + stack.size();
    }
}