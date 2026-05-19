class Solution {
    boolean getIsValidShipWeight(int[] weights, int days, int shipWeight){
        int d = 1;
        int dWeight = 0;
        
        for(int i = 0; i < weights.length; i++){
            int weight = weights[i];
            dWeight += weight;
            
            if(dWeight > shipWeight) {
                d++;
                dWeight = weight;
            }
        }

        if(d <= days) return true;
        return false;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sumWeights = Arrays.stream(weights).reduce(0, (total, ele) -> total + ele);
        int maxWeight = Arrays.stream(weights).max().getAsInt();

        int low = maxWeight;
        int high = sumWeights;
        int result = Integer.MAX_VALUE;

        while(low <= high){
            int shipWeight = low + ((high-low) / 2);
            
            boolean isValidShipWeight = getIsValidShipWeight(weights, days, shipWeight);
            System.out.println(shipWeight + " : " + isValidShipWeight);

            if(isValidShipWeight){
                result = Math.min(result, shipWeight);
                high = shipWeight - 1;
            } else {
                low = shipWeight + 1;
            }
        }

        return result;
    }
}