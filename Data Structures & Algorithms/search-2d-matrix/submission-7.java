class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row1 = 0;
        int row2 = matrix.length - 1;
        int col1 = 0;
        int col2 = matrix[0].length - 1;

        while(row1 <= row2){
            int row = row1 + (row2 - row1) / 2;

            if(target == matrix[row][col1] || target == matrix[row][col2]){
                return true;
            }
            
            if(target > matrix[row][col1] && target < matrix[row][col2]){
                while(col1 <= col2){
                    int col = col1 + (col2 - col1) / 2;

                    if(target == matrix[row][col]) return true;
                    if(target > matrix[row][col]) {
                        col1 = col + 1;
                        continue;
                    }
                    if(target < matrix[row][col]) {
                        col2 = col - 1;
                        continue;
                    }
                }

                return false;
            }

            if(target > matrix[row][col1] && target > matrix[row][col2]){
                row1 = row + 1;
                continue;
            }
            
            if(target < matrix[row][col1] && target < matrix[row][col2]){
                row2 = row - 1;
                continue;
            }

            break;
        }

        return false;
    }
}
