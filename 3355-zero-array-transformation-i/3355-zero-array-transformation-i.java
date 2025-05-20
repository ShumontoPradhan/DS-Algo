class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n];  //filled with 0's
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int x = 1;
            diff[l] += x;
            if(r+1 < n){
                diff[r+1] -= x;
            }
        }
        int[] cumulativeSum = new int[n];
        cumulativeSum[0] = diff[0];
        for(int i= 1; i < n; i++){
            cumulativeSum[i] = diff[i] + cumulativeSum[i-1];
        }
        for(int i = 0; i < n; i++){
            if(cumulativeSum[i] < nums[i]) return false;
        }
        return true;
    }
}
// //Brute force
// class Solution {
//     public boolean isZeroArray(int[] nums, int[][] queries) {
//         int n = nums.length;
//         for(int i = 0; i < queries.length; i++){
//             int l = queries[i][0];
//             int r = queries[i][1];
//             for(int j = l; j <= r; j++){
//                 if(nums[j] != 0){
//                     nums[j]--;
//                 }
//             }
//         }
//         for(int x : nums){
//             if(x != 0) return false;
//         }
//         return true;
//     }
// }