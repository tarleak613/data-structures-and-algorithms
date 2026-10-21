class Solution {
    private int helper(int[] nums, int i){
        if(i == 0) return nums[0];
        else if(i == 1) return Math.max(nums[0], nums[1]);

        int pick = helper(nums, i - 2);
        int notPick = helper(nums, i - 1);

        return Math.max(pick, notPick);
    }

    private int memo(int[] nums, int[] dp, int i){
        if(i == 0) return nums[0];
        if(i < 0) return 0;

        //check if answer exists in dp array
        if(dp[i] != -1) return dp[i];

        int pick = nums[i] + memo(nums, dp, i-2);
        int notpick = memo(nums, dp, i-1);
        return dp[i] = Math.max(pick, notpick);
    }
    public int rob(int[] nums) {
        //recursion
        // return helper(nums, nums.length-1);

        //memoization - use storage with recursion
        // int n = nums.length;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return memo(nums, dp, n-1);

        //tabulation
        // int n = nums.length;
        // int[] dp = new int[n+1];

        // dp[0] = nums[0];
        // for(int i = 1; i < n; i++)
        // {
        //     int pick = nums[i];
        //     if(i > 1){
        //         pick += dp[i-2];
        //     }
        //     int notPick = dp[i-1];
        //     dp[i] = Math.max(pick, notPick);
        // }
        // return dp[n-1];

        //space optmization
        int n = nums.length;
        int prev1 = nums[0], prev2 = 0;

        for(int i = 1; i < n; i++){
            int pick = nums[i];
            if(i > 1){
                pick += prev2;
            }
            int notPick = prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}