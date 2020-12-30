class Solution {
    public int maxProfit(int[] prices) {
        // TC: O(n)
        // SC: O(1)
        int minCost1 = Integer.MAX_VALUE, minCost2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;
        for (int price: prices) {
            // Transaction 1
            minCost1 = Math.min(minCost1, price);
            profit1 = Math.max(profit1, price - minCost1);
            
            // Transaction 2
            minCost2 = Math.min(minCost2, price - profit1);
            profit2 = Math.max(profit2, price - minCost2);
        }
        return profit2;
    }
}
