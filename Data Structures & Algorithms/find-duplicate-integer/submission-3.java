class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Boolean> hm = new HashMap<>();

        for(int n: nums){
            if(hm.containsKey(n)){
                return n;
            } else {
                hm.put(n, true);
            }
        }

        return -1;
    }
}
