//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// Given a string s of '(' , ')' and lowercase English characters.

//Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder(s);
        Stack <Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else if (s.charAt(i)==')'){
                if(st.isEmpty())
                 sb.setCharAt(i,'*');
                else
                 st.pop();
            }
        }
        while(!st.isEmpty()){
            sb.setCharAt(st.pop(),'*');
        }
        String ans=sb.toString();
        return ans.replace("*","");
    }
}
