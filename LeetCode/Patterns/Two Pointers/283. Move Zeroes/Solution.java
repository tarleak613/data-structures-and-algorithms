class Solution {
    public void moveZeroes(int[] nums) {
        // int j = -1;
        // //place the pointer j:
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         j = i;
        //         break;
        //     }
        // }
        // if (j == -1) return;
        // for (int i = j + 1; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         //swap a[i] & a[j]:
        //         int tmp = nums[i];
        //         nums[i] = nums[j];
        //         nums[j] = tmp;
        //         j++;
        //     }
        // }

        //simple logic
        int zeroIndex=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[zeroIndex] = nums[i];
                zeroIndex++;
            }
        }
        while(zeroIndex < nums.length){
            nums[zeroIndex] = 0;
            zeroIndex++;
        }
    }
}