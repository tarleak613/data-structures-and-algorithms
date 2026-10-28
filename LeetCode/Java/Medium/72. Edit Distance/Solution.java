class Solution {
    private int fun(String s, String t, int i, int j){
        //base case
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        //reccurence relation
        if(s.charAt(i) == t.charAt(j)){
            return 0 + fun(s, t, i-1, j-1);
        }else{
            int temp = Math.min(fun(s, t, i-1, j), fun(s, t, i, j-1));
            return 1 + Math.min(temp, fun(s, t, i-1, j-1));
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // return fun(word1, word2, n-1, m-1);

        //tabulation
        int[][] dp = new int[n+1][m+1];

        //base case
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j; // inserting j characters
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i; // deleting i characters
        }
        //loops
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int temp = Math.min(dp[i][j-1], dp[i-1][j]);
                    dp[i][j] = 1 + Math.min(temp, dp[i-1][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}