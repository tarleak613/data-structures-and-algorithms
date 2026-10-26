class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();

        //tabulation
        int[] prev = new int[n+1];
        int[] cur = new int[n+1];

        //base case
        // for(int i = 0; i < n1-1; i++){
        //     dp[i][0] = 0;
        // }
        // for(int i = 0; i < n2-1; i++){
        //     dp[0][i] = 0;
        // }
        //loops
        for(int i1 = 1; i1 <= n; i1++){
            cur[0] = 0;
            for(int i2 = 1; i2 <= n; i2++){
                //reccurence realtion
                if(s.charAt(i1-1) == s2.charAt(i2-1)){
                    cur[i2] = 1 + prev[i2 - 1];
                }
                else{
                    cur[i2] =Math.max(prev[i2], cur[i2-1]);
                }   
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[n];
    }
}