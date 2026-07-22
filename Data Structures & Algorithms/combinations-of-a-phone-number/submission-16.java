class Solution {
    static Map<Integer, char[]> hm = new HashMap<>();
    static {
        hm.put(2, new char[]{'a', 'b', 'c'});
        hm.put(3, new char[]{'d', 'e', 'f'});
        hm.put(4, new char[]{'g', 'h', 'i'});
        hm.put(5, new char[]{'j', 'k', 'l'});
        hm.put(6, new char[]{'m', 'n', 'o'});
        hm.put(7, new char[]{'p', 'q', 'r', 's'});
        hm.put(8, new char[]{'t', 'u', 'v'});
        hm.put(9, new char[]{'w', 'x', 'y', 'z'});
    }

    public void comb(
        List<String> res,
        int index,
        String curr,
        String digits
    ){
        if(curr.length() == digits.length()){
            res.add(curr);
            return;
        }

        char[] chars = hm.get(Integer.parseInt(
            String.valueOf(digits.charAt(index))
        ));
        for(char c: chars){
            comb(res, index+1, new String(curr) + String.valueOf(c), digits);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        comb(res, 0, "", digits);

        return res;
    }
}
