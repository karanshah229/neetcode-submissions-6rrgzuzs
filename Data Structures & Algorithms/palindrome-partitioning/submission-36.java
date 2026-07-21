class Solution {
    public boolean isPali(String s){
        int left = 0, right = s.length() - 1;
        while(left <= right) if(s.charAt(left++) != s.charAt(right--)) return false;
        return true;
    }

    public void subsets(String s, List<List<String>> res, int index, List<String> curr){
        if(index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if(curr.size() > 1){
            String t = curr.get(curr.size()-2);
            if(!isPali(t)) return;
        }

        List<String> currC = new ArrayList<>(curr);
        if(currC.size() > 0) {
            String s1 = currC.remove(currC.size()-1);
            s1 += String.valueOf(s.charAt(index));
            currC.add(s1);
            subsets(s, res, index+1, currC);
        }

        List<String> currC2 = new ArrayList<>(curr);
        currC2.add(String.valueOf(s.charAt(index)));
        subsets(s, res, index+1, currC2);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        subsets(s, res, 0, new ArrayList<>());
        System.out.println(res);

        List<List<String>> res2 = new ArrayList<>();
        for(List<String> re: res){
            boolean areAllPali = true;
            for(String s1: re) if(!isPali(s1) || s1.length() == 0) areAllPali = false;
            if(areAllPali) res2.add(re);
        }

    
        return res2;
    }
}
