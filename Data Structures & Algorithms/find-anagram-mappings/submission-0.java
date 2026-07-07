class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int i = 0;
        for(int num: nums2){
            hm.putIfAbsent(num, i++);
        }

        int[] res = new int[nums1.length];

        i = 0;
        for(int num: nums1){
            res[i++] = hm.getOrDefault(num, -1);
        }

        return res;
    }
}
