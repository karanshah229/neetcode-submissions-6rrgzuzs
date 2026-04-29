class MinStack {
    Deque<Integer> aq;
    Deque<Integer> minStack;

    public MinStack() {
        aq = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        aq.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = aq.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return aq.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}