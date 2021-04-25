class Solution {
    
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] > prices[i + 1])
                i++;
            
            profit -= prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1])
                i++;
            profit += prices[i];
            i++;
        }
        return profit;
    }
}