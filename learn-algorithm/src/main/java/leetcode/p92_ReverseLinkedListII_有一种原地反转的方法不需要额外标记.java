package leetcode;

import leetcode.base.ListNode;
import leetcode.util.UtilListNode;
import org.junit.Test;

public class p92_ReverseLinkedListII_有一种原地反转的方法不需要额外标记 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode myHead = new ListNode(0);
        myHead.next = head;

        ListNode pre = null;
        ListNode reverseTail = null;
        ListNode preTail = myHead;
        ListNode next = head.next;

        int count = 1;
        while (count < m) {
            preTail = preTail.next;
            next = next.next;
            head = head.next;
            count++;
        }
        reverseTail = head;
        while (count <= n) {
            head.next = pre;
            pre = head;
            head = next;
            if (head != null) {
                next = head.next;
            }
            count++;
        }
        reverseTail.next = head;
        preTail.next = pre;
        return myHead.next;
    }

    public ListNode reverse(ListNode listNode) {
        ListNode pre = null;
        ListNode next = listNode.next;
        while (listNode.next != null) {
            listNode.next = pre;
            pre = listNode;
            listNode = next;
            next = listNode.next;
        }
        listNode.next = pre;
        return listNode;
    }

    @Test
    public void test() {
        System.out.println(reverseBetween(UtilListNode.fromArray(new int[]{1}), 1, 1));
    }


}
