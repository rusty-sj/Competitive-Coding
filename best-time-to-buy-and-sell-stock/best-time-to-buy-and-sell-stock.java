class Solution {
    public int maxProfit(int[] prices) {
        // TC: O(n)
        // SC: O(1)
        int minPrice = Integer.MAX_VALUE, maxProf = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {     // Buy stock if price is min
                minPrice = prices[i];
            } else {                        // Sell stock if we can obtain high profit
                if (prices[i] - minPrice> maxProf)
                    maxProf = prices[i] - minPrice;
            }
        }
        return maxProf > 0 ? maxProf : 0;
    }
}
