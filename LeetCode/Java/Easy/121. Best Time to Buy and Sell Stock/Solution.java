class Solution {
    public int maxProfit(int[] prices) {
        int small = Integer.MAX_VALUE;
        int profit = 0, maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            if(small > prices[i]) small = prices[i];
            else profit = prices[i] - small;
            maxProfit = Math.max(maxProfit, profit);
        } 
        return maxProfit;
    }
}