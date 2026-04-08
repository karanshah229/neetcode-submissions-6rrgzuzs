class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        List<HashSet<Character>> colList = new ArrayList<>(cols);
        List<HashSet<Character>> boxList = new ArrayList<>(cols);
        for (int i = 0; i < 9; i++) {
            colList.add(new HashSet<>());
            boxList.add(new HashSet<>());
        }

        for(int i = 0; i < rows; i++){
            var rowSet = new HashSet<Character>();

            for(int j = 0; j < cols; j++){
                if(board[i][j] == '.') continue;

                int pc1 = rowSet.size();
                rowSet.add(board[i][j]);
                int nc1 = rowSet.size();
                if(pc1 == nc1) return false;

                HashSet<Character> colSet = colList.get(j);
                int pc2 = colSet.size();
                colSet.add(board[i][j]);
                int nc2 = colSet.size();
                if(pc2 == nc2) return false;

                HashSet<Character> boxSet = boxList.get((i / 3) * 3 + j / 3);
                int pc3 = boxSet.size();
                boxSet.add(board[i][j]);
                int nc3 = boxSet.size();
                if(pc3 == nc3) return false;
            }
        }

        return true;
    }
}
