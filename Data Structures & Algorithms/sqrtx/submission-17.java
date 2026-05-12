class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        if(x > 4) high = x / 2;
        int result = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            long square = (long)mid * mid;

            if(square == x) return mid;

            if(square > x){
                high = mid - 1;
                continue;
            }

            if(square < x){
                result = mid;
                low = mid + 1;
                continue;
            }
        }

        return result;
    }
}