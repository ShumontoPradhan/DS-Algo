class Solution {  //simply find the number of components in graph
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        //construct graph 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        //dfs
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj , boolean[] visited, int start){
        visited[start] = true;
        for(int neighbor : adj.get(start)){
            if(visited[neighbor] == false){
                dfs(adj, visited, neighbor);
            }
        }
    }
}