package leetcode;

import leetcode.base.ListNode;
import org.junit.Test;

public class p19_RemoveNthNodeFromEndofList2 {
    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
//        ListNode l3=new ListNode(3);
        l1.next=l2;
//        l2.next=l3;

        System.out.println(l1);
        ListNode listNode = removeNthFromEnd(l1, 2);
        System.out.println(listNode);

    }

    int depth=0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start=new ListNode();
        start.next=head;
        ListNode fast=start;
        ListNode slow=start;
        while(n>0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return start.next;
    }
    public void remove(ListNode head,int n){
        if(head==null){
            return;
        }
        remove(head.next,n);
        depth++;
        if(depth==n+1){
            head.next=head.next.next;
        }
    }

}
