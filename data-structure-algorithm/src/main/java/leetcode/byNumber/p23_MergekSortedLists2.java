package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;
import util.UtilListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p23_MergekSortedLists2 {
    @Test
    public void test() {
        ListNode listNode = UtilListNode.fromArray(new int[]{1, 2, 3});
        ListNode listNode2 = UtilListNode.fromArray(new int[]{1, 1, 3});
        ListNode listNode3 = UtilListNode.fromArray(new int[]{1, 2, 4});
        System.out.println(mergeKLists(new ListNode[]{listNode, listNode2, listNode3}));
    }


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode head = new ListNode();
        ListNode cur = head;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) {
                queue.add(poll.next);
            }
        }
        return head.next;
    }

}
