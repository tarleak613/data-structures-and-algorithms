class Solution {
    public int[][] merge(int[][] intervals) {
        // Arrays.sort(intervals, (a, b) -> Integer.Compare(a[0], b[0]));

        //sort by start and if same then end
        Arrays.sort(intervals, (a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            if(cmp != 0) return cmp;
            return Integer.compare(a[1], b[1]);
        });
        
        //merge using a list
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for(int i = 1; i < intervals.length; i++){
            int[] next = intervals[i];

            if(next[0] <= current[1]){
                current[1] = Math.max(current[1], next[1]);
            }else{
                current = next;
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}