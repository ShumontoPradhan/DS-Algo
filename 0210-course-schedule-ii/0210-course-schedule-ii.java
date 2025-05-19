class Solution {  //same as topological sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); 
        }
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>(numCourses);

        for(int u = 0; u < numCourses; u++){
            for(int v : adj.get(u)){
                inDegree[v]++;
            }
        }
        for(int i = 0; i < numCourses ; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            count++;
            for(int neighbor : adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        if(count != numCourses) return new int[]{};
        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(res.size()-i-1);
        }
        return arr;
    }
}