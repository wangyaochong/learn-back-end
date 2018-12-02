package leetcode.byNumber;

import leetcode.base.definition.ListNode;
import leetcode.base.util.UtilListNode;
import org.junit.Test;

public class p25_ReverseNodesinkGroup {


    @Test
    public void test(){
        ListNode listNode = UtilListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(reverseKGroup(listNode,3));
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<2){
            return head;
        }
        ListNode start=new ListNode(0);
        start.next=head;
        ListNode kStart=start;
        ListNode kTail=head;
        ListNode newHead=null;
        ListNode tmp;
        ListNode fast=head;
        int fastCount=0;
        while(fast!=null&&fastCount<k){
            fast=fast.next;
            fastCount++;
        }
        int count=0;
        while(head!=null&&fastCount==k){
            tmp=head.next;
            head.next=newHead;
            newHead=head;
            head=tmp;
            count++;
            if(count==k){
                kTail.next=head;
                kStart.next=newHead;
                kStart=kTail;
                kTail=head;
                count=0;

                fastCount=0;
                while(fast!=null&&fastCount<k){
                    fast=fast.next;
                    fastCount++;
                }
            }
        }
        return start.next;
    }
}
