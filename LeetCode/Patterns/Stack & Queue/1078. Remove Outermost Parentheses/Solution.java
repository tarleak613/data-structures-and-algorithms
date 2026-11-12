class Solution {
    public String removeOuterParentheses(String s) {

        String ans ="";
        int level = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                if(level > 0)   ans += c;
                level++;
            }else if(c == ')'){
                level--;
                if(level > 0) ans += c;
            }
        }
        return ans;
    }
}