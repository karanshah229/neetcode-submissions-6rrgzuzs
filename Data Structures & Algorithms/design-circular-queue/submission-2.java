class ListNode {
    int value;
    ListNode next;
    ListNode prev;

    ListNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class MyCircularQueue {
    private int size;
    private int capacity;
    private ListNode front;
    private ListNode rear;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        this.front = null;
        this.rear = null;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;

        ListNode node = new ListNode(value);

        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }

        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }

        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : front.value;
    }
    
    public int Rear() {
        return isEmpty() ? -1 : rear.value;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */