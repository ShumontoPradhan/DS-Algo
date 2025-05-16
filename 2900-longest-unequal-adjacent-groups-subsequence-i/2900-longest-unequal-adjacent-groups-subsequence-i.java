class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups){
        int n = words.length;
        List<String> ans = new ArrayList<>();
        int c = -1;
        int i = 0;
        while(i < n){
            if(groups[i] != c){
                ans.add(words[i]);
                c = groups[i];
            }
            i++;
        }
        return ans;
    }
}

// class Solution {
//     public List<String> getLongestSubsequence(String[] words, int[] groups) {
//         List<List<String>> ans = new ArrayList<>();
//         List<String> list = new ArrayList<>();
//         int n = words.length; //words and groups have the same length
//         int[][] dp = new int[n][n];
//         helper(words, groups, list, ans, n, 0, -1, dp);
        
//         List<String> longest = new ArrayList<>();
//         for(List<String> sublist : ans){
//             if(sublist.size() > longest.size()){
//                 longest = sublist;
//             }
//         }
//         return longest;
//     }
//     public void helper(String[] words, int[] groups,List<String> list, List<List<String>> ans, int n, int idx, int prev, int[][] dp){
//         if(idx >= n){
//             ans.add(new ArrayList<>(list));
//             return;
//         }
//         if(dp[prev][idx])

//         if(prev != groups[idx] || prev == -1){
//             list.add(words[idx]);
//             helper(words, groups, list, ans, n, idx+1, groups[idx]);
//             list.remove(list.size() - 1);
//         }
//         helper(words, groups, list, ans, n , idx+1, prev);
//     }
// }