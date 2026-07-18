class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        for(int[] trip: trips) if(trip[0] > capacity) return false;

        Queue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if(x[1] == y[1]) return x[2] - y[2];
            return x[1] - y[1];
        });
        for(int[] trip: trips) pq.add(trip);
        
        Queue<int[]> pq2 = new PriorityQueue<>((x, y) -> {
            if(x[2] == y[2]) return x[1] - y[1];
            return x[2] - y[2];
        });
        for(int[] trip: trips) pq2.add(trip);

        int curr = -1;
        int cap = 0;
        while(!pq.isEmpty()){
            curr++;

            while(!pq.isEmpty() && pq.peek()[1] == curr){
                int[] trip = pq.poll();
                cap += trip[0];
            }

            while(!pq2.isEmpty() && pq2.peek()[2] == curr){
                int[] trip = pq2.poll();
                cap -= trip[0];
            }

            System.out.println(curr + " - " + cap);
            if(cap > capacity) return false;
        }

        return true;
    }
}