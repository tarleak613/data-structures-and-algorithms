class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];

        int maxi = 1;
        int lastIndex = 0;
        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
                lastIndex = i;
            }
        }
        // Backtrack to construct LIS
        ArrayList<Integer> ans = new ArrayList<>();

        while (hash[lastIndex] != lastIndex) {
           ans.add(nums[lastIndex]);
           lastIndex = hash[lastIndex];
        }

        ans.add(nums[lastIndex]);

        // Reverse to get increasing order
        Collections.reverse(ans);
        return ans;    
    }
}