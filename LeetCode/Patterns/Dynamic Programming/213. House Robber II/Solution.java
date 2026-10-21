class Solution {
    private int helper(int[] nums, int i, int end){
        //base case
        if(i > end) return 0;

        //calculation
        int pick = nums[i] + helper(nums, i + 2, end);
        int notPick = helper(nums, i + 1, end);
        return Math.max(pick, notPick);
    }
    private int memo(int[] nums, int[] dp, int i, int end){
        //base case
        if(i > end) return 0;

        //check for dp already solved
        if(dp[i] != -1) return dp[i];

        //calculation
        int pick = nums[i] + memo(nums, dp, i + 2, end);
        int notPick = memo(nums, dp, i + 1, end);
        return dp[i] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        //recursion
        // int n = nums.length;
        // if(n == 1) return nums[0];
        
        // int case1 = helper(nums, 0, n-2);
        // int case2 = helper(nums, 1, n-1);

        // return Math.max(case1, case2);

        //memoization
        int n = nums.length;

        if(n == 1) return nums[0];

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int case1 = memo(nums, dp, 0, n - 2);

        // Reset DP before solving Case 2
        Arrays.fill(dp, -1);

        int case2 = memo(nums, dp, 1, n - 1);

        return Math.max(case1, case2);
    }
}