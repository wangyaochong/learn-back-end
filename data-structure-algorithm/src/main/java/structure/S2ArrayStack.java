package structure;

/**
 * 是一个环形的queue，操作简单
 */
public class S2ArrayStack {
    int front;
    int[] data;

    public S2ArrayStack(int currentSize) {
        data = new int[currentSize];
        front = -1;
    }

    public boolean push(int num) {
        if (front >= data.length - 1) {
            return false;
        }
        front++;
        data[front] = num;
        return true;
    }

    public int pop() {
        if (front < 0) {
            System.out.println("没有数据");
            return -1;
        }
        int result = data[front];
        front--;
        return result;
    }

    public static void main(String[] args) {
        S2ArrayStack queue = new S2ArrayStack(5);
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
