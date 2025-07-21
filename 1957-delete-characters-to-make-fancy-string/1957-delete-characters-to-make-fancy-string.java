class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(i > 1 && s.charAt(i-1) == ch && s.charAt(i-2) == ch){
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}