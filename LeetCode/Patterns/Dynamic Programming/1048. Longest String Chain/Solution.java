class Solution {
    private boolean checkPossible(String s1, String s2){
        //comparison??
        if(s1.length() + 1 != s2.length()) 
            return false;

        int p1=0, p2=0;
        while(p1 < s1.length() && p2 < s2.length()){
            if(s1.charAt(p1) == s2.charAt(p2)){
                p1++;
                p2++;
            }else{
                p2++;
            }
        }
        return p1 == s1.length();
        //return true/false
    }
    public int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 0;
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                //compare the strings somehow???
                if(checkPossible(words[prev], words[i]) && dp[i] < dp[prev] + 1){
                    dp[i] = dp[prev] + 1;
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}