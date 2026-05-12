class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        if(result < 0){
            return Math.abs(result + 1);
        } else return result;
    }
}