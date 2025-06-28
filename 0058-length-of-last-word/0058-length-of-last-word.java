class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int count = 0;
        boolean first = true;
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == ' ' && first == true) continue;
            if(s.charAt(i) == ' ' && first == false) break;
            else{
                count++;
                first = false;
            }
        }
        return count;
    }
}