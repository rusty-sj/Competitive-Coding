class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            while (i < prices.length - 1 && prices[i] > prices[i + 1])
                i++;
            profit -= prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1])
                i++;
            profit += prices[i];
        }
        return profit;
    }
}
