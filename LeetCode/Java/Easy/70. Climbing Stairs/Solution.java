class Solution {
    public int climbStairs(int n) {
        // //recursion
        // if(n == 1) return 1;
        // if(n == 2) return 2;

        // return climbStairs(n-1) + climbStairs(n-2);

        // //memoization
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // dp[0] = 0;
        // dp[1] = 1; 
        // dp[2] = 2;
        // return memoization(dp, n);

        //tabulation
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1; 
        dp[2] = 2;
        for(int i =3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    private int memoization(int[] dp, int n){
        //if calculated then skip
        if(dp[n] != -1) return dp[n];

        //else calculate
        return dp[n] = memoization(dp, n-1) + memoization(dp, n - 2);
    }
}