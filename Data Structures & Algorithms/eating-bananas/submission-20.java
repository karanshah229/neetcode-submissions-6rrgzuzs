class Solution {
    int timeTakenToEatAllPiles(int[] piles, int rate){
        return Arrays.stream(piles).reduce(0, (total, ele) -> {
            System.out.println(ele + " : " + rate + " : " + total);
            if(ele <= rate) return total + 1;
            return total + (int) Math.ceil((double) ele / rate);
        });
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();

        int low = 0;
        int high = Math.max(h, maxPile);
        int minDuration = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + ((high-low) / 2);

            int duration = timeTakenToEatAllPiles(piles, mid);
            System.out.println(mid + " =:= " + duration);
            if(duration <= h){
                if(Math.abs(h - duration) < minDuration){
                    result = mid;
                }
                // Eating too fast, reduce high
                high = mid - 1;
            } else {
                // Eating too slow, increase low
                low = mid + 1;
            }
        }

        return result;
    }
}
