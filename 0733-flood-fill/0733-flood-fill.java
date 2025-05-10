class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        dfs(image[sr][sc], sr, sc , image , color, m, n);
        return image;
    }
    public void dfs(int start, int sr, int sc, int[][] image, int color, int m, int n){
        if(sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] == color || image[sr][sc] != start) return;
        image[sr][sc] = color;
        dfs(start, sr+1, sc, image, color, m, n);
        dfs(start, sr, sc+1, image, color, m, n);
        dfs(start, sr-1, sc, image, color, m, n);
        dfs(start, sr, sc-1, image, color, m, n);
    }
}