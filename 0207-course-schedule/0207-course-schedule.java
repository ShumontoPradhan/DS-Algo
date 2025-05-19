class Solution {  //cycle detection + topological sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); //we cant complete a course wihtout completing other  - undir
        }
        //if TOpological sort is not possible , then there is cycle! hence we cant complete the courses....it is like deadlock
        //Kahn's algo (BFS - TopoSort)
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

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
        int count = 0;//just add count variable for this question ,rest same like topo sort
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int neighbor : adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        if(count == numCourses) return true;
        else return false;
    }
}