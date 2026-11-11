class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        if(n == 1)  return nums[0];  
        if(nums[0] != nums[1])  return nums[0];
        if(nums[n-1] != nums[n-2])  return nums[n-1];

        // for(int i=0; i<n; i += 2){
        //     // System.out.println(nums[i]);
        //     if(nums[i] != n-1 && nums[i] != nums[i+1]){
        //         return nums[i];
        //     }
        // }
        // return -1;
        
        int l = 1;
        int r = nums.length -1;

        while(l <= r){
            int mid = l+(r - l)/2;
            //base condition
            if(nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid])
                return nums[mid];

            //decide which region the number lies
            if((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])){ //even region (left side)
                l = mid + 1;
            }
            else{ //odd region (right side)
                r = mid - 1;
            }
        }
        return -1;
    }
}