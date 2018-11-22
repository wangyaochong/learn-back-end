package leetcode;

import leetcode.base.ListNode;
import leetcode.util.UtilListNode;
import org.junit.Test;

public class p61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode myHead;
        ListNode nodeFast = head;
        ListNode nodeSlow = head;
        int i = 0;
        while (i < k) {
            nodeFast = nodeFast.next;
            if (nodeFast == null) {
                i++;
                nodeFast = head;
                k = (k % i);
                i = 0;
                while (i < k) {
                    nodeFast = nodeFast.next;
                    i++;
                }
            }
            i++;
        }
        if (nodeFast == nodeSlow) {
            return head;
        }
        while (nodeFast.next != null) {
            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next;
        }
        myHead = nodeSlow.next;
        nodeSlow.next = null;
        nodeFast.next = head;
        return myHead;
    }

    @Test
    public void test() {
        System.out.println(rotateRight(UtilListNode.fromArray(new int[]{1, 2}), 5));
    }

}
