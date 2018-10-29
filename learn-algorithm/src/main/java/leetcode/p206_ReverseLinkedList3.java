package leetcode;

import leetcode.base.ListNode;
import leetcode.util.UtilListNode;
import org.junit.Test;

public class p206_ReverseLinkedList3 {
    @Test
    public void test() {
        ListNode x = UtilListNode.fromArray(new int[]{1, 2,3});
        System.out.println(x);
        System.out.println(reverseList(x));
    }


    public ListNode reverseList(ListNode head) {
        return reverse(head,null);
    }
    public ListNode reverse(ListNode node,ListNode newHead){
        if(node==null){
            return newHead;
        }
        ListNode tmp=node.next;
        node.next=newHead;
        return reverse(tmp,node);
    }


}
