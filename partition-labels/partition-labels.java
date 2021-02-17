class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> output = new ArrayList<>();
        if (S == null || S.length() == 0)
            return output;
        
        // One sweep to find all last indices
        int[] lastIndices = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastIndices[S.charAt(i) - 'a'] = i;
        
        int start = 0, end = 0, i = 0;
        while (i < S.length()) {
            if (end < lastIndices[S.charAt(i) - 'a'])
                end = lastIndices[S.charAt(i) - 'a'];
            if (i == end) {
                output.add(end - start + 1);
                start = end + 1;
            }
            i++;
        }
        
        return output;
    }
}