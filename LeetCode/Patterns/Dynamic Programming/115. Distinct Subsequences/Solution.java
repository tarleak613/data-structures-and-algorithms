class Solution {
    private int fun(String s, String t, int i, int j){
        //base case
        if(j < 0){
            return 1;
        }
        if(i < 0){
            return 0;
        }
        //reccurence relation
        if(s.charAt(i) == t.charAt(j)){
            return fun(s, t, i-1, j-1) + fun(s, t, i-1, j);
        }else{
            return fun(s, t, i-1, j);
        }
    }
    private int memo(String s, String t, int[][] dp, int i, int j){
        //base case
        if(j < 0){
            return 1;
        }
        if(i < 0){
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];
        //reccurence relation
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = memo(s, t, dp, i-1, j-1) + memo(s, t, dp, i-1, j);
        }else{
            dp[i][j] = memo(s, t, dp, i-1, j);
        }
        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        //recursion
        // return fun(s, t, n-1, m-1);

        //memoization
        // int[][] dp = new int[n+1][m+1];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return memo(s, t, dp, n-1, m-1);

        //tabulation
        int[][] dp = new int[n+1][m+1];

        //base case
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        //loops
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                //reccurence relation
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}