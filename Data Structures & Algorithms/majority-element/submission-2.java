class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num: nums){
            hm.putIfAbsent(num, 0);
            int val = hm.get(num) + 1;
            hm.put(num, val);
        }

        int returnVal = 0, count = 0;
        for(int key: hm.keySet()){
            int val = hm.get(key);
            if(val > count) {
                returnVal = key;
                count = val;
            }
        }

        return returnVal;
    }
}