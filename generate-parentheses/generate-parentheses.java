class Solution {
    
    List<String> output = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        recursion(new StringBuilder(), 0, 0, n);
        return output;
    }
    
    public void recursion(StringBuilder sb, int openCount, int closeCount, int n) {
        // If string length goes beyond n * 2 or closing brackets exceed opening, return
        if (sb.length() >  n * 2 || closeCount > openCount)
            return;
        
        // If string length reaches n * 2 and we have balanced count, append to output
        if (sb.length() ==  n * 2 && closeCount == openCount) {
            output.add(sb.toString());
            return;
        }
        // Choose to include opening bracket
        recursion(sb.append("("), openCount + 1, closeCount, n);
        
        
        sb.deleteCharAt(sb.length() - 1);
        
        // Choose to include closing bracket
        recursion(sb.append(")"), openCount, closeCount + 1, n);
        
        sb.deleteCharAt(sb.length() - 1);
    }
}