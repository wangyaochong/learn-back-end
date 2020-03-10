package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;

public class p160_IntersectionofTwoLinkedLists_论坛有超牛解法 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int count = 0;
        while (a != null || b != null) {
            if (a == null) {
                count--;
            } else {
                a = a.next;
            }
            if (b == null) {
                count++;
            } else {
                b = b.next;
            }
        }
        while (count < 0) {
            headB = headB.next;
            count++;
        }
        while (count > 0) {
            headA = headA.next;
            count--;
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    @Test
    public void test() {
        System.out.println(null == null);
    }
}
