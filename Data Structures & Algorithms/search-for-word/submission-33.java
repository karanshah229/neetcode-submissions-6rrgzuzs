class Solution {
    public char[][] boardCopy(char[][] board){
        char[][] res = new char[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                res[i][j] = board[i][j];
            }
        }

        return res;
    }

    public boolean ex(char[][] board, int i, int j, String word, String curr){
        if(board[i][j] == '.') return false;
        if(curr.equals(word)) return true;
        if(curr.length() > word.length()) return false;

        char[][] boardC = boardCopy(board);
        char c = boardC[i][j];
        boardC[i][j] = '.';
        if(c != word.charAt(curr.length())) return false;

        String currC = new String(curr);
        currC += String.valueOf(c);

        if(currC.equals(word)) return true;

        int top = i == 0 ? -1 : i-1;
        int bottom = i == boardC.length-1 ? -1 : i+1;
        int left = j == 0 ? -1 : j-1;
        int right = j == boardC[0].length-1 ? -1 : j+1;

        boolean res = false;
        if(top != -1) res = res || ex(boardC, i-1, j, word, currC);
        if(bottom != -1) res = res || ex(boardC, i+1, j, word, currC);
        if(left != -1) res = res || ex(boardC, i, j-1, word, currC);
        if(right != -1) res = res || ex(boardC, i, j+1, word, currC);

        return res;
    }

    public boolean exist(char[][] board, String word) {
        if(board.length == 1 && board[0].length == 1) {
            return String.valueOf(board[0][0]).equals(word);
        }

        boolean res = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                res = res || ex(board, i, j, word, "");
            }
        }

        return res;
    }
}
