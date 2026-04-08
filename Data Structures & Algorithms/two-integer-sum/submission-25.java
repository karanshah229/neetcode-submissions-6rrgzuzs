class Solution {
    public int[] twoSum(int[] nums, int target) {
        int numsLen = nums.length;
        Map<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for(int i = 0; i < numsLen; i++){
            ArrayList<Integer> al = new ArrayList<Integer>();

            ArrayList<Integer> val = hm.get(nums[i]);
            if(val != null){
                al.addAll(val);
            }
            al.add(i);
            hm.put(nums[i], al);
        }

        for(Integer key: hm.keySet()){
            int requiredNum = target - key;
            if(hm.get(requiredNum) != null){
                ArrayList<Integer> requiredNumIndexes = hm.get(requiredNum);
                if(key == requiredNum && requiredNumIndexes.size() >= 2){
                    // same number
                    int[] result = {requiredNumIndexes.get(0), requiredNumIndexes.get(1)};
                    return result;
                }
                int[] result = { hm.get(key).get(0), requiredNumIndexes.get(0) };
                Arrays.sort(result);
                return result;
            }
        }

        int[] result = {0, 0};
        return result;
    }
}
