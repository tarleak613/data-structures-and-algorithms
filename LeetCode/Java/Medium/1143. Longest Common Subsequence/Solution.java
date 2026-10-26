class Solution {
    private int fun(String text1, String text2, int i1, int i2){
        //base case
        if(i1 < 0 || i2 < 0)
            return 0;

        //recurrence relation
        if(text1.charAt(i1) == text2.charAt(i2)){
            return 1 + fun(text1, text2, i1 - 1, i2 - 1);
        }
        return Math.max(fun(text1, text2, i1-1, i2), fun(text1, text2, i1, i2-1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();

        return fun(text1, text2, n1-1, n2-1);
    }
}