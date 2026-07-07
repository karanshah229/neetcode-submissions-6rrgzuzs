class Solution {
    public double distance(int[] pointB) {
        int x1 = 0;
        int y1 = 0;
        int x2 = pointB[0];
        int y2 = pointB[1];

        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(distance(a), distance(b)));

        for (int[] point : points) pq.add(point);

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
