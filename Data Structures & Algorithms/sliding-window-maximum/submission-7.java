class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int resLen = nums.length - k + 1;
        int[] result = new int[resLen];
        int resIndex = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // add first k elements to max heap
        for(int i = 0; i < k; i++){
            maxHeap.add(nums[i]);
        }
        result[resIndex++] = maxHeap.peek();

        // then remove first element and add new element
        for(int i = k; i < nums.length; i++){
            maxHeap.remove(nums[i-k]);
            maxHeap.add(nums[i]);
            result[resIndex++] = maxHeap.peek();
        }

        return result;
    }
}