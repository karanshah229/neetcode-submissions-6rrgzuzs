class Solution {
    class Node {
        char task;
        int count;

        public Node(char task, int count) {
            this.task = task;
            this.count = count;
        }
    }

    class QElem {
        char task;
        int count;
        int nextAvailableOn;

        public QElem(char task, int count, int nextAvailableOn) {
            this.task = task;
            this.count = count;
            this.nextAvailableOn = nextAvailableOn;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> hm = new HashMap<>();
        Queue<Node> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        Queue<QElem> aq = new ArrayDeque<>();
        List<Character> res = new ArrayList<>();

        for (char task : tasks) hm.put(task, hm.getOrDefault(task, 0) + 1);
        hm.forEach((k, v) -> { pq.add(new Node(k, v)); });

        int time = 0;
        while (!pq.isEmpty() || !aq.isEmpty()) {
            time++;

            if (!aq.isEmpty()) {
                if(pq.isEmpty()){
                    QElem el = aq.remove();
                    pq.add(new Node(el.task, el.count));
                    time = el.nextAvailableOn;
                } else if (aq.peek().nextAvailableOn <= time) {
                    QElem el = aq.remove();
                    pq.add(new Node(el.task, el.count));
                }
            }

            System.out.println(!pq.isEmpty() ? pq.peek().task : null);
            Node item = pq.poll();
            res.add(item.task);
            item.count--;
            if (item.count > 0) {
                aq.add(new QElem(item.task, item.count, time + n + 1));
            }
        }

        System.out.println(res.toString());

        return time;
    }
}
