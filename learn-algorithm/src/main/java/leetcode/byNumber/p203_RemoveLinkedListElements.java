package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;
import util.UtilListNode;

public class p203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        ListNode newHead = pre;
        pre.next = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

    @Test
    public void test() {
        ListNode listNode = removeElements(UtilListNode.fromArray(new int[]{1, 2, 3, 5, 5, 5, 5, 3, 2, 1}), 5);
        System.out.println(listNode);
    }
}
