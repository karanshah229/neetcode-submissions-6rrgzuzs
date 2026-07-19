class Solution {
    static Map<Integer, Integer> hm = new HashMap<>();

    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;

        int minus1, minus2;
        
        if(hm.containsKey(n-1)) minus1 = hm.get(n-1);
        else {
            hm.put(n-1, climbStairs(n-1));
            minus1 = hm.get(n-1);
        }
        
        if(hm.containsKey(n-2)) minus2 = hm.get(n-2);
        else {
            hm.put(n-2, climbStairs(n-2));
            minus2 = hm.get(n-2);
        }

        return minus1 + minus2;
    }
}
