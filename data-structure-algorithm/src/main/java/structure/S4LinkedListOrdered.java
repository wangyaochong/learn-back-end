package structure;


/**
 * 插入顺序和读取顺序相同
 */
public class S4LinkedListOrdered {
    S4LinkedListOrdered head = null;
    S4LinkedListOrdered next = null;
    S4LinkedListOrdered tail = null;
    int value;


    public void add(int value) {
        S4LinkedListOrdered next = new S4LinkedListOrdered();
        next.value = value;
        if (head == null) {
            head = new S4LinkedListOrdered();
            tail = next;
            head.next = next;
        } else {
            tail.next = next;
            tail = next;
        }
    }

    public void display() {
        S4LinkedListOrdered tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.println(tmp.value);
        }
    }

    public static void main(String[] args) {
        S4LinkedListOrdered linkedList = new S4LinkedListOrdered();
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.display();
    }
}
