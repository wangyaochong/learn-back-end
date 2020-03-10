package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;
import util.UtilListNode;

public class p82_RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode pre = listNode;
        ListNode cur = listNode.next;
        boolean sameFlag = false;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                sameFlag = true;
            }
            if (sameFlag) {//本轮处理完，sameFlag置为false
                pre.next = cur.next;
                sameFlag = false;
            } else {
                pre = pre.next;//如果不是重复，则前一个指针移动
            }
            cur = cur.next;
        }
        return listNode.next;
    }

    @Test
    public void test() {
        System.out.println(deleteDuplicates(UtilListNode.fromArray(new int[]{1, 2, 3, 3, 4, 4, 5})));
        System.out.println(deleteDuplicates(UtilListNode.fromArray(new int[]{0, 1, 1, 1, 2, 2, 3, 3, 4})));
        System.out.println(deleteDuplicates(UtilListNode.fromArray(new int[]{1, 1, 1, 2, 3})));

    }
}
