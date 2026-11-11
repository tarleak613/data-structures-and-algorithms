class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean zeroInRow = false;
        boolean zeroInCol = false;

        //check for row
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0)
                zeroInRow = true;
        }

        //check for column
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0)
                zeroInCol = true;
        }

        //check and place zeroes in first row and first column
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //place zeroes
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //place zeroes in first row
        for(int i = 0; i < m; i++){
            if(zeroInRow){
                matrix[i][0] = 0;
            }
        }

        //place zeroes in first column
        for(int i = 0; i < n; i++){
            if(zeroInCol){
                matrix[0][i] = 0;
            }
        }
    }
}