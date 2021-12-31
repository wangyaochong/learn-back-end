package leetcode.byNumber;

import java.util.Stack;

public class p232_ImplementQueueusingStacks_Copy {

    /**
     * Initialize your data structure here.
     */
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public p232_ImplementQueueusingStacks_Copy() {

    }

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
        return in.isEmpty() && out.empty();
    }

}
