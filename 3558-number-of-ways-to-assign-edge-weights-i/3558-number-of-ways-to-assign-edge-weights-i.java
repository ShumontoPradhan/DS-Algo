class Solution {
    private static final int MOD = 1_000_000_007; 
    
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;    // fixed here
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // BFS to find max depth
        int maxDepth = 0;
        boolean[] visited = new boolean[n+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0}); // node, depth
        visited[1] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0], depth = curr[1];
            maxDepth = Math.max(maxDepth, depth);
            for(int nei : graph.get(node)){
                if(!visited[nei]){
                    visited[nei] = true;
                    queue.offer(new int[]{nei, depth+1});
                }
            }
        }
        
        if(maxDepth == 0) return 0;
        return modPow(2, maxDepth -1);
    }
    public  int modPow(int base, int exp) {
        long result = 1;
        long b = base;
        for (int i = 0; i < exp; i++) {
            result = (result * b) % MOD;
        }
        return (int) result;
    }
}
