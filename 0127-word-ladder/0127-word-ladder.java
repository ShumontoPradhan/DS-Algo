class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 0;
        while(!q.isEmpty()){
            int currentLevelSize = q.size(); //all the nodes in the queue are supposed to be explored so we are counting the nmber of nodes in the queue so that we could iterate that many times
            for(int i = 0; i < currentLevelSize; i++){
                String node = q.poll();
                if(node.equals(endWord)){
                    return level + 1;
                }
                List<String> neighbors = findPossibleNeighbors(node, set);
                for(String word : neighbors){
                    q.offer(word);
                    set.remove(word);
                }
            }
            level++;
        }
        return 0;
    }
    public List<String> findPossibleNeighbors(String word, Set<String> set){
        List<String> neighbors = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                if(ch == word.charAt(i)) continue;
                String newWord = word.substring(0,i) + ch + word.substring(i+1,word.length());
                if(set.contains(newWord)) neighbors.add(newWord);
            }
        }
        return neighbors;
    }
}