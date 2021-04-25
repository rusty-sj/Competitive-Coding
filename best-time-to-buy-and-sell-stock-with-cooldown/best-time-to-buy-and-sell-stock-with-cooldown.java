class Solution {
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        
        int inHand = Integer.MIN_VALUE, sold = Integer.MIN_VALUE, noStock = 0;
        
        for (int price : prices) {
            int preSold = sold;
            sold = inHand + price;
            inHand = Math.max(inHand, noStock - price);
            noStock = Math.max(noStock, preSold);
        }

        return Math.max(noStock, sold);
    }
}