class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        int[] freq = new int[1000];
        for(int i = 0; i < n; i++){
            freq[answers[i]]++;
        } 
        int ans = 0;
        for(int i = 0; i < 1000; i++){
            if(freq[i] == 0) continue;
            int count = freq[i];
            int groupSize = i+1;
            int groups = (int) Math.ceil((double) count / groupSize);
            ans += (groups * groupSize);
        }
        return ans;
    }
}