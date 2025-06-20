class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        // Reverse row
        for (int i = 0; i < n; i++) {
            int x = 0, y = n - 1;
            while (x < y) {
                int temp = matrix[i][x];
                matrix[i][x] = matrix[i][y];
                matrix[i][y] = temp;
                x++;
                y--;
            }
        }
    }
    /*public void swap(int a , int b){//java problem, it just swaps the copy not the actual val
        int temp = a;   //have to pass the matrix , with idx to change the actual val
        a = b;
        b = temp;
    }*/
}
