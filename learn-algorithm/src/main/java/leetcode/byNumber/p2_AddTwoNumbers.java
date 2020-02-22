package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;

public class p2_AddTwoNumbers {

    @Test
    public void test() {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        getSumAndCarry(l1, l2, head, 0);
        return head;
    }

    public void getSumAndCarry(ListNode l1, ListNode l2, ListNode s, int carry) {
        if (l1 == null && l2 == null) {
            if (carry != 0) {
                s.val = carry;
            }
            return;
        }
        if (l1 == null) {
            int sum = l2.val + carry;
            s.val = sum % 10;
            carry = sum / 10;
            if (l2.next != null || carry != 0) {
                s.next = new ListNode(0);
            }
            getSumAndCarry(null, l2.next, s.next, carry);
        } else if (l2 == null) {
            int sum = l1.val + carry;
            s.val = sum % 10;
            carry = sum / 10;
            if (l1.next != null || carry != 0) {
                s.next = new ListNode(0);
            }
            getSumAndCarry(null, l1.next, s.next, carry);
        } else {
            int sum = l1.val + l2.val + carry;
            s.val = sum % 10;
            carry = sum / 10;
            if (l1.next != null || l2.next != null || carry != 0) {
                s.next = new ListNode(0);
            }
            getSumAndCarry(l1.next, l2.next, s.next, carry);

        }
    }
}
