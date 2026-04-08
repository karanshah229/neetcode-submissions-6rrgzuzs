class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) countMap.put(n, countMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> countMap.get(a) - countMap.get(b)
        );

        for (int n : countMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        int[] result = new int[k];
        int i = 0;
        while(!heap.isEmpty()){
            result[i++] = heap.poll();
        }
        
        return result;
    }
}
