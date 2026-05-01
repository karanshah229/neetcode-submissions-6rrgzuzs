class FreqStack {
    private Map<Integer, Integer> freq;
    private Map<Integer, Deque<Integer>> buckets;
    private int maxBucketSize;

    public FreqStack() {
        freq = new HashMap<>();
        buckets = new HashMap<>();
        maxBucketSize = 0;
    }
    
    public void push(int val) {
        int bucketSize = freq.getOrDefault(val, 0) + 1;
        System.out.println(val + " : " + bucketSize);
        freq.put(val, bucketSize);
        maxBucketSize = Math.max(bucketSize, maxBucketSize);
        
        Deque<Integer> aq = buckets.getOrDefault(bucketSize, new ArrayDeque<Integer>());
        aq.push(val);
        buckets.put(bucketSize, aq);
    }
    
    public int pop() {
        Deque<Integer> aq = buckets.get(maxBucketSize);
        int popped = aq.pop();
        freq.put(popped, freq.get(popped) - 1);
        System.out.println(maxBucketSize + " -> maxBucketSize | popped = " + popped);
        if(aq.isEmpty()) maxBucketSize--;


        return popped;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */