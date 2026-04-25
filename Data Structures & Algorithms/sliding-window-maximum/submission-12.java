class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int resLen = nums.length - k + 1;
        int[] result = new int[resLen];
        int resIndex = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hm = new HashMap<>();

        // add first k elements to max heap
        for(int i = 0; i < k; i++){
            maxHeap.add(nums[i]);
            // Set<Integer> defaultS = new Set<>();
            // hm.put(hm.getOrDefault(nums[i], defaultS).add(i));
            hm.put(nums[i], i);
        }
        result[resIndex++] = maxHeap.peek();

        // then remove first element and add new element
        for(int i = k; i < nums.length; i++){
            // instead of removing, let's peek and check if the element
            // exists in the current range
            // if not, keep polling to remove the max element - update the hashmap
            // till you reach an element present in the current range
            // maxHeap.remove(nums[i-k]);
            
            maxHeap.add(nums[i]);
            hm.put(nums[i], i);

            int max = maxHeap.peek();
            while(hm.get(max) <= i - k){
                maxHeap.poll();
                max = maxHeap.peek();
            }

            result[resIndex++] = max;
        }

        return result;
    }
}