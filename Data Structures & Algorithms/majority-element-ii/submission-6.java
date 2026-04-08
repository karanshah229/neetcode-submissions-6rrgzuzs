class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int numsLen = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for(int num: nums){
            mp.put(num, (mp.getOrDefault(num, 0) + 1));
        }

        List<Integer> result = new ArrayList<Integer>();
        mp.forEach((key, val) -> {
            System.out.println(key + " - " + val);
            if(val > (numsLen / 3)) result.add(key);
        });

        return result;
    }
}