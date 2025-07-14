class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[52];
        boolean flag = false;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                freq[ch - 'A']++;
            }else{
                freq[ch - 'a' + 26]++;
            }
        }
        int count = 0;
        for(int i = 0; i < 52; i++){
            if(freq[i]%2 == 0) count += freq[i];
            else {
               count += freq[i] - 1;
               flag = true;
            }
        }
        return flag == true ? count+1 : count;
    }
}