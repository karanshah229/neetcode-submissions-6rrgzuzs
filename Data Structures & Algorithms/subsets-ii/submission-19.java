class Solution {
    void subsets(int[] nums, List<List<Integer>> res, int index, List<Integer> curr) {
        if (index >= nums.length) {
            res.add(curr);
            return;
        }

        int ind = index+1;
        while(ind < nums.length && nums[ind] == nums[index]){ind++;}
        System.out.println(ind);

        List<Integer> newC = new ArrayList<>(curr);
        subsets(nums, res, ind, curr);

        newC.add(nums[index]);
        subsets(nums, res, index+1, newC);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, res, 0, new ArrayList<>());

        return res;
    }
}
