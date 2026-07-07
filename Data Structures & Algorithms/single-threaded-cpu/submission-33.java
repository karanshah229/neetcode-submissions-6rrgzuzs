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
        int resI = 0;
        int[] res = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            pq.add(new Task(task[0], task[1], i));
        }

        long t = pq.peek().enqueueTime;
        Task taskPicked = pq.poll();
        t += taskPicked.processingTime;
        res[resI++] = taskPicked.index;

        while (pq.size() > 0) {
            List<Task> polled = new ArrayList<>();
            Task selectedTask = new Task(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

            while (pq.size() > 0 && pq.peek().enqueueTime <= t) {
                Task task = pq.poll();
                polled.add(task);
                if (task.processingTime < selectedTask.processingTime
                    || (task.processingTime == selectedTask.processingTime
                        && task.index < selectedTask.index)) {
                    selectedTask = task;
                }
            }

            if (selectedTask.index != Integer.MAX_VALUE) {
                res[resI++] = selectedTask.index;
                t += selectedTask.processingTime;
            } else
                t = pq.peek().enqueueTime;

            for (Task task : polled) {
                if (task.index != selectedTask.index)
                    pq.add(task);
            }
        }

        return res;
    }
}