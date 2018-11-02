package leetcode;

import leetcode.base.ListNode;
import leetcode.util.UtilListNode;
import org.junit.Test;

public class p206_ReverseLinkedList2 {
    @Test
    public void test(){
        ListNode x = UtilListNode.fromArray(new int[]{1, 2,3,4});
        System.out.println(x);
        System.out.println(reverseList(x));
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead=null;
        ListNode tmp=null;
        while(head!=null){
            tmp=head.next;
            head.next=newHead;
            newHead=head;
            head=tmp;
        }
        return newHead;
    }


}