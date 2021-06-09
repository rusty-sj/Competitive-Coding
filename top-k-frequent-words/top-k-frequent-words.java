class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {        
        Map<String, Integer> map = new HashMap<>();
        
        for (String word: words) 
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b)-> (a.getValue() == b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }
        
        List<String> output = new ArrayList<>();
        while (!map.isEmpty() && k-- > 0) {
            output.add(queue.poll().getKey());
        }
        return output;
    }
}