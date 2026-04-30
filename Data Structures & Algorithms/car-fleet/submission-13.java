class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Integer> aq = new ArrayDeque<>();

        int posLen = position.length;
        Integer[] posInd = new Integer[posLen];
        for(int i = 0; i < posLen; i++) posInd[i] = i;
        Arrays.sort(posInd, (a, b) -> Integer.valueOf(position[b]).compareTo(position[a]));

        for(int ind: posInd){
            if(aq.isEmpty()) aq.push(ind);
            else {
                int headInd = aq.peek();
                
                double timeToTargetHead = (double)(target - position[headInd]) / speed[headInd];
                double timeToTargetCurr = (double)(target - position[ind]) / speed[ind];
                
                boolean doesCurrCatchup = timeToTargetCurr <= timeToTargetHead;
                
                if(!doesCurrCatchup) {
                    aq.push(ind);
                }
            }
        }

        return aq.size();
    }
}