class Pair {
    int value;
    int prevMin;
    
    public Pair(int value, int prevMin) {
        this.value = value;
        this.prevMin = prevMin;
    }
}
class MinStack {

    Stack<Pair> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (this.minStack.isEmpty()) {
            this.minStack.push(new Pair(val, Integer.MAX_VALUE));
        } else {
            Pair top = this.minStack.peek();
            int nextMin = Math.min(top.value, top.prevMin);
            this.minStack.push(new Pair(val, nextMin));
        }
    }
    
    public void pop() {
        this.minStack.pop();
    }
    
    public int top() {
        return this.minStack.peek().value;
    }
    
    public int getMin() {
        Pair top = this.minStack.peek();
        return Math.min(top.value, top.prevMin);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */