class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();

        for(int num: nums) hm.put(num, hm.getOrDefault(num, 0) + 1);

        int res = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(entry.getValue() == 1) res = Math.max(res, entry.getKey());
        }

        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
