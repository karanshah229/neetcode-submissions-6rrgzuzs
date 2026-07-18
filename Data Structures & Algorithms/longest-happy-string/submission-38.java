public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if(a > 0) pq.add(new int[]{((int)'a'), a});
        if(b > 0) pq.add(new int[]{((int)'b'), b});
        if(c > 0) pq.add(new int[]{((int)'c'), c});

        String res = "";
        while(!pq.isEmpty()){
            System.out.println(res);
            int[] ele = pq.poll();
            if(res.length() > 1 && res.charAt(res.length() - 1) == ele[0] && res.charAt(res.length() - 2) == ele[0]){
                if(!pq.isEmpty()) {
                    int[] temp = ele;
                    ele = pq.poll();
                    pq.add(temp);
                } else continue;
            }

            res += String.valueOf((char) ele[0]);
            ele[1]--;
            if(ele[1] > 0) pq.add(ele);
        }

        return res;
    }
}
