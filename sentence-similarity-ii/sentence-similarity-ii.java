class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length)
            return false;
        
        Map<String, Set<String>> map = new HashMap<>();   // Adjacency list
        for (List<String> pair: pairs) {
            String word1 = pair.get(0), word2 = pair.get(1);
            map.putIfAbsent(word1, new HashSet<>());
            map.putIfAbsent(word2, new HashSet<>());
            map.get(word1).add(word2);
            map.get(word2).add(word1);
        }
        
        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i], w2 = words2[i];
            if (w1.equals(w2))                      // Same words
                continue;
            if (!dfs(map, w1, w2, new HashSet<>())) 
                return false;
        }
        return true;
    }
    
    public boolean dfs(Map<String, Set<String>> map, String w1, String w2, Set<String> visited) {
        if (map.containsKey(w1)) {
            if (map.get(w1).contains(w2)) return true;
            
            visited.add(w1);
            for (String next: map.get(w1)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    if (dfs(map, next, w2, visited))
                        return true;
                }
            }
        }
        
        return false;
    }
}