class Solution {
    public int singleNumber(int[] nums) {
        // logic : requires knowledge on bitwise operation
        /**  [1,1,2]   1 xor 1 xor 2 = 0 xor 2 = 2
             [1,2,1,2,4] 1 xor 2 xor 1 xor 2 xor 4 
                = 0 xor 4 = 4*/
        if(nums.length == 0)    return 0;
        int sNumber = nums[0];
        for(int i=1; i<nums.length; i++){
            sNumber = sNumber ^ nums[i];
        }
        return sNumber;
    }
}