class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i <= high ; i++){
            if(check(i) == true) count++;  
        }
        return count;
    }
    public boolean check(int i){
        String s = String.valueOf(i);
        int len = String.valueOf(i).length();
        if(len % 2 != 0) return false;  //odd no. of digits

        int first = 0;
        int second = 0;
        for(int j = 0; j < len/2; j++) first += s.charAt(j) - '0';
        for(int j = len/2; j < len; j++) second += s.charAt(j) - '0';
        return first == second;
    }
}