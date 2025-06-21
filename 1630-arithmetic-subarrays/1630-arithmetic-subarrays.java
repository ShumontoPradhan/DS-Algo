class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        List<Boolean> list = new ArrayList<>(m);
        for(int i = 0; i < m; i++){
            int x = l[i];
            int y = r[i];
            int p = y-x + 1;  //no of elements
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = x; j <= y; j++){
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
            }
            //  max = min + (n-1)*d , so here if d is not divisibel by the difference 
            //  between max-min then this is not an ap
            if((max - min)%(p-1) != 0){
                list.add(false);
                continue;
            }
            int d = (max-min) / (p-1);
            if (d == 0) {
                list.add(true);
                continue;
            }           
            Set<Integer> set = new HashSet<>();
            boolean valid = true;
            for(int j = x; j <= y; j++){
                if((max - nums[j]) % d != 0){
                    valid = false;
                    break;
                }
                set.add(nums[j]); // storing  just to check if there are any duplicates or not in the array, if there is , then at last we will check set.size() == p ? 
            }
            list.add(valid == true && set.size() == p);
        }
        return list;
    }
}