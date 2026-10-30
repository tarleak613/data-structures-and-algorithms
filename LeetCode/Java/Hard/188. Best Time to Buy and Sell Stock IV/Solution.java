class Solution {
    private int fun(int[] prices, int i, int buy, int cap){
        //base case
        if(cap == 0 || i == prices.length)
            return 0;

        //recurrence relation
        int profit = 0;
        if(buy == 1){ // buy stocks
            profit = Math.max(-prices[i] + fun(prices, i+1, 0, cap), fun(prices, i+1, 1, cap));
        }else{ // sell stocks
            profit = Math.max(prices[i] + fun(prices, i+1, 1, cap-1), fun(prices, i+1, 0, cap));
        }
        return profit;

    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // return fun(prices, 0, 1, k);

        //tabulation
        int[][][] dp = new int[n+1][2][k+1];

        //base case

        //loops
        for(int i = n-1; i >= 0; i--){
            for(int buy = 0; buy <=1; buy++){
                for(int cap = 1; cap <= k; cap++){
                    if(buy == 1){ // buy stocks
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap], dp[i+1][1][cap]);
                    }else{ // sell stocks
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1], dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    };
}