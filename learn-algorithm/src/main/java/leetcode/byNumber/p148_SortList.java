package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import leetcode.base.util.UtilListNode;
import org.junit.Test;

public class p148_SortList {


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        head = sortList(head);
        slow = sortList(slow);
        return merge(head, slow);
    }

    public ListNode merge(ListNode s1, ListNode s2) {
        ListNode listNode = new ListNode(0);
        ListNode tmp = listNode;
        while (s1 != null || s2 != null) {
            if (s2 == null || (s1 != null && s1.val < s2.val)) {
                tmp.next = s1;
                s1 = s1.next;
            } else {
                tmp.next = s2;
                s2 = s2.next;
            }
            tmp = tmp.next;
        }
        return listNode.next;
    }

    @Test
    public void test() {
        System.out.println(sortList(UtilListNode.fromArray(new int[]{1, 3, 2, 4})));
    }
}
