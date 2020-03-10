package leetcode.byNumber;

import java.util.Stack;

public class p232_ImplementQueueusingStacks {

    /**
     * Initialize your data structure here.
     */
    public void MyQueue() {

    }

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();


    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }
}
