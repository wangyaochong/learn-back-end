package structure;

/**
 * 是一个环形的queue，操作简单
 */
public class S2ArrayQueue {
    int currentSize;
    int front;
    int[] data;

    public S2ArrayQueue(int currentSize) {
        this.currentSize = 0;
        data = new int[currentSize];
        front = 0;
    }

    public boolean push(int num) {
        if (currentSize >= data.length) {
            return false;
        }
        data[(front + currentSize) % data.length] = num;
        currentSize++;
        return true;
    }

    public int pop() {
        if (currentSize <= 0) {
            throw new RuntimeException("没有数据");
        }
        int result = data[front];
        front = (front + 1) % data.length;
        currentSize--;
        return result;
    }

    public static void main(String[] args) {
        S2ArrayQueue queue = new S2ArrayQueue(5);
        System.out.println(queue.push(1));
        System.out.println(queue.push(2));
        System.out.println(queue.push(3));
        System.out.println(queue.push(4));
        System.out.println(queue.push(5));
        System.out.println(queue.push(6));
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
