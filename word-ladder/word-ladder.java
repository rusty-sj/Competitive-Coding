class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String queueWord = queue.poll();
                if (queueWord.equals(endWord))
                    return level;
                for (String word: wordList) {
                    if (!visited.contains(word) && differsByOneChar(word, queueWord)) {
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    
    public boolean differsByOneChar(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                diffCount++;
        }
        return diffCount == 1;
    }
}