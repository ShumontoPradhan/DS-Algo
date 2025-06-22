class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int i  = 0;
        int extra = n%k;
        // String[] res = new String[(int)Math.ceil(n/k)];
        String[] res = new String[(n+k-1)/k];
        int j = 0;
        while(i < n){
            if(i+k <= n){
                res[j++] = s.substring(i, i+k);
                i = i+k;
            }else{
                res[j++] = s.substring(i, n) + repeat(fill, k-extra);
                i += k;
            }
        }
        return res;
    }
    public String repeat(char fill, int times){
        String x = "";
        for(int i = 0; i < times; i++){
            x += fill;
        }
        return x;
    }
}