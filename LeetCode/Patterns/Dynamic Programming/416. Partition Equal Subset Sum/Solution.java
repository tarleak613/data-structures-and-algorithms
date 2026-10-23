class Solution {
    private boolean fun(int[] nums, int i, int target){
        //base case
        if(target == 0) return true;
        if(i == 0) return nums[0] == target; 

        //pick till 
        boolean notpick = fun(nums, i-1, target);
        boolean pick = false;
        if(nums[i] <= target){
            pick = fun(nums, i-1, target - nums[i]);
        }

        return pick || notpick;
    }
    private boolean memo(int[] nums,int[][] dp, int i, int target){
        //base case
        if(target == 0) return true;
        if(i == 0) return nums[0] == target; 

        //checking overlapping subproblems
        if(dp[i][target] != -1) return dp[i][target] == 1;

        //pick till 
        boolean notpick = memo(nums, dp, i-1, target);
        boolean pick = false;
        if(nums[i] <= target){
            pick = memo(nums, dp, i-1, target - nums[i]);
        }

        dp[i][target] = pick || notpick ? 1 : 0;
        return dp[i][target] == 1;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalsum = 0;
        for(int a : nums){
            totalsum += a;
        }
        if(totalsum % 2 != 0) return false;

        //recursion
        // return fun(nums, n-1, sum/2);

        //memoization
        // int target = sum/2;
        // int[][] dp = new int[n][target + 1];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(nums, dp, n-1, target);

        //tabulation
        int target = totalsum/2;
        boolean[][] dp = new boolean[n][target+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;

        for(int i = 1; i < n; i++){
            for(int sum = 1; sum <= target; sum++){
                boolean notpick = dp[i-1][sum];
                boolean pick = false;
                if(nums[i] <= sum){
                    pick = dp[i-1][target - nums[i]];
                }
                dp[i][sum] = pick || notpick;
            }
        }
        return dp[n-1][target];
    }
}