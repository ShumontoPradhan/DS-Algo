class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors  = new int[n]; //(red - 1) , (yellow - 0)
        Arrays.fill(colors, -1); //this will also work as visited array 
        for(int i = 0; i < n; i++){
            if(colors[i] == -1){
                if(!bipartite_check(graph, colors, i, 1)){  //currColour 
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean bipartite_check(int[][] graph, int[] color,int start, int currColor){
        color[start] = currColor;
        for(int neighbor : graph[start]){
            if(color[neighbor] == color[start]) return false;
            if(color[neighbor] == -1){
                if(bipartite_check(graph, color, neighbor, 1- currColor) == false){
                    return false;
                }
            }
        }
        return true;
    }
}
// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
//         for(int i = 0; i < n; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i = 0; i < n; i++){
//             for(int neighbor : graph[i]){
//                 adj.get(i).add(neighbor);  //undirected
//                 adj.get(neighbor).add(i);
//             }
//         }
        
//         int[] colors  = new int[n]; //(red - 1) , (yellow - 0)
//         Arrays.fill(colors, -1); //this will also work as visited array 
//         for(int i = 0; i < n; i++){
//             if(colors[i] == -1){
//                 if(!bipartite_check(adj, colors, i, 1)){  //currColour 
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
    
//     public boolean bipartite_check(ArrayList<ArrayList<Integer>> adj, int[] color,int start, int currColor){
//         color[start] = currColor;
//         for(int neighbor : adj.get(start)){
//             if(color[neighbor] == color[start]) return false;
//             if(color[neighbor] == -1){
//                 if(bipartite_check(adj, color, neighbor, 1- currColor) == false){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }