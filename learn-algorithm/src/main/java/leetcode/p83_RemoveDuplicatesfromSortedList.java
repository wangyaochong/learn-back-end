package leetcode;

import leetcode.base.ListNode;
import leetcode.util.UtilListNode;
import org.junit.Test;

public class p83_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = head;
        while (head != null) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return listNode;
    }

    @Test
    public void test() {
        System.out.println(deleteDuplicates(UtilListNode.fromArray(new int[]{1, 1, 1, 2, 3, 3})));
    }
}
