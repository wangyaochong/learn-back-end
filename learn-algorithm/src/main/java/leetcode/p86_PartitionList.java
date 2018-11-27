package leetcode;

import leetcode.base.ListNode;
import leetcode.util.UtilListNode;
import org.junit.Test;

public class p86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode partLeft = new ListNode(0);
        ListNode partRight = new ListNode(0);
        ListNode leftHead = partLeft;
        ListNode rightHead = partRight;
        while (head != null) {
            if (head.val < x) {
                partLeft.next = head;
                partLeft = partLeft.next;
            } else {
                partRight.next = head;
                partRight = partRight.next;
            }
            head = head.next;
        }
        partLeft.next = rightHead.next;
        partRight.next = null;
        return leftHead.next;
    }

    @Test
    public void test() {
        System.out.println(partition(UtilListNode.fromArray(new int[]{1, 4, 3, 2, 5, 2}), 3));
    }

}
