class Solution {
    public int trap(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        // for every position we can find the max left boundary and max right boundary
        // water trapped = min(lmax, rmax) - height[i]

        int lmax = 0;
        HashMap<Integer, Integer> lhm = new HashMap<>();
        for(int i = 0; i < heights.length; i++){
            int height = heights[i];
            
            if(i == 0) lhm.put(i, 0);
            else {
                lmax = Math.max(lmax, heights[i-1]);
                lhm.put(i, lmax);
            }
        }
        
        int rmax = 0;
        HashMap<Integer, Integer> rhm = new HashMap<>();
        for(int i = heights.length-1; i >= 0; i--){
            int height = heights[i];
            
            if(i == heights.length-1) rhm.put(i, 0);
            else {
                rmax = Math.max(rmax, heights[i+1]);
                rhm.put(i, rmax);
            }
        }

        int res = 0;
        for(int i = 0; i < heights.length; i++){
            int height = heights[i];
            int left = lhm.get(i);
            int right = rhm.get(i);

            System.out.println(height + " : " + left + " : " + right + " : " + (Math.min(left, right) - height));

            res += Math.max(0, Math.min(left, right) - height);
        }

        return res;
    }
}
