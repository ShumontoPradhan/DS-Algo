class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i += 3){
            if(isDistinct(nums, i) == true){
                return count;
            }
            count++;
        }
        return count;
    }
    public boolean isDistinct(int[] nums, int i){
        Set<Integer> set = new HashSet<>();
        for(int j= i; j < nums.length; j++){
            if(set.contains(nums[j])) return false;
            set.add(nums[j]);
        }
        return true;
    }
}