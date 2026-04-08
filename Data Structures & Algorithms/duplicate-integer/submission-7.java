class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Hashtable<Integer, Boolean> ht = new Hashtable<>();

        // for(int num: nums){
        //     if(ht.get(num) == null){
        //         ht.put(num, false);
        //     } else {
        //         return true;
        //     }
        // }

        // return false;

        Set<Integer> s = new HashSet<Integer>(nums.length);
        
        for(int num: nums){
            s.add(num);
        }


        if(nums.length != s.size()) return true;
        return false;
    }
}