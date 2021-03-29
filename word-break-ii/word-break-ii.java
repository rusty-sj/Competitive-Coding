class Solution {
    List<String> output;
    public List<String> wordBreak(String s, List<String> wordDict) {
        output = new ArrayList<>();
        backtrack(s, wordDict, new StringBuilder());
        return output;
    }
    
    public void backtrack(String s, List<String> wordDict, StringBuilder sb) {
        if (s.length() <= 0) {
            output.add(sb.toString().trim());
            return;
        }
        for (String word: wordDict) {
            if (s.startsWith(word)) {
                int len1 = sb.length();
                sb.append(word);
                sb.append(" ");
                backtrack(s.substring(word.length()), wordDict, sb);
                sb = new StringBuilder(sb.substring(0, len1));
            }
        }
    }
}