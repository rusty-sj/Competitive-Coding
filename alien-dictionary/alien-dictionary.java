class Solution {
    public String alienOrder(String[] words) {
        
        Map<Character, Integer> inDegrees = new HashMap<>();
        Map<Character, Set<Character>> outMap = new HashMap<>();
        for (String word: words) {
            for (char c: word.toCharArray()) {
                // Add every new character to in and out maps
                if (!outMap.containsKey(c)) {
                    outMap.put(c, new HashSet<Character>());
                    inDegrees.put(c, 0);
                }
            }
        }
        
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1], word2 = words[i];
            int len = Math.min(word1.length(), word2.length());
            boolean isDifferent = true;
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j), c2 = word2.charAt(j);
                if (c1 == c2) {
                    isDifferent = false;
                    continue;
                }
            
                if (!outMap.get(c1).contains(c2)) {
                    outMap.get(c1).add(c2);
                    inDegrees.put(c2, inDegrees.get(c2) + 1);
                }
                isDifferent = true;
                break;
            }
            
            if (!isDifferent && word1.length() > word2.length()) {
                return "";
            }
        }
        
        
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry: inDegrees.entrySet()) {
            System.out.println(entry.getKey() + " " +entry.getValue());
            if (entry.getValue() == 0) 
                queue.offer(entry.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();   
            sb.append(ch);
            if (outMap.containsKey(ch)) {
                for (char child: outMap.get(ch)) {
                    inDegrees.put(child, inDegrees.get(child) - 1);
                    if (inDegrees.get(child) == 0) {
                        queue.add(child);
                    }    
                }
            }
        }
        return sb.length() == inDegrees.size() ? sb.toString() : "";
    }
}