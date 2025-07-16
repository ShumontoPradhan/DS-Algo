class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int evc = 0;
        int odc = 0;
        int count = 0;
        int prevEven = 0; //true mean odd and false means even
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 0) evc++;
            else odc++;
            if(i == 0){
                prevEven = nums[i] %2  == 0 ? 1 : 0;
                count++;
            }
            if(i != 0 && prevEven == 1 && nums[i] %2 != 0){
                count++;
                prevEven = 0;
            }
            if(i != 0 && prevEven == 0 && nums[i] %2 == 0){
                count++;
                prevEven = 1;
            }
        }
        return Math.max(count, Math.max(evc, odc));
    }
}