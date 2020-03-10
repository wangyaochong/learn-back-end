package leetcode.byCategory.链表;

import leetcode.base.definition.ListNode;

public class 环找到环的起点 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null;
//        -------------------上面这部分代码找到相遇点x-----------------
//        将两个指针，一个从头走，一个从x走，再次相遇则是环的起点
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
