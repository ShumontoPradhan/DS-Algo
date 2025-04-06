//Approach-2 (Using Bottom Up same as LIS) - Just need to keep track of how to print LIS
//T.C : O(n^2)
//S.C : O(n)
public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] t = new int[n];
        Arrays.fill(t, 1);

        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx, -1);

        int lastChosenIndex = 0;
        int maxL = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                        prevIdx[i] = j;
                    }

                    if (t[i] > maxL) {
                        maxL = t[i];
                        lastChosenIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (lastChosenIndex >= 0) {
            result.add(nums[lastChosenIndex]);
            lastChosenIndex = prevIdx[lastChosenIndex];
        }

        return result;
    }
}

//recurion TLE
// class Solution {
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);
//         List<Integer> ans = new ArrayList<>();
//         List<Integer> temp = new ArrayList<>();
//         int idx = 0;
//         int prev = -1;
//         solve(nums, ans, temp , idx, prev);
//         return ans;
//     }
//     public void solve(int[] nums, List<Integer> ans, List<Integer> temp , int idx, int prev){
//         if(idx >= nums.length){
//             if(temp.size() > ans.size()){
//                 ans.clear();  // Clear existing answer list
//                 ans.addAll(temp); 
//             }
//             return;
//         }
//         if(prev == -1 || nums[idx] % prev == 0){
//             temp.add(nums[idx]);
//             solve(nums, ans, temp, idx+1, nums[idx]);
//             temp.remove(temp.size() - 1);  //backtracking
//         }
//         solve(nums, ans, temp, idx+1, prev);
//     }
// }

// class Solution {
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         Arrays.sort(nums);
//         int n = nums.length;

//         for (int i = 0; i < n; i++) {
//             List<Integer> list = new ArrayList<>();
//             list.add(nums[i]);

//             for (int j = i+1 ; j < n; j++) {  
//                 if (nums[j] % list.get(list.size() - 1) == 0) {  
//                     list.add(nums[j]);
//                 }
//             }
            
//             if (list.size() > ans.size()) {
//                 ans = new ArrayList<>(list); 
//             }
//         }
//         return ans;
//     }
// }