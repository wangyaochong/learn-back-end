package leetcode.byNumber;

import java.util.ArrayDeque;
import java.util.Queue;

public class p225_ImplementStackUsingQueues {
    public void MyStack() {
    }

    /**
     * Initialize your data structure here.
     */
    private Queue<Object> inQueue = new ArrayDeque<>();

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        inQueue = new ArrayDeque<Object>() {{
            add(x);
            add(inQueue);
        }};
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int poll = (int) inQueue.poll();
        inQueue = (Queue<Object>) inQueue.poll();
        return poll;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return (int) inQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return inQueue.isEmpty();
    }

    public static void main(String[] args) {
        p225_ImplementStackUsingQueues p = new p225_ImplementStackUsingQueues();
        p.push(1);
        p.push(2);
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.empty());
    }
}


