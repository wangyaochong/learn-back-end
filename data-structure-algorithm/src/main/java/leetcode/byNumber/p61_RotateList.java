package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;
import util.UtilListNode;

public class p61_RotateList {
    //主要步骤，先求出长度，然后使用双指针，找到需要旋转的那一段，然后截断，最后拼接
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode nodeFast = head;
        ListNode rotatePartEnd=null;
        int length = 0;
        while (nodeFast != null) {//先求出长度，同时找到最后一个节点，用于后续的连接
            rotatePartEnd=nodeFast;
            nodeFast = nodeFast.next;
            length++;
        }
        nodeFast = head;
        k = k % length;
        if(k==0){//如果没有需要旋转的，或者旋转一整圈，则直接返回
            return head;
        }
        int count = 0;
        ListNode preRotate = nodeFast;
        while (count < length - k) { //找出需要旋转的部分，以及最后一个节点，需要设置next=null
            preRotate = nodeFast;
            nodeFast = nodeFast.next;
            count++;
        }
        preRotate.next = null;
        rotatePartEnd.next = head;
        return nodeFast;
    }

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
//        System.out.println(rotateRight(UtilListNode.fromArray(new int[]{1, 2}), 5));
        System.out.println(rotateRight2(UtilListNode.fromArray(new int[]{1, 2}), 2));
    }

}
