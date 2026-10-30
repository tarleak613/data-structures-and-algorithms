class Solution {
    private int fun(int[]prices, int i, int buy, int cap){
        //base case
        if(cap == 0 || i == prices.length)
            return 0;

        //reccurence relation
        int profit = 0;
        if(buy == 1){ //buy stocks
            profit = Math.max(-prices[i] + fun(prices, i+1, 0, cap), fun(prices, i+1, 1, cap));
        }else{ //sell stocks
            profit = Math.max(prices[i] + fun(prices, i+1, 1, cap-1), fun(prices, i+1, 0, cap));
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        return fun(prices, 0, 1, 2);
    }
}