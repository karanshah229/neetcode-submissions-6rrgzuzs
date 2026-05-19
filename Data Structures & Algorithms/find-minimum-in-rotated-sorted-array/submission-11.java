class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int result = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + ((high - low) / 2);
            int ele = nums[mid];
            result = Math.min(result, ele);
            
            if(nums[mid] >= nums[low]){
                if (nums[low] <= nums[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            };
        }

        return result;
    }
}
