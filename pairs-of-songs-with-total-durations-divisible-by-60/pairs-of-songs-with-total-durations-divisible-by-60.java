class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int pairCount = 0;
        if (time == null || time.length == 0)
            return pairCount;
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int rem = time[i] % 60;
            pairCount += freq.getOrDefault((60 - rem) % 60, 0);
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }
        return pairCount;
    }
}