class Solution {
    static List<List<Integer>> twoSum(int[] numbers, int i, long target) {
        int j = numbers.length - 1;

        List<List<Integer>> result = new ArrayList<>();
        while(i < j){
            long sum = (long)numbers[i] + numbers[j];

            if(sum == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(numbers[i]);
                pair.add(numbers[j]);
                result.add(pair);
                
                while (i < j && numbers[i] == numbers[i + 1]) i++;
                while (i < j && numbers[j] == numbers[j - 1]) j--;
                i++;
                j--;
            } else if(sum > target){
                j--;
            } else i++;
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, long target) {
        List<List<Integer>> result = new ArrayList<>();

        for(int x = start; x < nums.length - 2; x++){
            if (x > start && nums[x] == nums[x - 1]) continue;
            int num = nums[x];
            long diff = target - num;
            List<List<Integer>> pairs = twoSum(nums, x+1, diff);

            for (List<Integer> pair : pairs) {
                pair.add(num);
                result.add(pair);
            }
            
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();

        for(int y = 0; y < nums.length - 3; y++){
            if (y > 0 && nums[y] == nums[y - 1]) continue;
            int num = nums[y];
            long diff = (long)target - num;
            List<List<Integer>> pairs = threeSum(nums, y+1, diff);

            for (List<Integer> pair : pairs) {
                pair.add(num);
                result.add(pair);
            }
        }

        return result;
    }
}