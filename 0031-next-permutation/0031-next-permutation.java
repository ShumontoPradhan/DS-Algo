// We want to find a larger number, but not too large - just the next larger one =>
// We want to avoid chaning the number in the left - it will increase the number too much =>
// Example: 4325413 -> we can only change the last two numbers and have 432531
// What if it was 432531 in the first place? 31 cannot be increased.
// Lets try 531 - still no
// 2531 - this can be incrased - the smallest number that can be used to incrase the 2 is 3. so for now we have 3521.
// Next we want to minimize 3521 - thats easier - just sort the numbers to the right of 3 - 3125. So the unswer is 4323125

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, idx1 = -1, idx2 = -1;
        
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx1 = i;
                break;
            }
        }
        if (idx1 == -1) {
            reverse(nums, 0);
            return;
        }
        for (int i = n - 1; i > idx1; i--) {
            if (nums[i] > nums[idx1]) {
                idx2 = i;
                break;   //because right side mai already sorted hai aur sable pahle jo milega right side se traverse karne pe wahi next greater hoga jis ele se swap karna hai 
            }
        }
        swap(nums, idx1, idx2);
        reverse(nums, idx1 + 1);
    }
    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] += nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] -= nums[j];
        }
    }
    public void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
