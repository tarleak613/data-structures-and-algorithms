class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();

        //tabulation
        int[][] dp = new int[n+1][n+1];

        //base case
        // for(int i = 0; i < n1-1; i++){
        //     dp[i][0] = 0;
        // }
        // for(int i = 0; i < n2-1; i++){
        //     dp[0][i] = 0;
        // }
        //loops
        for(int i1 = 1; i1 <= n; i1++){
            for(int i2 = 1; i2 <= n; i2++){
                //reccurence realtion
                if(s.charAt(i1-1) == s2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                }
                else{
                    dp[i1][i2] =Math.max(dp[i1-1][i2], dp[i1][i2-1]);
                }   
            }
        }
        return dp[n][n];
    }
}