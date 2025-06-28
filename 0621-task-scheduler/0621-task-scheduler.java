class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        int[] freq = new int[26];
        int maxFreq = 0;
        for(int i = 0; i < m; i++){
            freq[tasks[i] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[tasks[i] - 'A']);
        }
        int ans = (maxFreq - 1) * (n + 1);
        for(int i = 0; i < m; i++){
            if(maxFreq == freq[i]) ans++;
        }
        return Math.max(ans, m);
    }
}