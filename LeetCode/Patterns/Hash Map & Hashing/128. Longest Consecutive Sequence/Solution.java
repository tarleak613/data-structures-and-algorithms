class Solution {
    public int longestConsecutive(int[] nums) {
        // naive approach, sort the array and do it
        /* to optimize use extra space 
                put all the elements in the set
                find if the number is the start of a sequence
                how?? if num-1 exists then not the start
                else yes
        */
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++)    set.add(nums[i]);
        
        int longestSequence = 0;
        for(int i: set){
            if(!set.contains(i - 1)){
                int count = 1;
                int x = i;
                while(set.contains(x + 1)){
                    count++;
                    x++;
                }
                longestSequence = Math.max(count, longestSequence);
            }
        }
        return longestSequence;
    }
}