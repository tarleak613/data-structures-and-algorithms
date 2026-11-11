class Solution {
    public int[] rearrangeArray(int[] nums) {
        /*brute force:
            take two arrays of nums.length/2 size
            find the postive elements, put in the arr1
            find the negative elements, put in the arr2
            put the postive and negative number one after the another 

            tc: n+n+n= 3n = O(n)
            sc: n/2+n/2 = 2n = o(n)
            */
        /*optimized solution:
            traverse through the array
            check nums[i+1] is opposite of the sign as that of nums[i]
            if not then swap nums[i+1], nums[i+2]
            else continue 
            
            tc: o(n)
            sc: o(1)
        */
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] > 0){
        //         if(i < nums.length-1 && nums[i+1] > 0)   swap(nums[i+1],nums[i+2]);
        //     }
        //     else{
        //         if(i < nums.length-1 && nums[i+1] < 0)   swap(nums[i+1],nums[i+2]);
        //     }
        // }
        int[] arr = new int[nums.length]; 
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0) arr[count++] = nums[i];
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0) arr[count++] = nums[i];
        }
        
        int p1 = 0;
        int p2 = nums.length/2;
        for(int i=0; i<nums.length; i++){
            if(i % 2 == 0 && i != 1)    nums[i] = arr[p1++];
            else nums[i] = arr[p2++];
        }
        return nums;
    }
}