package leetcode.byCategory.链表;

import leetcode.base.definition.ListNode;
import org.junit.Test;
import util.UtilListNode;

public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tmp = head;
        while (l1 != null || l2 != null) {
            if (l2 == null || l1 != null && l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;

            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode listNode = UtilListNode.fromArray(new int[]{1, 3, 5});
        ListNode listNode2 = UtilListNode.fromArray(new int[]{2, 4, 6});
        System.out.println(mergeTwoLists(listNode, listNode2));
    }
}
