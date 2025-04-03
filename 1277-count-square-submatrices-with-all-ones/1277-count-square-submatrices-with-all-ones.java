class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[301][301];
        for(int[] row : dp) Arrays.fill(row, -1);
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                result += solve(matrix, m, n, i, j, dp);  //for each index check right, diagonal , down 
            }
        }
        return result;
    }
    public int solve(int[][] matrix, int m, int n, int i, int j, int[][] dp){
        if(i >= m || j >= n) return 0;
        if(matrix[i][j] == 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int right = solve(matrix, m, n, i, j+1, dp);
        int diagonal = solve(matrix, m, n, i+1, j+1, dp);
        int down = solve(matrix, m, n, i+1, j, dp);

        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));  //1 is the value of matrix[i][j] which is added to the min value
    }
}

//RECURSION- TLE
// class Solution {
//     public int countSquares(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int result = 0;
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j< n; j++){
//                 result += solve(matrix, m, n, i, j);  //for each index check right, diagonal , down 
//             }
//         }
//         return result;
//     }
//     public int solve(int[][] matrix, int m, int n, int i, int j){
//         if(i >= m || j >= n) return 0;
//         if(matrix[i][j] == 0) return 0;

//         int right = solve(matrix, m, n, i, j+1);
//         int diagonal = solve(matrix, m, n, i+1, j+1);
//         int down = solve(matrix, m, n, i+1, j);

//         return 1 + Math.min(right, Math.min(diagonal, down));  //1 is the value of matrix[i][j] which is added to the min value
//     }
// }