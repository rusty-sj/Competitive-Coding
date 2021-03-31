class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        // Compute counts and store in a map
        for (int num: nums) 
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        
        // Store pair number -> count sorted on counts
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // Fill max heap using counts
        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) 
            queue.add(new int[] {entry.getKey(), entry.getValue()});
        
        
        int[] output = new int[k];
        int i = 0;
        while (i < k) {
            if (!queue.isEmpty())
                output[i++] = queue.poll()[0];
        }
        return output;
    }
}