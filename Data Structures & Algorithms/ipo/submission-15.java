class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> capitalQ = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        Queue<int[]> profitQ = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        for(int i = 0; i < profits.length; i++){
            int profit = profits[i];
            int cap = capital[i];

            capitalQ.add(new int[]{cap, profit});
        }

        // for(int[] c: capitalQ) System.out.println(Arrays.toString(c));

        int prevCap = 0;
        int currCap = w;
        while(k-- > 0){
            while(!capitalQ.isEmpty() && capitalQ.peek()[0] <= currCap){
                profitQ.add(capitalQ.poll());
            }

            if(profitQ.isEmpty()) return w;

            // System.out.println("profitQ");
            // for(int[] c: profitQ) System.out.println(Arrays.toString(c));

            currCap += profitQ.poll()[1];
        }

        return currCap;
    }
}
