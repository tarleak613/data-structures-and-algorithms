class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int n: nums){
            sum += n;
        }

        int n = nums.length;
        int sumOfAll = n * (n+1)/2;
        return sumOfAll - sum;
    }
}