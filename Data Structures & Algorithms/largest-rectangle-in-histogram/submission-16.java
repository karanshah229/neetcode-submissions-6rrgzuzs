class Solution {
    public int largestRectangleArea(int[] heights) {
        // 2 key observations
        // 1. Looping from left to right so if curr is smaller than prev then we need to do some calc
        // Calc: Keep popping prev and compute area from prev till curr and store if max
        // 2. Storing all increasing heights in a stack ensures that we don't miss combinations like:
        // (1, 6) - 6 units of height 1

        // Reason to use stack - needed a history of all combinations

        Deque<int[]> aq = new ArrayDeque<>();
        int result = 0;

        for(int i = 0; i <= heights.length; i++){
            int curr = (i == heights.length) ? 0 : heights[i];
            int start = i;
            while(!aq.isEmpty() && aq.peek()[0] > curr){
                int[] top = aq.pop();
                result = Math.max(result, top[0] * (i - top[1]));
                start = top[1];
            }
            if (aq.isEmpty() || aq.peek()[0] < curr) {
                aq.push(new int[]{curr, start});
            }
        }

        return result;
    }
}