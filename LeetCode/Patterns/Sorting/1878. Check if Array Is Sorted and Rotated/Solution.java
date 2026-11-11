class Solution {
    public boolean check(int[] nums) {

        // logic 1
        //     1. sort the array Arr
        //     2. rotate nums for nums.length-1 times and check with the sorted Arr

        // logic 2 (pointer logic)
        //     1. sort the array Arr
        //     2. find the index of nums[0] in the Arr and start verify the elements henceforth
        // int[] arr = nums;
        // Arrays.sort(arr);

        // int s=0;
        // int l=0,r=0;
        // for(int i=0; i<nums.length; i++){
        //     if(nums[r] == arr[i]){
        //         l=i;
        //         break;
        //     }
        // }
        // int i=0;
        // while(i < nums.length){
        //     if(l == nums.length-1)  l=0;
        //     if(r == nums.length-1)  r=0;
        //     if(arr[l] == nums[r]){
        //         l++;
        //         r++;
        //     }
        //     else    return false;
        // }
        // return true;
        int len=nums.length;
        int count=0;

        if(nums[0]<nums[len-1]) count=1; // this means nums is not rotated
        for(int i=0; i<len-1; i++)
            {
                if(nums[i]>nums[i+1])
                    {
                        count++;
                        if(count>1)return false;  
                    }
            }
            return true;
        }
    }