class Solution {
    public int countElements(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int a: arr) hm.put(a, hm.getOrDefault(a, 0) + 1);
        
        int res = 0;
        for(int a: arr) {
            if(hm.getOrDefault(a + 1, 0) != 0) {
                res++;
            }
        }

        return res;
    }
}
