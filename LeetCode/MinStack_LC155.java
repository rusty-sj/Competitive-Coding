// Time Complexity
// push(x), pop(), top(), getMin(): O(1)

// Space Complexity
// Worst case O(2N)

import java.util.Stack;

/**
 * Use only one stack to keep track of both push elements and minimum at each stage of stack
 *
 * When a new element is to be pushed, if it is smaller than minimum, push the minimum upto that point on stack,
 * update minimum and then push actual element
 *
 * While popping, if popped element is equal to minimum, pop again
 */
class MinStack_LC155 {

    private Stack<Integer> stack;
    private int minimum;

    /**
     * initialize your data structure here.
     */
    public MinStack_LC155() {
        stack = new Stack<>();
        minimum = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= minimum) {
            stack.push(minimum);
            minimum = x;
        }
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (x == minimum) {
            minimum = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimum;
    }
}