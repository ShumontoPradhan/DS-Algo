class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(i == j || j == k || k == i){
                        continue;
                    }
                    int digit = (digits[i]*100) + (digits[j]*10) + digits[k];
                    if(digit >= 100 && digit%2 == 0){
                        set.add(digit);
                    }
                }
            }
        }
        int[] arr = new int[set.size()];
        int i = 0;
        for(int num : set){
            arr[i++] = num;
        }
        Arrays.sort(arr);
        return arr;
    }
}