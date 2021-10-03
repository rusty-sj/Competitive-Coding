class Solution {
    Integer[][] cache;
    public int twoEggDrop(int n) {        
        cache = new Integer[n + 1][2 + 1];
        return helper(n, 2);
    }
    
    public int helper(int floors, int eggs) {
        if (cache[floors][eggs] != null)
            return cache[floors][eggs];
        if (floors <= 1 || eggs == 1)
            return floors;
        int minMoves = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            int breaks = helper(i - 1, eggs - 1);
            int noBreak = helper(floors - i, eggs);
            minMoves = Math.min(minMoves, 1 + Math.max(breaks, noBreak));
        }
        return cache[floors][eggs] = minMoves;
    }
}