class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String startStr = String.valueOf(start - 1);
        String finishStr = String.valueOf(finish);
        return solve(finishStr, s, limit) - solve(startStr, s, limit);
    }

    public long solve(String str, String suffix, int limit) {
        if (str.length() < suffix.length()) return 0;
        long count = 0;
        String trailString = str.substring(str.length() - suffix.length());
        int remainingL = str.length() - suffix.length();

        for (int i = 0; i < remainingL; i++) {
            int digit = str.charAt(i) - '0';
            if (digit <= limit) {
                count += digit * Math.pow(limit + 1, remainingL - i - 1);
            } else {
                count += Math.pow(limit + 1, remainingL - i);
                return count;
            }
        }
        if (trailString.compareTo(suffix) >= 0) count += 1;
        return count;
    }
}


// class Solution {
//     public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
//         long num = Long.valueOf(s);
//         long d = (long) Math.pow(10, s.length());

//         if (finish < num) return 0;

//         long count = 0;

//         while (num <= finish) {
//             if (num >= start && isSuffix(num, s) && inLimit(num, limit)) {
//                 count++;
//             }
//             num += d;
//         }
//         return count;
//     }

//     public boolean isSuffix(long num, String s) {
//         return String.valueOf(num).endsWith(s); 
//     }

//     public boolean inLimit(long num, int limit) {
//         while (num > 0) {
//             long digit = num % 10;
//             if (digit > limit) return false;
//             num /= 10;
//         }
//         return true;
//     }
// }
