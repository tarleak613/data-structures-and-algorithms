class Solution {
    private int fun(String text1, String text2, int i1, int i2){
        //base case
        if(i1 < 0 || i2 < 0)
            return 0;

        //recurrence relation
        if(text1.charAt(i1) == text2.charAt(i2)){
            return 1 + fun(text1, text2, i1 - 1, i2 - 1);
        }
        return Math.max(fun(text1, text2, i1-1, i2), fun(text1, text2, i1, i2-1));
    }
    private int memo(String text1, String text2, int[][] dp, int i1, int i2){
        //base case
        if(i1 < 0 || i2 < 0)
            return 0;

        if(dp[i1][i2] != -1) return dp[i1][i2];
        //recurrence relation
        if(text1.charAt(i1) == text2.charAt(i2)){
            dp[i1][i2] = 1 + memo(text1, text2, dp, i1 - 1, i2 - 1);
        }
        else dp[i1][i2] =Math.max(memo(text1, text2, dp, i1-1, i2), memo(text1, text2, dp, i1, i2-1));

        return dp[i1][i2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();

        //recursion
        // return fun(text1, text2, n1-1, n2-1);

        //memoization
        // int[][] dp = new int[n1][n2];
        // for(int i = 0; i < n1; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(text1, text2, dp, n1-1, n2-1);

        //tabulation
        int[][] dp = new int[n1+1][n2+1];

        //base case
        // for(int i = 0; i < n1-1; i++){
        //     dp[i][0] = 0;
        // }
        // for(int i = 0; i < n2-1; i++){
        //     dp[0][i] = 0;
        // }
        //loops
        for(int i1 = 1; i1 <= n1; i1++){
            for(int i2 = 1; i2 <= n2; i2++){
                //reccurence realtion
                if(text1.charAt(i1-1) == text2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                }
                else{
                    dp[i1][i2] =Math.max(dp[i1-1][i2], dp[i1][i2-1]);
                }   
            }
        }
        return dp[n1][n2];
    }
}