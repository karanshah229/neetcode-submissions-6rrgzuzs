class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) pq.offer(new int[]{0, a}); // 0 -> 'a'
        if (b > 0) pq.offer(new int[]{1, b}); // 1 -> 'b'
        if (c > 0) pq.offer(new int[]{2, c}); // 2 -> 'c'

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            char ch1 = (char) ('a' + first[0]);

            int len = res.length();
            if (len >= 2 && res.charAt(len - 1) == ch1 && res.charAt(len - 2) == ch1) {
                if (pq.isEmpty()) break;

                int[] second = pq.poll();
                char ch2 = (char) ('a' + second[0]);
                res.append(ch2);
                second[1]--;

                if (second[1] > 0) pq.offer(second);
                pq.offer(first);
            } else {
                res.append(ch1);
                first[1]--;
                if (first[1] > 0) pq.offer(first);
            }
        }

        return res.toString();
    }
}