class MyQueue {
    Deque<Integer> aq;

    public MyQueue() {
        aq = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        aq.push(x);
    }
    
    public int pop() {
        return aq.removeLast();
    }
    
    public int peek() {
        return aq.peekLast();
    }
    
    public boolean empty() {
        return aq.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */