class Solution {
    public int findTargetSumWays(int[] nums, int diff) {
        //tabulation
        int n = nums.length;
        int totalSum = 0;
        for(int a: nums){
            totalSum += a;
        }
        
        int rem = totalSum - diff;
        
        if(rem < 0 || rem % 2 != 0) 
            return 0;
            
        int target = rem/2;
        
        int[][] dp = new int[n][totalSum+1];
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }
        
        if(nums[0] != 0 && nums[0] <= totalSum){
            dp[0][nums[0]] = 1;
        }
        
        for(int i = 1; i < n; i++){
            for(int sum = 0; sum <= target; sum++){
                int notpick = dp[i-1][sum];
                int pick = 0;
                if(nums[i] <= sum){
                    pick = dp[i-1][sum-nums[i]];
                }
                dp[i][sum] = (notpick + pick);
            }
        }
        return dp[n-1][target];
    }
}