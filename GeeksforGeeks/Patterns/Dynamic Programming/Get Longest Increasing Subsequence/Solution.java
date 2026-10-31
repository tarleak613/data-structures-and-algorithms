class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n = arr.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int[] backTrack = new int[n];
        
        //tabulation
        int maxi = 1;
        int lastIndex = 0;
        for(int i = 0; i < n; i++){
            backTrack[i] = i;
            for(int prev = 0; prev < i; prev++){
                if(arr[prev] < arr[i] && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    backTrack[i] = prev;
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
                lastIndex = i;
            }
        }
        
        // Backtrack to construct LIS
       ArrayList<Integer> ans = new ArrayList<>();

       while (backTrack[lastIndex] != lastIndex) {
           ans.add(arr[lastIndex]);
           lastIndex = backTrack[lastIndex];
       }

       ans.add(arr[lastIndex]);

       // Reverse to get increasing order
       Collections.reverse(ans);

       return ans;    
    }
}
