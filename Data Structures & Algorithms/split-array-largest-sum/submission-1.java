class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0;
        int subarrays = 1;
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;
                if (subarrays > k) return false;
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}