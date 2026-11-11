class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0,count = 0;
        for(int n: nums){
            if(n != 1){
                count = 0;
            }else
                count++;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}