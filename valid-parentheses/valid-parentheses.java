class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        
        Map<Character, Character> mappings = new HashMap<>(){{ put('(', ')');
                                                               put('[', ']');
                                                               put('{', '}');}};
        
        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(mappings.get(c));
            else if (c == ')' || c == ']' || c == '}') {
                if (!stack.isEmpty() && stack.peek() == c)
                    stack.pop();
                else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}