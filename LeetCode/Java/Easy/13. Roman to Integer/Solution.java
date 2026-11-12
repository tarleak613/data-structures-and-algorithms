class Solution {
    private int returnRomanValue(char ch){
        if(ch == 'I')   return 1;
        if(ch == 'V')   return 5;
        if(ch == 'X')   return 10;
        if(ch == 'L')   return 50;
        if(ch == 'C')   return 100;
        if(ch == 'D')   return 500;
        if(ch == 'M')   return 1000;
        return -1;
    }
    public int romanToInt(String s) {
        int n = s.length();
        if(n == 0)  return 0;
        if(n == 1)  return returnRomanValue(s.charAt(0));

        int sum = 0;
        for(int i = 0; i < n; i++){ // MCMXCIV
            char firstCh = s.charAt(i);
            if(i+1 != n){
                char secondCh = s.charAt(i+1);
                if(returnRomanValue(secondCh) > returnRomanValue(firstCh)){
                    sum += returnRomanValue(secondCh) - returnRomanValue(firstCh);
                    i++;
                }
                else    sum += returnRomanValue(firstCh);
            }
            else    sum += returnRomanValue(firstCh);
        }
        return sum;
    }
}