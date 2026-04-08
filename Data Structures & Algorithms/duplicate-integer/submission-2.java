class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer, Boolean> ht = new Hashtable<>();

        for(int num: nums){
            if(ht.get(num) == null){
                ht.put(num, false);
            } else {
                return true;
            }
        }

        return false;
    }
}