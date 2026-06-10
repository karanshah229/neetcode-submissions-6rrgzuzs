class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int n = nums.length;

        int i = 0;
        int l = 0;
        int r = 0;
        while(l != nums1.length && r != nums2.length){
            if(nums1[l] < nums2[r]){
                nums[i++] = nums1[l++];
            } else nums[i++] = nums2[r++];
        }

        while(l != nums1.length){
            nums[i++] = nums1[l++];
        }
        while(r != nums2.length){
            nums[i++] = nums2[r++];
        }

        if(n % 2 == 0){
            return ((double)nums[n / 2] + nums[n / 2 - 1]) / 2;
        } else return nums[n / 2];
    }
}
