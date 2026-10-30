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

        // return fun(prices, 0, 1);

        //tabulation
        // int[][] dp = new int[n+2][2];

        // //base case
        // //loops
        // for(int i = n-1; i >=0; i--){
        //     for(int buy = 0; buy <=1; buy++){
        //         if(buy == 1){ // buy stocks
        //             dp[i][buy] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
        //         }else{ // sell stocks
        //             dp[i][buy] =  Math.max(prices[i]+ dp[i+2][1], dp[i+1][0]);
        //         }
        //     }
        // }
        // return dp[0][1];

        //space optimization
        int[] next1 = new int[2];
        int[] next2 = new int[2];

        //base case
        //loops
        for(int i = n-1; i >=0; i--){
            int[] cur = new int[2];
            for(int buy = 0; buy <=1; buy++){
                if(buy == 1){ // buy stocks
                    cur[buy] = Math.max(-prices[i] + next1[0], next1[1]);
                }else{ // sell stocks
                    cur[buy] =  Math.max(prices[i] + next2[1], next1[0]);
                }
            }
            next2 = next1;
            next1 = cur;
        }
        return next1[1];
    }
}