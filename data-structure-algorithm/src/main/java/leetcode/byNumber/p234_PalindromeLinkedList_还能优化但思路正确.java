package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;
import util.UtilListNode;

public class p234_PalindromeLinkedList_还能优化但思路正确 {


    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode fast = tmp;
        ListNode slow = tmp;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        boolean isOdd = false;
        if (fast == null) {
            isOdd = true;
        }

        slow = slow.next;
        ListNode t;
        ListNode pre = null;
        ListNode revertHead = head;
        while (revertHead != null) {
            t = revertHead.next;
            revertHead.next = pre;
            pre = revertHead;
            revertHead = t;
            if (revertHead == slow) {
                break;
            }
        }

        if (isOdd) {
            pre = pre.next;
        }
        while (pre != null && slow != null && pre.val == slow.val) {
            pre = pre.next;
            slow = slow.next;
        }
        if (pre == null && slow == null) {
            return true;
        }
        return false;
    }

    public ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode t;
        ListNode revertHead = head;
        while (revertHead != null) {
            t = revertHead.next;
            revertHead.next = pre;
            pre = revertHead;
            revertHead = t;
        }
        return pre;
    }

    @Test
    public void testRevert() {
//        System.out.println(revert(UtilListNode.fromArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(isPalindrome(UtilListNode.fromArray(new int[]{1, 2, 2, 3, 1})));
    }
}
