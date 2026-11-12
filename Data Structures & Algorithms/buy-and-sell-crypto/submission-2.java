class Solution {
    public int maxProfit(int[] prices) {
         int left = 0;
        int profit = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] > prices[left]) {
                profit = prices[i] - prices[left];
                if (profit > maxProfit) maxProfit = profit;
            }
            else if (prices[i] <= prices[left]) {
                left = i;
            }
        }
        
        return maxProfit;
    }
}
