class Task {
    int enqueueTime;
    int processingTime;
    int index;

    public Task(int enqueueTime, int processingTime, int index) {
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
        this.index = index;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        Queue<Task> pq = new PriorityQueue<>((a, b) -> {
            if (a.enqueueTime != b.enqueueTime) {
                return Integer.compare(a.enqueueTime, b.enqueueTime);
            } else if (a.processingTime != b.processingTime) {
                return Integer.compare(a.processingTime, b.processingTime);
            } else {
                return Integer.compare(a.index, b.index);
            }
        });

        Queue<Task> available = new PriorityQueue<>((a, b) -> {
            if (a.processingTime != b.processingTime) {
                return Integer.compare(a.processingTime, b.processingTime);
            } else {
                return Integer.compare(a.index, b.index);
            }
        });

        int resI = 0;
        int[] res = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            pq.add(new Task(task[0], task[1], i));
        }

        long t = pq.peek().enqueueTime;

        while (!pq.isEmpty() || !available.isEmpty()) {
            while (!pq.isEmpty() && pq.peek().enqueueTime <= t) {
                available.add(pq.poll());
            }

            if (available.isEmpty()) {
                t = pq.peek().enqueueTime;
            } else {
                Task taskPicked = available.poll();
                res[resI++] = taskPicked.index;
                t += taskPicked.processingTime;
            }
        }

        return res;
    }
}