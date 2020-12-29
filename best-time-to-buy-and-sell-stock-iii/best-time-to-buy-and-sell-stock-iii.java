class Solution {
    public int maxProfit(int[] prices) {
        int minCost1 = Integer.MAX_VALUE, minCost2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;
        for (int i = 0; i < prices.length; i++) {
            
            // Trasaction 1: buy only if price is less than min cost till now
            if (prices[i] < minCost1) 
                minCost1 = prices[i];
            else {
            // Trasaction 1: sell if profit by selling prices[i] is more than before
                if ((prices[i] - minCost1) > profit1) 
                    profit1 = prices[i] - minCost1;
            }
            // Trasaction 2: buy only if price is less than min cost till now
            if (prices[i] - profit1 < minCost2) 
                minCost2 = prices[i] - profit1;
            else {
            // Trasaction 2: sell if profit by selling prices[i] is more than before
                if (prices[i] - minCost2 > profit2) 
                    profit2 = prices[i] - minCost2;
            }
            
        }
        return profit2;
    }
}
