class Solution {
    public int myAtoi(String s) {
        s = s.strip();  // Remove any whitspaces present
        if (s.isEmpty()) //if empty then return 0
            return 0;
        
        //if any signs present then store it and then remove
        int sign = s.charAt(0) == '-' ? -1 : 1; //step 1

        if(s.charAt(0) == '+' || s.charAt(0) == '-') //step 2
            s = s.substring(1);
        
        long ans = 0;

        for(char ch : s.toCharArray()){ //traverse through the strings in form of char array
            if(!Character.isDigit(ch)) //if not digit then break
                break;
            ans = ans * 10 + (ch - '0');

            //handle edge cases
            if(sign * ans <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if(sign * ans >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        return sign * (int)ans;
    }
}