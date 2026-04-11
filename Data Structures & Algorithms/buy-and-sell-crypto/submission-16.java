class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;

        int min = Integer.MAX_VALUE;

        for(int price: prices){
            min = Math.min(min, price);
            result = Math.max(result, price - min);
        }

        return result;
    }
}
