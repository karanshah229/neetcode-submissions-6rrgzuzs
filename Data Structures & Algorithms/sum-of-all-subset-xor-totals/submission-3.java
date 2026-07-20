class Solution {
    void subsets(int[] nums, List<List<Integer>> res, int index, List<Integer> curr) {
        if (index >= nums.length) {
            res.add(curr);
            return;
        }

        List<Integer> newC = new ArrayList<>(curr);
        subsets(nums, res, index + 1, curr);

        newC.add(nums[index]);
        subsets(nums, res, index + 1, newC);
    }

    public int subsetXORSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, res, 0, new ArrayList<>());

        int total = 0;
        for (List<Integer> l : res) {
            if (l.size() != 0) {
                int sum = Integer.MIN_VALUE;
                for (int n : l) {
                    if (sum == Integer.MIN_VALUE)
                        sum = n;
                    else
                        sum = sum ^ n;
                }

                total += sum;
            }
        }

        return total;
    }
}