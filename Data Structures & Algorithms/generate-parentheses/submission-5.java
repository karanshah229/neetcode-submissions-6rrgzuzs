class Solution {
    public void gen(List<String> res, int n, int currO, int currC, String curr){
        if(currO == n){
            while(currC < n){
                currC++;
                curr += ")";
            }
            res.add(curr);
            return;
        }

        if(currC < currO) {
            gen(res, n, currO, currC+1, new String(curr) + ")");
        }

        gen(res, n, currO+1, currC, new String(curr) + "(");
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gen(res, n, 0, 0, "");

        return res;
    }
}
