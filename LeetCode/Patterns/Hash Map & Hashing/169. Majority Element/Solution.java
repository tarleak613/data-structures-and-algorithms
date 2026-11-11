class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, element = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(count == 0 && nums[i] != element){
                element = nums[i];
            }

            if(nums[i] == element){
                count++;
            }else{
                count--;
            }
        }
        return element;
    }
}