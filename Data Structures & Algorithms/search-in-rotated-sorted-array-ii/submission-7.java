class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + ((high-low) / 2);
            System.out.println(low + " : " + high + " : " + mid);
            if(nums[mid] == target) return true;

            while(nums[low] == nums[mid] && low < mid){
                low++;
            }

            while(nums[high] == nums[mid] && high > mid){
                high--;
            }

            // Check which side is sorted
            if (nums[low] <= nums[mid]) {
                // Left side is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // Right side is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}