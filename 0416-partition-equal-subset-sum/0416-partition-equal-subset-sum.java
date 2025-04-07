class Solution {
    public Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i= 0; i < n; i++){
            total += nums[i];
        }
        if(total % 2 != 0) return false; //if total not divisible by 2 then it should be false
        dp = new Boolean[201][20001];
        return solve(nums, 0, total/2); 
    }
    public boolean solve(int[] nums, int i,int target){
        if(i >= nums.length) return false;
        if( target == 0) return true;

        if(dp[i][target] != null) return dp[i][target];

        boolean take = false;
        if(nums[i] <= target) take = solve(nums, i+1, target - nums[i]);
        boolean skip = solve(nums, i+1, target);

        return dp[i][target] = take || skip;
    }
}

//Recursion TLE
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
//         int total = 0;
//         for(int i= 0; i < n; i++){
//             total += nums[i];
//         }
//         if(total % 2 != 0) return false; //if total not divisible by 2 then it should be false
        
//         return solve(nums, 0, total/2); 
//     }
//     public boolean solve(int[] nums, int i,int target){
//         if(i >= nums.length) return false;
//         if( target == 0) return true;

//         boolean take = false;
//         if(nums[i] <= target) take = solve(nums, i+1, target - nums[i]);
//         boolean skip = solve(nums, i+1, target);

//         return take || skip;
//     }
// }


// class Solution {
//     public boolean found = false;
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
//         int total = 0;
//         for(int i= 0; i < n; i++){
//             total += nums[i];
//         }
//         if(total % 2 != 0) return false; //if total not divisible by 2 then it should be false
//         solve(nums, 0, total, 0); //0 is temp
//         return found == true;
//     }
//     public void solve(int[] nums, int i,int total, int temp){
//         if(found == true || i >= nums.length) return;
//         if(temp * 2 == total) {
//             found = true;
//             return;
//         }
//         solve(nums, i+1, total, temp + nums[i]);
//         solve(nums, i+1, total, temp);
//     }
// }