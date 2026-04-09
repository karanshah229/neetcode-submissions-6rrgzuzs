class Solution {
    static List<List<Integer>> twoSum(int[] numbers, int i, int target) {
        int j = numbers.length - 1;

        List<List<Integer>> result = new ArrayList<>();
        while(i < j){
            int sum = numbers[i] + numbers[j];


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

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int target = 0;
        for(int x = 0; x < nums.length - 2; x++){
            if (x > 0 && nums[x] == nums[x - 1]) continue;
            int num = nums[x];
            int diff = target - num;
            List<List<Integer>> pairs = twoSum(nums, x+1, (int)diff);

            for (List<Integer> pair : pairs) {
                pair.add(num);
                result.add(pair);
            }
        }

        return result;
    }
}
