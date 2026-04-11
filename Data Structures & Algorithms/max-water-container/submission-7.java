class Solution {
    public int maxArea(int[] heights) {
        int result = 0;

        for(int i = 0; i < heights.length; i++){
            for(int j = i + 1; j < heights.length; j++){
                int localResult = Math.min(heights[j], heights[i]) * (j-i);
                if(localResult > result){
                    result = localResult;
                    System.out.println(heights[i] + ":" + heights[j]);
                }
            }
        }

        return result;
    }
}
