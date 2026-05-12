class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            int ele = nums[mid];
            
            if(ele == target) return mid;
            if(ele < target) {
                low = mid + 1;
                continue;
            } else {
                high = mid - 1;
                continue;
            }
        }

        return index;
    }
}
