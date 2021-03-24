class Solution {
    public int maxProfit(int[] prices) {
        
        int minCost = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        // Try to buy on minimum cost and sell whenever price is more than minCost
        for (int i = 0; i < prices.length; i++) {
            // If price is less than minimum cost, update minimum cost
            if (prices[i] < minCost)
                minCost = prices[i];
            else {
            // If price is more than min, try to sell and update profit
                int profit = prices[i] - minCost;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}