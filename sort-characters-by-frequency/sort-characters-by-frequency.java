class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        StringBuilder output = new StringBuilder();
        Map<Character, Integer> counts = new HashMap<>();
        
        for (char c: s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> sortedMap = counts.entrySet().stream()
                         .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                         .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<Character, Integer> entry: sortedMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                output.append(entry.getKey());
            }
        }
        return output.toString();
    }
}