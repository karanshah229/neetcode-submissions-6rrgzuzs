class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;

        int l = Integer.MAX_VALUE;
        int r = 0;
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                if(prices[i] > r){
                    r = prices[i];
                }
                if(prices[i-1] < l){
                    l = prices[i-1];
                    r = prices[i];
                    result = Math.max(result, r-l);
                }
            }
        }

        result = Math.max(result, r-l);

        return result;
    }
}
