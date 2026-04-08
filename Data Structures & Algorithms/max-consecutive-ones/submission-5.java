class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxResult = 0;
        int result = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                result++;
            } else {
                maxResult = Math.max(result, maxResult);
                result = 0;
            }
        }
        
        maxResult = Math.max(result, maxResult);
        return maxResult;
    }
}