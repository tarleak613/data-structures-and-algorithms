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
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int a : nums){
            sum += a;
        }
        if(sum % 2 != 0) return false;
        
        //recursion
        return fun(nums, n-1, sum/2);
    }
}