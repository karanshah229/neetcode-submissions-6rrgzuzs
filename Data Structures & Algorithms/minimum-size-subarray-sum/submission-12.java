class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while(j < nums.length){
            sum += nums[j];

            System.out.println(sum);

            if(sum >= target){
                result = Math.min(result, j-i+1);
                
                // Increase i till you get invalid subarray
                while(i <= j && sum >= target){
                    sum -= nums[i];
                    i++;
                    System.out.println(sum + " - " + i + " - " + j);
                    if(sum >= target) result = Math.min(result, j-i+1);
                }
            }

            j++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}