class KthLargest {
    Queue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums){
            pq.add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        
        int count = k;
        List<Integer> l = new ArrayList<Integer>();
        while(count > 1){
            l.add(pq.poll());
            count--;
        }
        int ret = pq.poll();

        for(int i: l){
            pq.add(i);
        }
        pq.add(ret);

        return ret;
    }
}
