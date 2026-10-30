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
            profit =  Math.max(prices[i] - fee + fun(prices, i+1, 1, fee), fun(prices, i+1, 0, fee));
        }
        return profit;

    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        // return fun(prices, 0, 1, fee);

        //tabulation
        int[][] dp = new int[n+1][2];

        //base case
        //loops
        for(int i = n-1; i >=0; i--){
            for(int buy = 0; buy <=1; buy++){
                if(buy == 1){ // buy stocks
                    dp[i][buy] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                }else{ // sell stocks
                    dp[i][buy] =  Math.max(prices[i] - fee + dp[i+1][1], dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}