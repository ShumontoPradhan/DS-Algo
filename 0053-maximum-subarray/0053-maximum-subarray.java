class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int maxSoFar = nums[0];
        for(int i = 1; i < n; i++){
            maxSoFar = Math.max(nums[i] , maxSoFar + nums[i]);
            maxSum = Math.max(maxSum, maxSoFar);
        }
        return maxSum;
    }
}

//fails when all numbers are negative

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxSum = nums[0];
//         int currSum = 0;
//         for(int i = 0; i < nums.length; i++){
//             if(currSum < 0){  //if curr sum is negative then reset it
//                 currSum = 0;
//             }
//             currSum += nums[i];  //start from current index again 
//             maxSum = Math.max(maxSum, currSum);
//         }
//         return maxSum;
//     }
// }