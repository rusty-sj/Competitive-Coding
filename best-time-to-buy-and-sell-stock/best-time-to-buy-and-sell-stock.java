class Solution {
    
    public int maxProfit(int[] prices) {
        // Empty input
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int minPrice = prices[0], profit = -prices[0];
        
        int i = 1;
        while (i < prices.length) { 
            if (prices[i] < minPrice)   // buy if found a lesser price
                minPrice = prices[i];
            else {
                profit = Math.max(profit, prices[i] - minPrice);    // Try selling and see if we found better profit
            }
            i++;
        }
        
        return profit < 0 ? 0 : profit;
    }
}