package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;
import util.UtilListNode;

import java.util.ArrayList;
import java.util.List;

public class p143_ReorderList_讨论区有好解法 {

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode tmp = null;
        for (int i = 0; i < list.size() / 2; i++) {
            tmp = list.get(i).next;
            list.get(i).next = list.get(list.size() - 1 - i);
            list.get(list.size() - 1 - i).next = tmp;
        }
        if (tmp != null) {
            tmp.next = null;
        }
    }

    @Test
    public void test() {
        ListNode head = UtilListNode.fromArray(new int[]{1, 2, 3, 5, 6});
        reorderList(head);
        System.out.println(head);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000; j++) {

            }
        }
    }

}
