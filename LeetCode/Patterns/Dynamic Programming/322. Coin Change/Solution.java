class Solution {
    private int fun(int[] coins, int i, int amount){
        //base case
        if(i == 0){
            if(amount % coins[i] == 0){
                return amount/coins[i];
            }
            return (int) 1e9;
        }

        int notpick = fun(coins, i-1, amount);
        int pick = Integer.MAX_VALUE;
        if(coins[i] <= amount){
            pick = 1 + fun(coins, i, amount - coins[i]);
        }

        return Math.min(pick, notpick);
    }
    private int memo(int[] coins, int[][] dp, int i, int amount){
        //base case
        if(i == 0){
            if(amount % coins[i] == 0){
                return amount/coins[i];
            }
            return (int) 1e9;
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int notpick = memo(coins, dp, i-1, amount);
        int pick = Integer.MAX_VALUE;
        if(coins[i] <= amount){
            pick = 1 + memo(coins, dp, i, amount - coins[i]);
        }

        dp[i][amount] = Math.min(pick, notpick);
        return dp[i][amount];
    }
    public int coinChange(int[] coins, int amount) {

        //recursion
        // int n = coins.length;
        // int ans = fun(coins, n-1, amount);
        // return ans >= (int) 1e9 ? -1 : ans;

        //memoization
        // int n = coins.length;
        // int[][] dp = new int[n][amount+1];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // int ans = memo(coins, dp, n-1, amount);
        // return ans >= (int) 1e9 ? -1 : ans;

        //tabulation
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        //base case
        for(int i = 0; i <= amount; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i/coins[0];
            }else{
                dp[0][i] = (int) 1e9;
            }
        }
        //loops
        for(int i = 1; i < n; i++){
            for(int amt = 0; amt <= amount; amt++){
                //recurrence relation
                int notpick = dp[i-1][amt];
                int pick = Integer.MAX_VALUE;
                if(coins[i] <= amt){
                    pick = 1 + dp[i][amt - coins[i]];
                }
                dp[i][amt] = Math.min(pick, notpick);
            }
        }
        return dp[n-1][amount] >= (int) 1e9 ? -1 : dp[n-1][amount];
    }
}