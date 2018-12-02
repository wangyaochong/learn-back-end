package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import leetcode.base.util.UtilListNode;
import org.junit.Test;

public class p147_InsertionSortList {


    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0);
        while (head != null) {
            ListNode tmp = newHead.next;
            ListNode pre = newHead;
            while (tmp != null && head.val > tmp.val) {
                tmp = tmp.next;
                pre = pre.next;
            }
            pre.next = head;
            ListNode t = head.next;
            head.next = tmp;
            head = t;
        }
        return newHead.next;
    }


    @Test
    public void test() {
        System.out.println(insertionSortList(UtilListNode.fromArray(new int[]{4, 3, 2, 1})));
    }
}
