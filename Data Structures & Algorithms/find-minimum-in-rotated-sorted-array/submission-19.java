class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int result = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            result = Math.min(result, nums[mid]);
            
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}