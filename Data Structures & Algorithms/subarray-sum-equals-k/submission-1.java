class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        mp.put(0, 1);

        int res = 0;
        int currSum = 0;

        for(int num: nums){
            currSum += num;
            int diff = currSum - k;
            res += mp.getOrDefault(diff, 0);

            mp.put(currSum, mp.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }
}