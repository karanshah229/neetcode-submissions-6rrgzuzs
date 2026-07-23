class Solution {
    int n;
    record Point(int x, int y) {}

    public boolean isValidPos(List<Point> curr, Point p){
        for(Point o: curr){
            if(o.x == p.x || o.y == p.y) return false;
            if(Math.abs(o.x - p.x) == Math.abs(o.y - p.y)) return false;
        }

        return true;
    }

    public void solve(List<List<Point>> pos, List<Point> curr, int index){
        if(curr.size() == n) {
            pos.add(curr);
            return;
        }

        for(int j = 0; j < n; j++){
            List<Point> currC = new ArrayList<>(curr);
            Point p = new Point(index, j);
            if(isValidPos(currC, p)) {
                currC.add(p);
                solve(pos, currC, index+1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        List<List<Point>> pos = new ArrayList<>();
        solve(pos, new ArrayList<>(), 0);

        System.out.println(pos);

        List<List<String>> res = new ArrayList<>();
        for(List<Point> plc: pos){
            List<String> pStrL = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String row = "";
                Point p = plc.get(i);
                for(int j = 0; j < n; j++){
                    if(p.x == i && p.y == j) row += "Q";
                    else row += ".";
                }
                pStrL.add(row);
            }
            res.add(pStrL);
        }

        System.out.println(res);

        return res;
    }
}
