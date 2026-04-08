class Solution {
    public int[] sortArray(int[] nums) {
        int numsLen = nums.length;
        for(int i = 0; i < numsLen; i++){
            for(int j = i; j < numsLen; j++){
                int min = Math.min(nums[i], nums[j]);
                int max = Math.max(nums[i], nums[j]);
                nums[i] = min;
                nums[j] = max;
            }
        }

        return nums;
    }
}