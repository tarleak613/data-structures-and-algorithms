class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] image = new int[m][n];

        //transpose
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                image[i][j] = matrix[j][i];
            }
        }

        //reverse each row
        for(int i = 0; i < m; i++){
            int l = 0, r = n-1;
            while(l < r){
                int temp = image[i][l];
                image[i][l] = image[i][r];
                image[i][r] = temp;
                l++;
                r--;
            }
        }

        //modify the matrix
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = image[i][j];
            }
        }
    }
}