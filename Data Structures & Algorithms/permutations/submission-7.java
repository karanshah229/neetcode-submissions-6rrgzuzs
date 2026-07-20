class Solution {
    public void perm(List<List<Integer>> res, Map<Integer, Integer> hm, List<Integer> curr){
        if(hm.size() == 0) {
            res.add(curr);
            return;
        }

        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            Map<Integer, Integer> hmC = new HashMap<>(hm);
            List<Integer> currC = new ArrayList<>(curr);

            int key = entry.getKey();
            currC.add(key);
            hmC.remove(key);

            perm(res, hmC, currC);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n: nums) hm.put(n, 1);

        List<List<Integer>> res = new ArrayList<>();
        perm(res, hm, new ArrayList<>());

        return res;
    }
}
