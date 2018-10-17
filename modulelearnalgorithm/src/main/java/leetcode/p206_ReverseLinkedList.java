package leetcode;

import leetcode.base.ListNode;
import leetcode.util.UtilListNode;
import org.junit.Test;

public class p206_ReverseLinkedList {
    @Test
    public void test(){
        ListNode x = UtilListNode.fromArray(new int[]{1, 2});
        System.out.println(x);
        System.out.println(reverseList(x));
    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode s=new ListNode(0);
        reverse(head,head.next,s);
        return s.next;
    }

    public void reverse(ListNode preNode,ListNode node,ListNode head){
        if(node.next==null){
            head.next=node;
        }else{
            reverse(preNode.next,node.next,head);
        }
        node.next=preNode;
        preNode.next=null;
    }




}
