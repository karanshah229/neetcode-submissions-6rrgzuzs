class NumMatrix {
    int[][] prefixMat;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        this.prefixMat = new int[rows][cols];
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                this.prefixMat[i][j] = (j == 0 ? 0 : this.prefixMat[i][j-1]) + matrix[i][j];
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(this.prefixMat[i][j]);
                System.out.print('-');
            }
            System.out.println(" ");
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;

        while(row2 >= row1){
            int rowSum = this.prefixMat[row2][col2] - (col1 == 0 ? 0 : this.prefixMat[row2][col1 - 1]);

            result += rowSum;
            System.out.println(rowSum);
            row2--;
        }

        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */