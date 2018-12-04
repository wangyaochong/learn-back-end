package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import org.junit.Test;
import util.UtilListNode;

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
