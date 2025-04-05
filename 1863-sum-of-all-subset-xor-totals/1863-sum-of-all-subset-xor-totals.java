class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[(int)Math.pow(2, n)];
        Arrays.fill(dp, -1);
        return helper(nums, 0, 0, dp);
    }

    private int helper(int[] nums, int i, int xor , int[] dp) {
        if (i == nums.length) return xor;
        if(dp[i] != -1) return dp[i];
        return helper(nums, i + 1, xor ^ nums[i], dp) + helper(nums, i + 1, xor, dp);
    }
}
