package structure;

/**
 * 插入元素会逆序
 */
public class S3LinkedListReversed {
    S3LinkedListReversed head = null;
    S3LinkedListReversed next = null;
    int value;

    public void add(int value) {
        if (head == null) {
            head = new S3LinkedListReversed();
        }
        S3LinkedListReversed next = new S3LinkedListReversed();
        next.next = head.next;
        head.next = next;
        next.value = value;
    }

    public void remove(int value) {
        S3LinkedListReversed node = head.next;
        S3LinkedListReversed pre = head;
        while (node != null && node.value != value) {
            node = node.next;
            pre = pre.next;
        }
        pre.next = node.next;
        node.next = null;
    }

    public void display() {
        S3LinkedListReversed tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.println(tmp.value);
        }
    }

    public static void main(String[] args) {
        S3LinkedListReversed linkedList = new S3LinkedListReversed();
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.display();
        System.out.println("-------进行删除操作-------");
        linkedList.remove(4);
        linkedList.display();


    }
}
