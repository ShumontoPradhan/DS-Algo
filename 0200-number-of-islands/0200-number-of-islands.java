class Solution {
    //we just have to find the no. of components in the graph
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    dfs(i , j, m, n, grid, visited);
                    count++;  
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j, int m, int n, char[][] grid, boolean[][] visited){
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == true || grid[i][j] == '0') return;
        visited[i][j] = true;
        dfs(i+1 , j, m, n, grid, visited);
        dfs(i , j+1, m, n, grid, visited);
        dfs(i-1 , j, m, n, grid, visited);
        dfs(i , j-1, m, n, grid, visited);
    }
}