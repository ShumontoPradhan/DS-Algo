class Solution {
    public int maxSubstrings(String word) {
        int n = word.length();
        int[] freq = new int[26];
        Arrays.fill(freq, -1);
        int maxAns = 0;
        
        for(int i = 0 ; i < n; i++){
            int prevOccurenceIdx = freq[(int) word.charAt(i) - 'a'];//if its -1 then the char has not occured previously
            if(prevOccurenceIdx != -1 && (i-prevOccurenceIdx + 1 >= 4)){
                maxAns++;
                for(int j = 0; j < 26; j++){
                    freq[j] = -1;
                }
            }else{ 
                if(prevOccurenceIdx == -1){
                    freq[(int) word.charAt(i) - 'a'] = i; //i will be the prevOccIdx in next same letter
                }
            }
        }
        return maxAns;
    }
}

//Wrong approach 
// class Solution {
//     public int maxSubstrings(String word) {
//         int n = word.length();
//         int finalAns = 0;
//         int ans = 0;
//         int i = 0;
//         while(i < n){
//             char ch = word.charAt(i);
//             for(int j = i+3; j < n; j++){
//                 if(word.charAt(j) == ch){
//                     ans++;
//                     i = j+1;
//                 }
//             }
//             finalAns = Math.max(ans, finalAns);
//             i++;
//         }
//         return finalAns;
//     }
// }