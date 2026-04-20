class Solution {
    public int trap(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        // for every position we can find the max left boundary and max right boundary
        // water trapped = min(lmax, rmax) - height[i]
        // however, we can get away without storing both the boundaries for all positions coz
        // we just need the min of these max(es)

        int res = 0;
        int lmax = heights[l];
        int rmax = heights[r];

        while(l < r){
            if(lmax < rmax){
                l++;
                lmax = Math.max(lmax, heights[l]);
                res += lmax - heights[l];
            } else {
                r--;
                rmax = Math.max(rmax, heights[r]);
                res += rmax - heights[r];
            }
        }

        return res;
    }
}
