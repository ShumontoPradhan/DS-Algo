class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        leftmax[0] = 0;
        rightmax[n-1] = 0;
        for(int i  = 1; i < n; i++) leftmax[i] = Math.max(nums[i-1], leftmax[i-1]);
        for(int i = n-2; i>=0; i--) rightmax[i] = Math.max(nums[i+1], rightmax[i+1]);
        
        long ans = 0;
        for (int j = 1; j < n - 1; j++) {
            long tripletValue = (long) (leftmax[j] - nums[j]) * rightmax[j];
            ans = Math.max(ans, tripletValue);
        }
        return ans;
    }
}