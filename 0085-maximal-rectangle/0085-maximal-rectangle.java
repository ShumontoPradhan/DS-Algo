class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];  //fill 1d array for the first col
        
        for(int i = 0; i < n ; i++){
            height[i] = matrix[0][i] == '0' ? 0 : 1;
        }

        // int maxArea = 0;  //this will give wrong answer if there is only one row , because the below loops will not run and teh max area will not update and will return 0
        int maxArea = findMaxArea(height);  //find max area for the first col and store in the max area first

        for(int row = 1; row < m; row++){  //start from 1, 0th row is already filled above
            for(int col = 0; col < n; col++){
                if(matrix[row][col] == '0'){
                    height[col] = 0;
                }else{
                    height[col] += 1; //⭐
                }
            }
            maxArea = Math.max(maxArea, findMaxArea(height));
        }
        return maxArea;
    }

    public int findMaxArea(int[] height){  //this is like largest rectangle in histogram problem 
        int n = height.length;
        int[] nse = getNSE(height, n);
        int[] pse = getPSE(height, n);

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, height[i] * (nse[i] - pse[i] - 1));
        }
        return max;
    }

    public int[] getNSE(int[] height , int n){  //next smaller element
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && height[st.peek()] >= height[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i); 
        }
        return nse;
    }

    public int[] getPSE(int[] height , int n){  //prev smaller element 
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && height[st.peek()] >= height[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i); 
        }
        return pse;
    }
}