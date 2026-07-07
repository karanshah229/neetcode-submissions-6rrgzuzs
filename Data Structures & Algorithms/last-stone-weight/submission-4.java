class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length < 2) return stones[0];
        Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int stone: stones){
            pq.add(stone);
        }

        System.out.println(pq);

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            int diff = Math.abs(x - y);

            if(diff != 0) pq.add(diff);
        }

        System.out.println(pq);

        int res = pq.peek() == null ? 0 : pq.poll();
        return res;
    }
}
