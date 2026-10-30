class Solution {
    private int fun(int[] prices, int i, int buy){
        //base case
        if(i >= prices.length)
            return 0;

        //recurrence relation
        int profit = 0;
        if(buy == 1){ // buy stocks
            profit = Math.max(-prices[i] + fun(prices, i+1, 0), fun(prices, i+1, 1));
        }else{ // sell stocks
            profit =  Math.max(prices[i] + fun(prices, i+2, 1), fun(prices, i+1, 0));
        }
        return profit;

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        return fun(prices, 0, 1);
    }
}