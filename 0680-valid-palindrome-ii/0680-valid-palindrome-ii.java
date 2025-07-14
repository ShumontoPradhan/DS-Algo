class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        if(n == 1 || n == 2) return true;
        int count = 0;
        int i = 0;
        int j = n-1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                if(i+1 != j && (s.charAt(i+1) == s.charAt(j))){
                    count++;
                    if(count == 2) return false;
                    i++;
                }else if(j-1 != i && (s.charAt(j-1) == s.charAt(i))){
                    count++;
                    if(count == 2) return false;
                    j--;
                }else{
                    count++;
                    if(count == 2) return false;
                    i++;
                }
            }
        }
        return true;
    }
}