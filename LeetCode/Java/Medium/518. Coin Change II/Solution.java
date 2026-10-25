class Solution {
    public int change(int amount, int[] coins) {
        //tabulation
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        //base case
        for(int i = 0; i <= amount; i++){
            if(i % coins[0] == 0){
                dp[0][i] = 1;
            }
            else dp[0][i] = 0;
        }
        //loops
        for(int i = 1; i < n; i++){
            for(int amt = 0; amt <= amount; amt++){
                //recurrence relation
                int notpick = dp[i-1][amt];
                int pick = 0;
                if(coins[i] <= amt){
                    pick = dp[i][amt - coins[i]];
                }
                dp[i][amt] = pick + notpick;
            }
        }
        return dp[n-1][amount]; 
    }
}