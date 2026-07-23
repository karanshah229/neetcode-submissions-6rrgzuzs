class Solution {
    int n;
    record Point(int x, int y) {}

    public void solve(
        List<List<Point>> pos,
        List<Point> curr,
        int row,
        Set<Integer> usedCols,
        Set<Integer> usedDiag1,
        Set<Integer> usedDiag2
    ) {
        if (row == n) {
            pos.add(new ArrayList<>(curr));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (
                usedCols.contains(col) ||
                usedDiag1.contains(row - col) ||
                usedDiag2.contains(row + col)
            ) {
                continue;
            }

            curr.add(new Point(row, col));
            usedCols.add(col);
            usedDiag1.add(row - col);
            usedDiag2.add(row + col);

            solve(pos, curr, row + 1, usedCols, usedDiag1, usedDiag2);

            curr.remove(curr.size() - 1);
            usedCols.remove(col);
            usedDiag1.remove(row - col);
            usedDiag2.remove(row + col);
        }
    }

    public int totalNQueens(int n) {
        this.n = n;
        List<List<Point>> pos = new ArrayList<>();
        solve(
            pos,
            new ArrayList<>(),
            0,
            new HashSet<>(),
            new HashSet<>(),
            new HashSet<>()
        );

        System.out.println(pos);

        return pos.size();

        // List<List<String>> res = new ArrayList<>();
        // for(List<Point> plc: pos){
        //     List<String> pStrL = new ArrayList<>();
        //     for(int i = 0; i < n; i++){
        //         String row = "";
        //         Point p = plc.get(i);
        //         for(int j = 0; j < n; j++){
        //             if(p.x == i && p.y == j) row += "Q";
        //             else row += ".";
        //         }
        //         pStrL.add(row);
        //     }
        //     res.add(pStrL);
        // }

        // System.out.println(res);

        // return res;
    }
}