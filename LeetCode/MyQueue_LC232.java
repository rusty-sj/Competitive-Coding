// Time Complexity :
// push()- O(1); pop()- worst: O(N) best: O(1); peek()- O(1); empty: O(1)

// Space Complexity :
// O (N + N) two stacks

import java.util.Stack;

class MyQueue_LC232 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;

    /**
     * Initialize Queue with two stacks
     */
    public MyQueue_LC232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack1.isEmpty())
            front = x;
        stack1.push(x);             // Push element on stack1 with O(1)
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());  // Reverse stack1 into stack2
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.isEmpty())          // If stack2 isn't empty, front element is in stack2
            return stack2.peek();
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty(); // When both stacks are empty, queue is empty
    }
}