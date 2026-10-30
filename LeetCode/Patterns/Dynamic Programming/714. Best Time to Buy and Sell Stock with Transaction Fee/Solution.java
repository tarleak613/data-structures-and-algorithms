class Solution {
    private int fun(int[] prices, int i, int buy, int fee){
        //base case
        if(i == prices.length)
            return 0;

        //recurrence relation
        int profit = 0;
        if(buy == 1){ // buy stocks
            profit = Math.max(-prices[i] + fun(prices, i+1, 0, fee), fun(prices, i+1, 1, fee));
        }else{ // sell stocks
            profit =  Math.max( -fee + prices[i] + fun(prices, i+1, 1, fee), fun(prices, i+1, 0, fee));
        }
        return profit;

    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        return fun(prices, 0, 1, fee);
    }
}