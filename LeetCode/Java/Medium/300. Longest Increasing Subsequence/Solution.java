class Solution {
    private int fun(int[] nums, int i, int prevI){
        //base case
        if(i == nums.length)
            return 0;

        //reccurence relation
        int notpick = fun(nums, i+1, prevI);
        int pick = 0;
        if(prevI == -1 || nums[i] > nums[prevI]){
            pick = 1 + fun(nums, i+1, i); 
        }
        return Math.max(pick, notpick);
    }
    private int memo(int[] nums, int[][] dp, int i, int prevI){
        //base case
        if(i == nums.length)
            return 0;

        if(dp[i][prevI + 1] != -1) return dp[i][prevI + 1];
        //reccurence relation
        int notpick = memo(nums, dp, i+1, prevI);
        int pick = 0;
        if(prevI == -1 || nums[i] > nums[prevI]){
            pick = 1 + memo(nums, dp, i+1, i); 
        }
        return dp[i][prevI+1] = Math.max(pick, notpick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // return fun(nums, 0, -1);

        //memoization - look at the changing paramters
        // int[][] dp = new int[n][n+1];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return memo(nums, dp, 0, -1);

        //tabulation
        int[][] dp = new int[n+1][n+1];

        //base case
        for(int i = 0; i <=n; i++){
            dp[n][0] = 0;
        }
        //loops
        for(int i = n-1; i >=0; i--){
            for(int prevI = 0; prevI <= n; prevI++){
                //reccurence relation
                int notpick = dp[i+1][prevI];
                int pick = 0;
                if(prevI == 0 || nums[i] > nums[prevI-1]){
                    pick = 1 + dp[i+1][i+1]; 
                }
                dp[i][prevI] = Math.max(pick, notpick);
            }
        }
        return dp[0][0];
    }
}