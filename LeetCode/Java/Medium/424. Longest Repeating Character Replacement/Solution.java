class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0; 
        int maxFreq = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int r = 0; r < s.length(); r++){
            char key = s.charAt(r);
            map.put(key, map.getOrDefault(key, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(key));

            while((r - l + 1) - maxFreq > k){
                char c = s.charAt(l);
                map.put(c, map.get(c) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
