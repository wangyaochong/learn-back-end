package leetcode.byCategory.链表;

import leetcode.base.definition.ListNode;
import org.junit.Test;
import util.UtilListNode;


/**
 * The type 反转部分.
 * 这道题可以分成两部分，先完成一个链表的前半部分反转，然后再转化成区间反转
 */
public class 反转部分 {


    /**
     * 第一步，获取扣除count数量的节点的剩余部分
     */
    public ListNode getEndPart(ListNode head, int count) {
        int tmpCount = 0;
        while (head != null && tmpCount < count) {
            head = head.next;
            tmpCount++;
        }
        return head;
    }

    /**
     * 第二步，反转从前往后的count个数节点
     */
    public ListNode reverseFrontPart(ListNode head, int count) {
        ListNode retHead = new ListNode();
        ListNode tmp;
        int reverseCount = 0;
        //先插入尾部的节点
        retHead.next = getEndPart(head, count);
        while (head != null && reverseCount < count) {
            tmp = head.next;
            head.next = retHead.next;
            retHead.next = head;
            reverseCount++;
            head = tmp;
        }
        return retHead.next;
    }

    /**
     * 第三步，定位到指定节点进行反转操作
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode myHead = new ListNode();
        myHead.next = head;
        int count = 0;
        head = myHead;
        while (head != null && count < m - 1) {
            head = head.next;
            count++;
        }
        ListNode next = reverseFrontPart(head.next, n - m + 1);
        head.next = next;
        return myHead.next;
    }

    @Test
    public void testReverseFrontPart() {
        System.out.println(reverseBetween(UtilListNode.fromArray(new int[]{3, 5}), 1, 2));
        System.out.println(reverseBetween(UtilListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 2, 4));
    }
}
