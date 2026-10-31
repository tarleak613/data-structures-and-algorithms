class Solution {
    private int fun(int[] nums, int i, int prevI){
        //base case
        if(i == nums.length)
            return 0;

        //reccurence relation
        int pick = 0, notpick = 0;
        if(prevI == -1 || nums[i] > nums[prevI]){
            pick = 1 + fun(nums, i+1, i); 
        }
        notpick = fun(nums, i+1, prevI);
        return Math.max(pick, notpick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        return fun(nums, 0, -1);
    }
}