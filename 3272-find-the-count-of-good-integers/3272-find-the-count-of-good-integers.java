class Solution {
    public long countGoodIntegers(int n, int k) {
        int d = (n+1)/2;
        int lowerBound = (int) Math.pow(10, d - 1);
        int upperBound = (int) Math.pow(10, d) - 1;

        Set<String> set = new HashSet<>();
        for(int i = lowerBound; i <= upperBound ; i++){
            String leftHalf = String.valueOf(i);
            String full = "";

            if (n % 2 == 0) {
                StringBuilder rightHalf = new StringBuilder(leftHalf).reverse();
                full = leftHalf + rightHalf.toString();
            } else {
                StringBuilder rightHalf = new StringBuilder(leftHalf.substring(0, d - 1)).reverse();
                full = leftHalf + rightHalf.toString();
            }
            long number = Long.parseLong(full);

            if(number % k != 0) continue;
            char[] chars = full.toCharArray();
            Arrays.sort(chars);
            set.add(new String(chars)); //convert to string and push to set            
        }
        long[] factorial = new long[11];  //precompute factorial and store in const time
        factorial[0] = 1;
        for(int i = 1; i<11; i++) factorial[i] = factorial[i-1] * i;

        long result = 0;
        for(String s : set){
            int[] count = new int[10];
            for(char ch : s.toCharArray()){
                count[ch - '0']++;
            }

            int totalDigits = s.length();
            int zeroDigits = count[0];  //0th index ka count is the total zeroes
            int nonZeroDigits = totalDigits - zeroDigits;

            long permutation = nonZeroDigits * factorial[totalDigits -1];
            for(int i = 0; i < 10 ; i++){
                permutation /= factorial[count[i]];
            }
            result += permutation;
        }
        return result;
    }
}