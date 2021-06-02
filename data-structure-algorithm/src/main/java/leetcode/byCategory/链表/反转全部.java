package leetcode.byCategory.链表;

import leetcode.base.definition.ListNode;
import org.junit.Test;


/**
 * 其实就等同于使用反转形式插入链表
 * [1 2 3 4 5]
 * []
 * <p>
 * [2 3 4 5]
 * [1]
 * <p>
 * [3 4 5]
 * [2 1]
 * <p>
 * [4 5]
 * [3 2 1]
 */
public class 反转全部 {
    public ListNode reverseList(ListNode head) {
        ListNode retHead = new ListNode();
        ListNode tmp;
        while (head != null) {
            tmp = head.next;
            head.next = retHead.next;
            retHead.next = head;
            head = tmp;
        }
        return retHead.next;
    }


    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode();
        ListNode current = head;
        while (current != null) {
            head = head.next;
            current.next=dummy.next;
            dummy.next=current;
            current = head;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode node = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node.val = 1;
        node2.val = 2;
        node3.val = 3;
        node.next = node2;
        node2.next = node3;
        System.out.println(reverse(node));
    }
}
