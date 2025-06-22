class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int total = nums[0];
        int MinSum = nums[0];
        int MinSoFar = nums[0];
        int MaxSum = nums[0];
        int MaxSoFar = nums[0];
        for(int  i = 1; i < n; i++){
            MinSoFar = Math.min(nums[i], MinSoFar + nums[i]);
            MinSum = Math.min(MinSum , MinSoFar);
            
            MaxSoFar = Math.max(nums[i], MaxSoFar + nums[i]);
            MaxSum = Math.max(MaxSum , MaxSoFar);
            
            total += nums[i];
        }
        if(MaxSum < 0) return MaxSum;
        int circularSum = Math.max(total - MinSum, MaxSum);
        return circularSum;
    }
}