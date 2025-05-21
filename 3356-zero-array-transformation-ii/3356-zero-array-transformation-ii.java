//Efficient -- Binary serach cameo
class Solution {  
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        //check if the array is already a zero array
        if(checkZeroArray(nums)) return 0;
        //BInary search on queries to reduce time 
        int low = 0;
        int high = q-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(checkZeroArrayTransformation(mid, nums, queries)){
                high = mid - 1;
                ans = mid +1; //possible ans
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean checkZeroArrayTransformation(int end,int[] nums, int[][] queries){
        int[] diff = new int[nums.length];
        for(int i = 0; i <= end ; i++){  //we always go from 0 to mid,   here end means mid of bs
            int left = queries[i][0];
            int right = queries[i][1];
            int shift = queries[i][2];

            diff[left] += shift;
            if(right + 1 < nums.length){
                diff[right + 1] -= shift;
            }
        }
        int cumSum = 0;
        for(int i = 0; i < nums.length; i++){
            cumSum += diff[i];
            diff[i] = cumSum;
            if(nums[i] - diff[i]  > 0) return false; //nums[i] zero nahi ban paya
        }
        return true;
    }

    public boolean checkZeroArray(int[] nums){
        for(int x : nums){
            if(x != 0) return false;
        }
        return true;
    }
}

//TLE - O(n*Q)
// class Solution {
//     public int minZeroArray(int[] nums, int[][] queries) {
//         int n = nums.length;
//         int q = queries.length;
//         //check if the array is already a zero array
//         if(checkZeroArray(nums)) return 0;

//         for(int i = 0; i < q; i++){
//             if(checkZeroArrayTransformation(i, nums, queries)){
//                 return i+1;
//             }
//         }
//         return -1;
//     }
//     public boolean checkZeroArrayTransformation(int end,int[] nums, int[][] queries){
//         int[] diff = new int[nums.length];
//         for(int i = 0; i <= end ; i++){
//             int left = queries[i][0];
//             int right = queries[i][1];
//             int shift = queries[i][2];

//             diff[left] += shift;
//             if(right + 1 < nums.length){
//                 diff[right + 1] -= shift;
//             }
//         }
//         int cumSum = 0;
//         for(int i = 0; i < nums.length; i++){
//             cumSum += diff[i];
//             diff[i] = cumSum;
//             if(nums[i] - diff[i]  > 0) return false; //nums[i] zero nahi ban paya
//         }
//         return true;
//     }

//     public boolean checkZeroArray(int[] nums){
//         for(int x : nums){
//             if(x != 0) return false;
//         }
//         return true;
//     }
// }