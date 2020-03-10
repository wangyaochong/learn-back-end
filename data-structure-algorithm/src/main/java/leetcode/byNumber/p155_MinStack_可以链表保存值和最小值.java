package leetcode.byNumber;

public class p155_MinStack_可以链表保存值和最小值 {

    int[] minArray = new int[1000];
    int[] data = new int[1000];
    int size = 0;

    public p155_MinStack_可以链表保存值和最小值() {
        minArray[0] = Integer.MAX_VALUE;
    }

    public void push(int x) {
        data[size] = x;
        if (x < minArray[size]) {
            minArray[size + 1] = x;
        } else {
            minArray[size + 1] = minArray[size];
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return minArray[size];
    }
}
