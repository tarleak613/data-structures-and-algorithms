class Solution {
    private int helper(int[] nums, int i, int end){
        //base case
        if(i > end) return 0;

        //calculation
        int pick = nums[i] + helper(nums, i + 2, end);
        int notPick = helper(nums, i + 1, end);
        return Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        //recursion
        int n = nums.length;
        if(n == 1) return nums[0];
        
        int case1 = helper(nums, 0, n-2);
        int case2 = helper(nums, 1, n-1);

        return Math.max(case1, case2);
    }
}