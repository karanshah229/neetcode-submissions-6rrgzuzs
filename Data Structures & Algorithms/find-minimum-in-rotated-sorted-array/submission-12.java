class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                // min is to the right of mid
                low = mid + 1;
            } else {
                // min is at mid or to the left
                high = mid;
            }
        }

        return nums[low];
    }
}