class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer[]> aq = new ArrayDeque<Integer[]>();
        int[] result = new int[temperatures.length];

        // for(int res: result) res = 0;

        int index = 0;
        for(int temp: temperatures){
            while(!aq.isEmpty() && temp > aq.peek()[0]){
                // pop pairs till you get a larger pair
                // for each popped pair - update result with index - pair[1]
                Integer[] popped = aq.pop();
                result[popped[1]] = index - popped[1];
            }
            aq.push(new Integer[]{temp, index});
            index++;
        }

        return result;
    }
}
