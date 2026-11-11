class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < numRows; i++){

            List<Integer> temp = new ArrayList<>(i+1);
            int val = 1;

            for(int j = 0; j <= i; j++){
                temp.add(val);
                if(j < i){
                    val = val * (i-j)/(j+1);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}