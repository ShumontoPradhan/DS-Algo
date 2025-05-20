class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n];

        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int dir = shifts[i][2] == 1 ? 1 : -1;

            diff[start] += dir;
            if (end + 1 < n) {
                diff[end + 1] -= dir;
            }
        }

        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int shift = diff[i] % 26;
            if (shift < 0) shift += 26;
            char ch = s.charAt(i);
            int ascii = ch - 'a';
            sb.append((char) ((ascii + shift) % 26 + 'a'));
        }

        return sb.toString();
    }
}
