class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix[0][0] > target || matrix[m-1][n-1] < target) return false;
        int pos = binarySearch(m, n, matrix, target);
        System.out.println(pos);
        return binarySearch2(m, n, matrix, target, pos);
    }
    public int binarySearch(int m, int n, int[][] matrix, int target){
        int end = m-1;
        int start = 0;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(matrix[mid][n-1] == target){
                return mid;
            }else if(matrix[mid][n-1] > target){
                end = mid-1;
                ans = mid;
            }else{
                start = mid+1;
                ans = start;
            }
        }
        return ans;
    }
    public boolean binarySearch2(int m, int n, int[][] matrix, int target, int pos){
        int end = n-1;
        int start = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(matrix[pos][mid] == target){
                return true;
            }else if(matrix[pos][mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
}