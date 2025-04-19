class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int lb = lowerBound(nums, i + 1, n, lower - nums[i]);
            int ub = upperBound(nums, i + 1, n, upper - nums[i]);
            ans += (ub - lb);
        }
        return ans;
    }

    public int lowerBound(int[] nums, int start, int end, int target) {
        int low = start, high = end;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int upperBound(int[] nums, int start, int end, int target) {
        int low = start, high = end;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}


//brute force
// class Solution {
//     public long countFairPairs(int[] nums, int lower, int upper) {
//         int n = nums.length;
//         long count = 0;
//         for(int i =0; i < n; i++){
//             for(int j = i+1; j < n; j++){
//                 if(nums[i] + nums[j] >= lower && nums[i] + nums[j] <= upper) count++;
//             }
//         }
//         return count;
//     }
// }