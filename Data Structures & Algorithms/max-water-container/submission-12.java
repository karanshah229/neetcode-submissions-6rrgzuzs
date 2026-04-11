class Solution {
    public int maxArea(int[] heights) {
        int result = 0;

        int l = 0;
        int r = heights.length - 1;

        while(l < r){
            int localResult = Math.min(heights[r], heights[l]) * (r - l);
            result = Math.max(result, localResult);

            if(heights[r] < heights[l]) r--;
            else l++;
        }

        return result;
    }
}
