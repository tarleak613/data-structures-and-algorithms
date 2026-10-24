class Solution {
    private boolean memo(int[] nums,int[][] dp, int i, int target){
        //base case
        if(target == 0){
            return true;
        }
        if(i == 0) return nums[0] == target;

        if(dp[i][target] != -1){
            return dp[i][target] == 1;
        }
        boolean notpick = memo(nums, dp, i-1, target);
        boolean pick = false;
        if(nums[i] <= target){
            pick = memo(nums, dp, i-1, target - nums[i]);
        }

        dp[i][target] = pick || notpick ? 1 : 0;
        return dp[i][target] == 1;
    }
    public int minDifference(int arr[]) {
        // code here
        int n = arr.length;
        int sum = 0;
        for(int a: arr){
            sum += a;
        }

          //recursion
          // fun(nums, n-1, sum);

        //memoization
        // int ans = Integer.MAX_VALUE;
        // int[][] dp = new int[n][sum + 1];
        // for(int i=0; i < n; i++){
        //       Arrays.fill(dp[i], -1);
        // }

        // for(int s = 0; s <= sum; s++){
        //     memo(arr, dp, n-1, s);
        // }

        //   for(int s1 = 0; s1 <= sum/2; s1++){
        //       if(memo(arr, dp, n-1, s1)){
        //           int s2 = sum - s1;
        //           ans = Math.min(ans, Math.abs(s2-s1));
        //       }
        //   }
        // return ans;
        
        //tabulation
        boolean[][] dp = new boolean[n][sum+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        
        if(arr[0] <= sum){
            dp[0][arr[0]] = true;
    
        }
        
        for(int i = 1 ; i < n ; i ++){
            for(int j = 1; j <= sum; j++){
                boolean notpick = dp[i-1][j];
                boolean pick = false;
                if(arr[i] <= j){
                    pick = dp[i-1][j - arr[i]];
                }
                dp[i][j] = pick || notpick;
            }
        }
        int ans = Integer.MAX_VALUE;

        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (dp[n - 1][s1]) {
                int s2 = sum - s1;
                ans = Math.min(ans, Math.abs(s2 - s1));
            }
        }

        return ans;
    }
}
