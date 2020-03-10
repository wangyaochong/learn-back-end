package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;

public class p21_MergeTwoSortedLists {
    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode result = mergeTwoLists(listNode, listNode4);
        System.out.println(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        ListNode tmp;
        while (l1 != null || l2 != null) {
            cur.next = new ListNode(0);
            if (l1 == null) {
                tmp = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                tmp = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    tmp = l1;
                    l1 = l1.next;
                } else {
                    tmp = l2;
                    l2 = l2.next;
                }
            }
            cur.next.val = tmp.val;
            cur = cur.next;
        }
        return result.next;
    }
}
