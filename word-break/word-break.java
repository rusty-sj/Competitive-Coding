class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return recursion(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
    }
    
    public boolean recursion(String s, int start, Set<String> wordDict, Boolean[] memo) {
        if (start == s.length())
            return true;
        
        if (memo[start] != null)
            return memo[start];
        
        for (int end = start; end < s.length(); end++) {
            if (wordDict.contains(s.substring(start, end + 1)) && recursion(s, end + 1, wordDict, memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }
}