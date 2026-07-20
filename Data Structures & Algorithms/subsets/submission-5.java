class Solution {
    public void subsets(int[] nums, List<List<Integer>> res, int index, List<Integer> curr) {
        if(index >= nums.length) {
            res.add(curr);
            return;
        }

        List<Integer> newC = new ArrayList<>(curr);
        subsets(nums, res, index+1, curr);

        newC.add(nums[index]);
        subsets(nums, res, index+1, newC);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, res, 0, new ArrayList<>());

        return res;
    }
}
