package leetcode;

import leetcode.base.ListNode;
import leetcode.util.UtilListNode;
import org.junit.Test;

public class p24_SwapNodesinPairs {
    @Test
    public void test() {
        ListNode listNode = UtilListNode.fromArray(new int[]{1, 2, 3, 4});
        ListNode listNode1 = swapPairs(listNode);
        System.out.println(listNode1);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode curPre = s;
        while (curPre.next!=null&&curPre.next.next!=null) {
            ListNode tmp=curPre.next.next.next;
            curPre.next.next.next=curPre.next;
            curPre.next=curPre.next.next;
            curPre.next.next.next=tmp;

            curPre=curPre.next.next;
        }
        return s.next;
    }
}
