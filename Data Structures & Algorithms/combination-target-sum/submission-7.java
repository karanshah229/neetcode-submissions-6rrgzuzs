class Solution {
    void subsets(
        int[] nums,
        List<List<Integer>> res,
        int index,
        List<Integer> curr,
        int currSum,
        int target
    ) {
        if(currSum > target) return;
        if(currSum == target){
            res.add(curr);
            return;
        }
        if (index >= nums.length) return;

        List<Integer> newC = new ArrayList<>(curr);
        subsets(nums, res, index + 1, newC, currSum, target); // don't choose, move on

        newC.add(nums[index]); // choose
        subsets(nums, res, index, newC, currSum + nums[index], target); // stay
        // subsets(nums, res, index + 1, newC, currSum + nums[index], target); // move on
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, res, 0, new ArrayList<>(), 0, target);

        return res;
    }
}
