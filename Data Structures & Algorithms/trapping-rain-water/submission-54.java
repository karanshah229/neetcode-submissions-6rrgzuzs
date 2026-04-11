class Solution {
    public int trap(int[] height) {
        int l = 0;

        int result = 0;

        while(height[l] <= 0 && l < height.length - 1){
            l++;
        }

        int r = l+1;
        
        while(r < height.length && l < r){
            int localResult = 0;

            while(r < height.length) {
                if(height[r] >= height[l]){
                    // ending bar - don't add
                    result += localResult;
                    break;
                }
                
                localResult += (height[l] - height[r]);
                r++;
            };

            if(r == height.length){
                // go through this part again
                // calculate bestR and bestL configuration
                
                int bestR = l + 1;
                for (int x = l + 1; x < r; x++) {
                    if (height[x] > height[bestR]) {
                        bestR = x;
                    }
                }

                int fallback = 0;
                for (int x = l + 1; x < bestR; x++) {
                    fallback += (height[bestR] - height[x]);
                }

                result += fallback;

                l = bestR;
                r = l + 1;
                continue;
            }
            
            l = r;
            r++;

        }

        return result;
    }
}
