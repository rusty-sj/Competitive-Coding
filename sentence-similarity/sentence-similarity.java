class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        
        if (sentence1.length != sentence2.length) {
            return false;
        }
        
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair: similarPairs) {
            String word1 = pair.get(0), word2 = pair.get(1);
            if (!map.containsKey(word1))
                map.put(word1, new HashSet<>());
            if (!map.containsKey(word2))
                map.put(word2, new HashSet<>());
            map.get(word1).add(word2);
            map.get(word2).add(word1);
        }
        
        int i = 0;
        while (i < sentence1.length) {
            String word1 = sentence1[i], word2 = sentence2[i];
            if (word1.equals(word2)) {
                i++;
                continue;
            }
            if ((map.containsKey(word1) && !map.get(word1).contains(word2)) || (map.containsKey(word2) && !map.get(word2).contains(word1)))
                return false;
            i++;
        }
        return true;
    }
}