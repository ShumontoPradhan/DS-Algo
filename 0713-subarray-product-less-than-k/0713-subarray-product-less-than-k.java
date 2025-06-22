class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if(k <= 1) return 0;
        int n = arr.length;
        int ans = 0;
        int i = 0;
        long product = 1;
        for(int j = 0; j < n; j++){
            product *= arr[j];
            while(product >= k && i <= j){
                product /= arr[i];
                i++;
            }
            ans += (j-i+1);
        }
        return ans;
    }
}