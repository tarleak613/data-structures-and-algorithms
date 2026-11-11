class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && childIndex < g.length) {

            if (g[childIndex] <= s[cookieIndex]) { childIndex++; }
            cookieIndex++;
        }    

        return childIndex; 
    }
}