class Solution {
    final int M = (int)1e9 + 7;

    public int countGoodNumbers(long n) {
        return (int)((findPower(5, (n + 1) / 2) * findPower(4, n / 2)) % M);
    }

    public long findPower(long a, long b) {
        if (b == 0) return 1;
        long half = findPower(a, b / 2);
        long result = (half * half) % M;
        if (b % 2 == 1) {
            result = (result * a) % M;  
        }
        return result;
    }
}
