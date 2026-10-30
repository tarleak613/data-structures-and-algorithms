class Solution {
    private int fun(int[] prices, int i, int buy){
        //base case
        if(i == prices.length){
            return 0;
        }
        //reccurence relation
        int profit = 0;
        if(buy == 1){
            int take = -prices[i] + fun(prices, i+1, 0); // buying
            int notTake = 0 + fun(prices, i+1, 1); // notbuying
            profit = Math.max(take, notTake);
        }else{
            int take = prices[i] + fun(prices, i+1, 1); //selling so now you can buy
            int notTake = 0 + fun(prices, i+1, 0); //  not gonna sell
            profit = Math.max(take, notTake);
        }
        return profit;
    }
    private int memo(int[] prices, int[][] dp, int i, int buy){
        //base case
        if(i == prices.length){
            return 0;
        }

        if(dp[i][buy] != -1) return dp[i][buy];
        //reccurence relation
        int profit = 0;
        if(buy == 1){
            int take = -prices[i] + memo(prices, dp, i+1, 0); // buying
            int notTake = 0 + memo(prices, dp, i+1, 1); // notbuying
            profit = Math.max(take, notTake);
        }else{
            int take = prices[i] + memo(prices, dp, i+1, 1); //selling so now you can buy
            int notTake = 0 + memo(prices, dp, i+1, 0); //  not gonna sell
            profit = Math.max(take, notTake);
        }
        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // return fun(prices, 0, 1);

        //memoization
        // int[][] dp = new int[n][2];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return memo(prices, dp, 0, 1);

        //tabulation
        // int[][] dp = new int[n+1][2];

        // //base case
        // dp[n][0] = 0;
        // dp[n][1] = 0;
        // //loops
        // for(int i = n-1; i >= 0; i--){
        //     for(int buy = 0; buy <= 1; buy++){
        //         //reccurence relation
        //         if(buy == 1){
        //             int take = -prices[i] + dp[i+1][0]; // buying
        //             int notTake = 0 + dp[i+1][1]; // notbuying
        //             dp[i][buy] = Math.max(take, notTake);
        //         }else{
        //             int take = prices[i] + dp[i+1][1]; //selling so now you can buy
        //             int notTake = 0 + dp[i+1][0]; //  not gonna sell
        //             dp[i][buy] = Math.max(take, notTake);
        //         }
        //     }
        // }
        // return dp[0][1];   

            //space optmization
            int buy = 0, sell = 0;
            int profit = 0;

            //base case
            int curBuy = 0;
            int nextBuy = 0;
            int curSell = 0;
            int nextSell = 0;
            //loops
            for(int i = n-1; i >= 0; i--){
                curBuy = Math.max(-prices[i] + nextSell, nextBuy);
                curSell = Math.max(prices[i] + nextBuy, nextSell);
                
                nextBuy = curBuy;
                nextSell = curSell;
            }
            return nextBuy;  
    }
}