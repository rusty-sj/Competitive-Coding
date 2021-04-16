class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        int[] gasCost = new int[n];
        for (int i = 0; i < n; i++) {
            gasCost[i] = gas[i] - cost[i];
        }
        
        int totalExpend = 0, expend = 0, start = 0;
        for (int i = 0; i < n; i++) {
            expend += gasCost[i];
            totalExpend += gasCost[i];
            if (expend < 0) {
                start = i + 1;
                expend = 0;
            }
        }
        return totalExpend >= 0 ? start : -1;
    }
}